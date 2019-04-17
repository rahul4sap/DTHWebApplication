package com.demo.springboot.unittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.springboot.model.Channel;
import com.demo.springboot.model.User;
import com.demo.springboot.service.DTHService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DTHServicesApplicationTests {
	
	@Autowired
	private DTHService service;
	
	private String validUserId = "10021";
	private String validUserName = "Rick Thomas";
	private int validUserChannelCount = 7;
	private int validUsersCount = 2;
	private String invalidUserId = "ABC001";
	
	 @Before	
	 public void beforeMethod(){
	 }
	  
	@After 
	public void afterMethod() {
	} 
	
	 @Test
	 public void testRetrieveUser() {
		 User user = service.retrieveUser(validUserId);
		 assertEquals("!User Retrieve Test Failed",validUserName, user.getName());
	 }
	 
	 @Test
	 public void testRetrieveAllUsers() {
		 List<User> userList = service.retrieveAllUsers();
		 assertTrue("Invalid User Count", (userList.size() == validUsersCount));
	 }
	 
	 @Test
	 public void testRetrieveChannels(String userId) {
		 List<Channel> channelsList = service.retrieveChannels(validUserId);
	    assertTrue("Invalid Channel Count", channelsList.size() == validUserChannelCount);
	 }

}
