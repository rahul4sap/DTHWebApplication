package com.demo.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.springboot.model.Channel;
import com.demo.springboot.service.DTHService;

@RestController
public class UserController {

	@Autowired
	private DTHService dthService;
	
	@Autowired
	private RestTemplate restTemplate;

	//@GetMapping("/users/{userId}/channels")
	@RequestMapping(value = "/users/{userId}/channels", produces = "application/json")
	public List<Channel> retrieveCoursesForStudent(@PathVariable String userId) {
		return dthService.retrieveChannels(userId);
	}
	
	@RequestMapping(value = "/users/{userId}/address", produces = "application/json")
	public String retrieveAddress(@PathVariable String userId) {
		 String result = restTemplate.getForObject("http://addressapplication:8080/users/"+userId+"/address", String.class);
		 return result;
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}