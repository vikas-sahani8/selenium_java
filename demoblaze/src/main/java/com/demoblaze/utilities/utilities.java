package com.demoblaze.utilities;

import java.util.Date;
import java.util.Random;

public class utilities {
	public static String genrateUsername() {
		Date date = new Date();
		String timeStam = date.toString().replace(" ","").replace(":", "");
		return timeStam + "@gmail.com";
	}
	
	public static String genrateInvalidUsername() {
		  int num = new Random().nextInt(100);  
	        return String.valueOf(num);  
	}
}
