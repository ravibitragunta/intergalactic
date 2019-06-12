package com.tw.iconverter;

import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        String assertionKey = "Is";
        String line = "tegj is L";
        		
        
        String modified = Pattern.compile(assertionKey, Pattern.CASE_INSENSITIVE).matcher(line).replaceAll(assertionKey);
		String[] parts = modified.split(assertionKey);
		System.out.println (parts[0] + " " + parts[1]);
		
    }
}
