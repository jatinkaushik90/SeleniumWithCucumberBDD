package com.webdriver;

import java.io.IOException;

import org.testng.annotations.Test;

public class AbsolutePath {
	
	//Testing - get the absolute path of a file at runtime
	
	@Test
	public void test() throws IOException {
		
		String path = AbsolutePath.class.getClassLoader().getResource("config.properties").getPath();
		System.out.println(path);
	}
}