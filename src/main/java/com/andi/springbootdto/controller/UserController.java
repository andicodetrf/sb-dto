package com.andi.springbootdto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andi.springbootdto.dto.UserLocationDTO;
import com.andi.springbootdto.model.User;
import com.andi.springbootdto.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users-location-ent")
	public List<User> getAllUsersLocation1(){
		return userService.getAllUsersLocationFromEntity();
		
//		[
//		 {"id":1,"email":"p123@gmail.com","firstName":"Peter","lastName":"Parker","password":"secret","location":{"id":1,"place":"SG","description":"Great place to live","longitude":40.5,"latitude":30.6}},
//		 {"id":2,"email":"t123@gmail.com","firstName":"Tony","lastName":"Stark","password":"secret2","location":{"id":1,"place":"SG","description":"Great place to live","longitude":40.5,"latitude":30.6}}
//		]
		
	}
	
	
	@GetMapping("/users-location-dto")
	public List<UserLocationDTO> getAllUsersLocation2(){
		return userService.getAllUsersLocationViaDTO();
		
//		[
//		 {"userId":1,"email":"p123@gmail.com","place":"SG","longitude":40.5,"latitude":30.6},
//		 {"userId":2,"email":"t123@gmail.com","place":"SG","longitude":40.5,"latitude":30.6}
//		]
	}
	
	
	
}
