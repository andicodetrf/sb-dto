package com.andi.springbootdto.dto;

import lombok.Data;

@Data
public class UserLocationDTO {
	
	//info that you wanna send back to the client
	//mapping dto to entity, field names should be the same
	private long userId;
	private String email;
	private String place;
	private double longitude;
	private double latitude;
	
	
	
	
	
	
	

}
