package com.demo.springboot.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HostController{

	//@GetMapping("/users/{userId}/channels")
	@RequestMapping(value = "/host", produces = "application/json")
	public String retrieveHostInfo() {
		
		String hostInfo = "";
		try {
			hostInfo = "{\"hostAddress\":\""+InetAddress.getLocalHost().getHostAddress()+"\",\"hostName\":\""+InetAddress.getLocalHost().getHostName()+"\"}";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hostInfo;
	}
}