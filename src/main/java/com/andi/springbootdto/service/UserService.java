package com.andi.springbootdto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andi.springbootdto.dto.UserLocationDTO;
import com.andi.springbootdto.model.User;
import com.andi.springbootdto.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<User> getAllUsersLocationFromEntity(){
		//directly return from Entity to client
		return userRepository.findAll();
	}
	
	public List<UserLocationDTO> getAllUsersLocationViaDTO(){
		//map to DTO from Entity, return DTO to client
		return userRepository.findAll()
				.stream()
				.map(this::convertEntityToDTO)
				.collect(Collectors.toList());
	}
	
		
	
	//manual mapping from entity to dto
//	private UserLocationDTO convertEntityToDTO(User user) {
//		UserLocationDTO userLocationDTO = new UserLocationDTO();
//		userLocationDTO.setUserId(user.getId());
//		userLocationDTO.setEmail(user.getEmail());
//		userLocationDTO.setPlace(user.getLocation().getPlace());
//		userLocationDTO.setLongitude(user.getLocation().getLongitude());
//		userLocationDTO.setLatitude(user.getLocation().getLatitude());
//		
//		return userLocationDTO;
//	}
	
	
	//mapping using modelMapper library
	private UserLocationDTO convertEntityToDTO(User user) {
		
		//configures mapping to find references for location under user
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		
		UserLocationDTO userLocationDTO = new UserLocationDTO();
		
		userLocationDTO = modelMapper.map(user, UserLocationDTO.class);
		
		return userLocationDTO;
		
		//result without configuring modelMapper matching strategy - unable to find reference to location cls from user cls.
		//[{"userId":1,"email":"p123@gmail.com","place":null,"longitude":0.0,"latitude":0.0},
		//{"userId":2,"email":"t123@gmail.com","place":null,"longitude":0.0,"latitude":0.0}]
		
		
		//result with modelmapper config
		//[{"userId":1,"email":"p123@gmail.com","place":"SG","longitude":40.5,"latitude":30.6},
		 //{"userId":2,"email":"t123@gmail.com","place":"SG","longitude":40.5,"latitude":30.6}]
	}
}
