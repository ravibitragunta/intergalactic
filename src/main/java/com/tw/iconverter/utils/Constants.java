package com.tw.iconverter.utils;

import java.util.Arrays;
import java.util.List;

public final class Constants {
	
	public static final List<String> GALACTICAL_METALS = 
				Arrays.asList(new String[]{"Gold", "Silver", "Iron"});
	
	public static final String ASSERTION_TOKEN_PATTERN =
				"([A-Z]+).*(is{1})\\s*([I|IV|V|IX|X|XL|L|XC|C|CD|D|CM|M])";
	
	public static final String METAL_TOKEN_PATTERN = 
				"(Silver|Gold|Iron)?\\s*(is{1})\\s*(\\d+)\\s*credits";
	
	public static final String QUERY_TOKEN_PATTERN = 
			"^(how much|how many)?\\s*.*(\\sis{1})\\s*(.*)\\?";
	
	public static final String INVALID_QUERY_RESPONSE = "I have no idea what you are talking about";
	
	 
}
