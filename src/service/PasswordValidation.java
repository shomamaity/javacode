package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class PasswordValidation {
	
	
	public static void main(String[] args) {

	    try (Scanner in = new Scanner(System.in)) {
			System.out.print("Please enter a password : ");
			String password = in.nextLine();
   
			// declare errorList to get all error message list
			List<String> errorList = new ArrayList<String>();

			while (!isPasswordValid(password, errorList)) {
			    
			    for (String error : errorList) {
			        System.out.println(error);
			    }

			    System.out.print("Please enter a given  password : ");
			    password = in.nextLine();
			    
			}
		}

	    System.out.println( "entered password is valid");
	    

	}
	
	
	/**
	 isPasswordValid method is used to validate password with conditions:
	   	1. - password should be larger than 8 chars
		2. - password should not be null
		3. - password should have one uppercase letter at least
		4. - password should have one lowercase letter at least
		5. - password should have one number at least
		Compute below rules :
		Password is OK if at least three of the previous conditions is true
		password is never OK if item 1.d is not true.
		
		@author Soma Maity
		@param String password, List errorList
		@return boolean
	 
	 **/
	
	public static boolean isPasswordValid(String password, List<String> errorList) {
	

    Pattern upperCasePatten = Pattern.compile("[A-Z ]");
    Pattern lowerCasePatten = Pattern.compile("[a-z ]");
    Pattern digitCasePatten = Pattern.compile("[0-9 ]");
    errorList.clear();
	
	 boolean flag=true;
	    
	    // if password is null, then all other condition should not execute and return error.
	 	if (password.trim().isEmpty()) {
	 			errorList.add("password should not be null");
	 			return false;
	 	}
	 	
	 	 // password is never OK if password do not contain at least one lowercase
	    if (!lowerCasePatten.matcher(password).find()) {
	        errorList.add("password should have one lowercase letter at least");
	        return false;
	    }
	    // password should be larger than 8 chars
	    if (password.length() < 8) {
	        errorList.add("password should be larger than 8 chars");
	        flag = false;
	    }else {
	    	flag = true;
	    }
	    // password should have one uppercase letter at least
	    if (!upperCasePatten.matcher(password).find()) {
	        errorList.add(" password should have one uppercase letter at least");
	        flag= false;
	    }
	    else {
	    	return true;
	    }
	   // password should have one number at least
	    if (!digitCasePatten.matcher(password).find()) {
	        errorList.add("password should have one number at least");
	        flag=false;
	    }
	    else {
	    	return true;
	    }
	    
	    return flag;

	}
}
