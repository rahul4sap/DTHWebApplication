package com.demo.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.model.Channel;
import com.demo.springboot.service.DTHService;

@RestController
public class UserController {

	@Autowired
	private DTHService dthService;

	//@GetMapping("/users/{userId}/channels")
	@RequestMapping(value = "/users/{userId}/channels", produces = "application/json")
	public List<Channel> retrieveCoursesForStudent(@PathVariable String userId) {
		return dthService.retrieveChannels(userId);
	}
}