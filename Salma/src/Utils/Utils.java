package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Utils {
	
	public static Scanner scan = new Scanner(System.in);
	
	private static SimpleDateFormat dateformat = new SimpleDateFormat();
	
	public static int nextInt(int defaultValue){
		int input;
		input = defaultValue;
		
		try{
			input = scan.nextInt();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return input;
	}
	
	public static String nextLine(){
		return scan.nextLine();
	}
	
	public static Boolean verifyEmail(String inputEmail){
		if(!inputEmail.endsWith("@gmail.com")){
			return false;
		}
		
		if(inputEmail.length() <= 10){
			return false;
		}
		int alpha = 0;
		int digit = 0;
		for(Character c : inputEmail.toCharArray()){
			
			if(c.equals('@')){
				break;
			}
			
			if(Character.isAlphabetic(c)){
				alpha++;
			} else if(Character.isDigit(c)){
				digit++;
			}
		}
		
		if(alpha + digit != inputEmail.length() - 10){
			return false;
		}
		
		return true;
	}
	
	public static Boolean verifyPass(String inputPass){
		
		if(inputPass.length() < 6){
			return false;
		}
		
		int alpha = 0;
		int digit = 0;
		for(Character c : inputPass.toCharArray()){
			if(Character.isAlphabetic(c)){
				alpha++;
			} else if(Character.isDigit(c)){
				digit++;
			}
		}
		
		if(alpha + digit != inputPass.length() || alpha == 0 || digit == 0){
			return false;
		}
		
		return true;
		
	}
	
	public static Boolean verifyName(String inputName){
		if(inputName.length() < 4){
			return false;
		}
		
		int alpha = 0;
		int digit = 0;
		for(Character c : inputName.toCharArray()){
			if(Character.isAlphabetic(c)){
				alpha++;
			} else if(Character.isDigit(c)){
				digit++;
			}
		}
		
		if(digit != 0){
			return false;
		}
		
		if(alpha != inputName.length()){
			return false;
		}
		
		return true;
	}
	
	public static String datetoString (Date date)
	{
		return dateformat.format(date);
	}
	
}