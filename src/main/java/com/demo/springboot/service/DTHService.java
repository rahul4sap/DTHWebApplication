package com.demo.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.springboot.model.Channel;
import com.demo.springboot.model.User;

@Component
public class DTHService {

	private static List<User> users = new ArrayList<>();

	static {
		// Initialize Data
		Channel channel1 = new Channel("CH001", "HBO", "images/hbo_logo.png");
		Channel channel2 = new Channel("CH002", "Star Movies", "images/star_movies_logo.png");
		Channel channel3 = new Channel("CH003", "Sony SIX", "images/sony_six_logo.png");
		Channel channel4 = new Channel("CH004", "CNN", "images/cnn_logo.png");
		Channel channel5 = new Channel("CH005", "BBC", "images/bbc_logo.png");
		Channel channel6 = new Channel("CH006", "TIMES NOW", "images/times_now_logo.png");
		Channel channel7 = new Channel("CH007", "Star Sports", "images/star_sports_logo.png");
		
		List<Channel> group1 = new ArrayList<Channel>();
		group1.add(channel1);
		group1.add(channel2);
		group1.add(channel3);
		group1.add(channel4);
		group1.add(channel5);
		group1.add(channel6);
		group1.add(channel7);
		
		List<Channel> group2 = new ArrayList<Channel>();
		group2.add(channel4);
		group2.add(channel5);
		group2.add(channel6);
		group2.add(channel7);
		
		User user1 = new User("10021", "Rick Thomas",group1);
		User user2 = new User("10099", "Jack Dawson",group2);

		users.add(user1);
		users.add(user2);
	}

	public User retrieveUser(String userId) {
		for (User user : users) {
			if (user.getId().equals(userId)) {
				return user;
			}
		}
		return null;
	}
	
	
	public List<User> retrieveAllUsers() {
		return users;
	}

	public List<Channel> retrieveChannels(String userId) {
		User user = retrieveUser(userId);
		if (user == null) {
			return null;
		}
		return user.getChannels();
	}
}