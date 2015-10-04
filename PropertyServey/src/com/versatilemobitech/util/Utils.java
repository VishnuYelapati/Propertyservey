package com.versatilemobitech.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Utils {

	private Pattern pattern;
	private Matcher matcher;
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public Utils(){
		  pattern = Pattern.compile(EMAIL_PATTERN);

	}
	
	public boolean validate(String hex) {

		matcher = pattern.matcher(hex);
		return matcher.matches();

	}
}
