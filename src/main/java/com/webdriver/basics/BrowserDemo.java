package com.webdriver.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriverManager.edgedriver().browserVersion("84").setup();
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.youtube.com/");
		Thread.sleep(3000);
		System.out.println(driver.toString());
		driver.quit();
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.youtube.com/");
		Thread.sleep(3000);
		System.out.println(driver.toString());
		driver.quit();
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.youtube.com/");
		Thread.sleep(3000);
		System.out.println(driver.toString());
		driver.quit();
		
		
	}
}
