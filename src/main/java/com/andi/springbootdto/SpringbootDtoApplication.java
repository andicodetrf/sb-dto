package com.andi.springbootdto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andi.springbootdto.model.Location;
import com.andi.springbootdto.model.User;
import com.andi.springbootdto.repository.LocationRepository;
import com.andi.springbootdto.repository.UserRepository;

@SpringBootApplication
public class SpringbootDtoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDtoApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LocationRepository locationRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Location location = new Location();
		location.setPlace("Pune");
		location.setDescription("Great place to live");
		location.setLongitude(40.5);
		location.setLatitude(30.6);
		
		locationRepository.save(location);
		
		User user1 = new User();
		user1.setFirstName("Peter");
		user1.setLastName("Parker");
		user1.setEmail("p123@gmail.com");
		user1.setPassword("secret");
		user1.setLocation(location);
		userRepository.save(user1);
		
		User user2 = new User();
		user2.setFirstName("Tony");
		user2.setLastName("Stark");
		user2.setEmail("t123@gmail.com");
		user2.setPassword("secret2");
		user2.setLocation(location);
		userRepository.save(user2);
		
	}

}
