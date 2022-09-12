package com.mystruts.services;

import java.io.UnsupportedEncodingException;

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
	public static boolean checkCorrectDateOfBirth(String str) {
		return true;
	}
}
