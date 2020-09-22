package com.webdriver.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigProperties implements IReader {

	private Properties properties;
	
	public ReadConfigProperties() {
		initProperties("");
	}
	
	public ReadConfigProperties(String fileName){
		initProperties(fileName);
	}

	private void initProperties(String fileName) {
		if (isDefaultPropertiesFile(fileName)) {
			properties = getDataFromProperties("config.properties");
		} else {
			properties = getDataFromProperties(fileName);
		}
	}

	private Properties getDataFromProperties(String fileName) {

		String path = ResourceUtils.getResourcePath(fileName);
		Properties prop = new Properties();

		try {
			InputStream inStream = new FileInputStream(new File(path));
			prop.load(inStream);

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return prop;
	}

	private boolean isDefaultPropertiesFile(String fileName) {
		if ("".equalsIgnoreCase(fileName)) {
			return true;
		}
		return false;
	}

	@Override
	public String getApplicationUrl() {
		return properties.getProperty("ApplicationUrl");
	}

	@Override
	public String getBrowserName() {
		return properties.getProperty("BrowserName");
	}

	@Override
	public String getUserName() {
		return properties.getProperty("UserName");
	}

	@Override
	public String getPassword() {
		return properties.getProperty("Password");
	}

	@Override
	public int getExplicitWait() {
		return Integer.parseInt(properties.getProperty("ExplicitWait"));
	}

}
