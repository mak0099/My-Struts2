package com.mystruts.services;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public static boolean checkFullWidthCaracter(String str) {
		try {
			if (str.getBytes("MS932").length != 2 * str.length()) {
				return false;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return true;
	}
	public static boolean checkContainSymbol(String str) {
		Pattern p = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(str);
		return m.find();
	}
	public static boolean checkCorrectDateOfBirth(Date date) {
		int diff = date.compareTo(new Date());
		if(diff > 0) {
			return false;
		}
		return true;
	}
}
