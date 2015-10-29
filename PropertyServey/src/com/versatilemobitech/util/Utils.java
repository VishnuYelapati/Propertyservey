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
	
	
	public static boolean isValidMail(String email2) 
	{
	    boolean check;
	    Pattern p;
	    Matcher m;

	    String EMAIL_STRING = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	    p = Pattern.compile(EMAIL_STRING);

	    m = p.matcher(email2);
	    check = m.matches();

	    if(!check)
	    {
	    	 
	    }
	    return check;
	}
	
	
	private boolean isValidMobile(String phone2) 
	{
	    boolean check=false;
	    if(!Pattern.matches("[a-zA-Z]+", phone2))
	    {
	        if(phone2.length() < 6 || phone2.length() > 13)
	        {
	            check = false;
	           
	        }
	        else
	        {
	            check = true;
	        }
	    }
	    else
	    {
	        check=false;
	    }
	    return check;
	}
	
	
	 
	
	public static int actualLength(String phone)
	{
		Long number=Long.parseLong(phone);
		
		if(number>0)
		{
		int length = (int)(Math.log10(number)+1);
		return length;
		}
		else
		return 0;
		
	}
}
