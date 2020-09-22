package com.webdriver.utils;

public class ResourceUtils {
	
	//Returns path based on the resource name
	public static String getResourcePath(String resourceName) {
		String path = getBasePath()+resourceName;
		return path;
	}
	
	// return us the base path
	public static String getBasePath() {
		String path = ResourceUtils.class.getClassLoader().getResource(".").getPath();
		return path;
	}
}
