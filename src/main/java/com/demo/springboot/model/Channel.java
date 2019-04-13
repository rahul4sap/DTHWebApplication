package com.demo.springboot.model;

public class Channel {
	private String id;
	private String name;
	private String src;
	
	public Channel() {

	}

	public Channel(String id, String name, String src) {
		super();
		this.id = id;
		this.name = name;
		this.src = src;
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

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	
}