package com.tw.iconverter.factory;

import static com.tw.iconverter.utils.Constants.INVALID_QUERY_RESPONSE;
import static com.tw.iconverter.utils.Constants.METAL_TOKEN_PATTERN;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tw.iconverter.model.Tokens;
import com.tw.iconverter.utils.RomanNumberConverter;

public class MetalTokenizer implements BaseTokenizer {

	private static Logger logger = LoggerFactory.getLogger(MetalTokenizer.class);
	private String metal_lhs_pattern = "(.*)(is{1})\\s*(\\d+)\\s*credits";
	
	@Override
	public Tokens parseLine(String line) {
		Tokens tokens = new Tokens();
		Pattern metalPattern = Pattern.compile(METAL_TOKEN_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher metalMatcher = metalPattern.matcher(line);
		StringBuilder galacticalNumeral = new StringBuilder();
		
		if (metalMatcher.find()) {
			
			if (logger.isDebugEnabled()) {
				logger.debug( "Group 1 " + metalMatcher.group(1));
				logger.debug( "Group 2 " + metalMatcher.group(2));
				logger.debug( "Group 3 " + metalMatcher.group(3));
			}
			
			double consolidatedValue = Double.parseDouble(metalMatcher.group(3));
			String metal = metalMatcher.group(1);
			
			Pattern metalpatternLHS = Pattern.compile(metal_lhs_pattern, Pattern.CASE_INSENSITIVE);
			Matcher metalMatcherLHS = metalpatternLHS.matcher(line);
			if (metalMatcherLHS.find()) {
				
				if (logger.isDebugEnabled()) {
					logger.debug( "Group 1 " + metalMatcherLHS.group(1));
					logger.debug( "Group 2 " + metalMatcherLHS.group(2));
					logger.debug( "Group 3 " + metalMatcherLHS.group(3));
				}
				
				String LHS = metalMatcherLHS.group(1);
				Arrays.asList (LHS.split(" "))
					.forEach( (e) -> {
						if (!e.equalsIgnoreCase(metal)) {
							logger.debug( "Final String -->" + galacticalNumeral.toString());
							galacticalNumeral.append(galaticalValuesMap.get(e));
						}
					});
				
				int value = RomanNumberConverter.romanToNumber(galacticalNumeral.toString());
				if (value == -1) {
					logger.info(INVALID_QUERY_RESPONSE);
					return tokens;
				}
				
				if (logger.isDebugEnabled()) {
					logger.debug( "Final String -->" + galacticalNumeral.toString());
					logger.debug( "Metal Value -->" + Double.toString(consolidatedValue/value));
				}
				
				tokens.setKey(metal);
				tokens.setValue(Double.toString(consolidatedValue/value));
				tokens.setTokenType(TokenTypes.METAL);
				//galaticalValuesMap.put(this.getKey(),this.getValue());
			}
		}
		return tokens;
	}
}
