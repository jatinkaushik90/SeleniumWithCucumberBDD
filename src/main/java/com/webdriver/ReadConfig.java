package com.webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import com.webdriver.utils.ResourceUtils;

public class ReadConfig {
	
	@Test
	public void testMethod () throws IOException {
		
		String resourceName = "config.properties";
		String resourcePath = ResourceUtils.getResourcePath(resourceName);
		System.err.println(resourcePath);
		
		Properties prop = new Properties();
		InputStream inStream = new FileInputStream(new File(resourcePath));
		prop.load(inStream);
		
		System.out.println(prop.getProperty("BrowserName"));
		System.out.println(prop.getProperty("ApplicationUrl"));
		System.out.println(prop.getProperty("UserName"));
		System.out.println(prop.getProperty("Password"));
		System.out.println(prop.getProperty("ExplicitWait"));
	}
}
