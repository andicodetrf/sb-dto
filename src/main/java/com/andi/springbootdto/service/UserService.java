package com.andi.springbootdto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andi.springbootdto.dto.UserLocationDTO;
import com.andi.springbootdto.model.User;
import com.andi.springbootdto.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserLocationDTO> getAllUsersLocation(){
		
		return userRepository.findAll()
				.stream()
				.map(this::convertEntityToDTO)
				.collect(Collectors.toList());
		
	}
	
	
	private UserLocationDTO convertEntityToDTO(User user) {
		UserLocationDTO userLocationDTO = new UserLocationDTO();
		userLocationDTO.setUserId(user.getId());
		userLocationDTO.setEmail(user.getEmail());
		userLocationDTO.setPlace(user.getLocation().getPlace());
		userLocationDTO.setLongitude(user.getLocation().getLongitude());
		userLocationDTO.setLatitude(user.getLocation().getLatitude());
		
		return userLocationDTO;
		
		
		
	}
}
