package com.andi.springbootdto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andi.springbootdto.dto.UserLocationDTO;
import com.andi.springbootdto.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users-location")
	public List<UserLocationDTO> getAllUsersLocation(){
		return userService.getAllUsersLocation();
	}
}
