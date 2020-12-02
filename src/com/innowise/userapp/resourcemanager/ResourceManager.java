package com.innowise.userapp.resourcemanager;

import java.util.ResourceBundle;

public class ResourceManager {
	
	private final static ResourceManager instance = new ResourceManager();
	
	private ResourceBundle boundle = ResourceBundle.getBundle("resources.messages_en");
	
	public static ResourceManager getInstance () {
		return instance;
	}
	
	public String getValue (String key) {
		return boundle.getString(key);
	}



}
