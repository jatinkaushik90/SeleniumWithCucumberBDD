package com.webdriver;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Temp {
	
	public static void main(String[] args) throws IOException {
		String timestamp = new Timestamp(System.currentTimeMillis()).toString().replace(" ", "_").replace(":", "_").replace(".", "_");
		System.err.println("Yellow_"+timestamp+".png");
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date())+".png";
		System.err.println("Yellow_"+timeStamp);
	}
}
