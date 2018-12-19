package org.iit.mmp.tests;

import java.util.Calendar;
import java.util.Random;

public class DynamicData {
	
	public static void main(String[] args) {
		
		// Generate a 4 - digit random number
		 
		Random rnd = new Random();
		//https://upload.wikimedia.org/wikipedia/commons/1/1b/ASCII-Table-wide.svg
		//97-122 a-z
		//65-90 A-Z
		char c = (char)(65+rnd.nextInt(26));
		System.out.println("Character value:::" + c);
		
//		System.out.println("test"+n+"_"+c+"@gmail.com");
//		System.out.println(c+"tester"+n);
		
		System.out.println(Calendar.getInstance().getTimeInMillis()%100000);
		
		 
//		int n = 999+rnd.nextInt(1000);
//		System.out.println(n);
		
		
		int n1 = getRandomNumber(99999,4);
		System.out.println(n1);
	}
	 
	
	public static int getRandomNumber(int limit,int digits)
    {
    	Random rnd = new Random();
    	String value="";
    	for(int i=0;i<digits;i++)
    	{
    		value = value+"9";
    		System.out.println("Value is :: " + value);
    	}
    	int randomNumber = rnd.nextInt(limit);
    	System.out.println("Random number" + randomNumber);
    	int result = Integer.parseInt(value)+randomNumber;
    	return result;
    }

}
