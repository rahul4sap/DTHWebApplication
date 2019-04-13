package com.demo.springboot.model;


import java.util.List;

public class User {
	private String id;
	private String name;
	private List<Channel> channels;

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	public User(String id, String name,List<Channel> channels) {
		super();
		this.id = id;
		this.name = name;
		this.channels = channels;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}