package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.InvalidApplicationException;

import empdetails.exceptions.InvalidDetailsException;



public class ValidateEmployee {
	public boolean validateName(String name) throws InvalidDetailsException, Exception{
		Pattern p = Pattern.compile("^[A-Z][a-zA-Z\\s]{3,19}");
		Matcher m = p.matcher(name);
		if(m.find()) 
			return true;
		else
			throw new InvalidApplicationException(name + " is not a valid name");
	}
}