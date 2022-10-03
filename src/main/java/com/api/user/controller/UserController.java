package com.api.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.api.user.entity.User;
import com.api.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/status")
	public String appStatus() {
		return "User Micro Service Application is up & running";
	}
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") Long userId) {
        
		User user = this.userService.getUser(userId);
		
		List contacts = this.restTemplate.getForObject("http://contact-service/contact/user/"+ user.getUserId(), List.class);
		
		user.setContacts(contacts);
		
		return user;
	}
}
