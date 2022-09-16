package com.mystruts.services;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class AppService {
	
	public static boolean checkHalfWidthCaracter(String str) {
		try {
			if (str.getBytes("MS932").length > str.length()) {
				return false;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return true;
	}
	public static boolean checkCorrectDateOfBirth(Date date) {
		int diff = date.compareTo(new Date());
		if(diff > 0) {
			return false;
		}
		return true;
	}
}
