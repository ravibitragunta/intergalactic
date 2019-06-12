package com.tw.iconverter.lexer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tw.iconverter.utils.RomanNumberConverter;

import static com.tw.iconverter.utils.Constants.*;
import model.GalacticalToken;

public class CustomLexer {

	private static List<String> questionKeys = new ArrayList<>();
	private static List<String> statementKeys = new ArrayList<>();
	private static Map<String, String> galaticalValuesMap = GalacticalToken.getInstance().getTokenValueMap();
	private static Logger logger = LoggerFactory.getLogger(RomanNumberConverter.class);

	public CustomLexer() {
		questionKeys.add("how");
		questionKeys.add("why");
		questionKeys.add("what");
		questionKeys.add("where");
		questionKeys.add("when");
		questionKeys.add("how many");

		statementKeys.add("is");
		statementKeys.add("are");
	}

	private boolean isQuery(String line) {
		for (String questionKey : questionKeys) {
			if (line.toLowerCase().contains(questionKey.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	
	public List<String> splitString (String splitKey, String line) {
		String modified = Pattern.compile(splitKey, Pattern.CASE_INSENSITIVE)
				.matcher(line)
				.replaceAll(splitKey);
		return Arrays.asList(modified.split(splitKey));
	}

	public void tokenise(String line) {
		
		if (logger.isInfoEnabled()) {
			logger.info( "parsing " + line);
		}
		
		for (String assertionKey : statementKeys) {
			if (line.toLowerCase().contains(assertionKey.toLowerCase())) {
				if(parseMetalValue(line, assertionKey)) {
					continue;
				}
				List <String> parsedTokens = splitString(assertionKey, line);
				
				if (logger.isInfoEnabled()) {
					logger.info( "key " + parsedTokens.get(0).trim());
					logger.info( "value " + parsedTokens.get(1).trim());
				}
				
				galaticalValuesMap.put(parsedTokens.get(0).trim(), parsedTokens.get(1).trim());
			}
		}
	}
	
	public boolean parseMetalValue(String line, String assertionKey) {
		boolean isMetal = false;
		StringBuilder galacticalNumeral = new StringBuilder();
		
		for (String metal : GALACTICAL_METALS) {
			if (line.toLowerCase().contains(metal.toLowerCase())) {
				isMetal = true;
				if (!galaticalValuesMap.containsKey(metal)) {
					List <String> parsedTokens = splitString(assertionKey, line);
					
					Arrays.asList(parsedTokens.get(0).split(" "))
						.forEach((e) -> {
							if (!e.equalsIgnoreCase(metal)) {
								
								if (logger.isInfoEnabled()) {
									logger.info( "e " + e);
									logger.info( "value " + galaticalValuesMap.get(e));
								}
								
								galacticalNumeral.append(galaticalValuesMap.get(e));
							}
						});
					
					if (logger.isInfoEnabled()) {
						logger.info( "romanNumeral " + galacticalNumeral.toString());
						logger.info( "value " + parsedTokens.get(1).trim());
					}
					
					int value = RomanNumberConverter.romanToNumber(galacticalNumeral.toString());
					
					if (logger.isInfoEnabled()) {
						logger.info( "value " + value);
					}
					
					if (value == -1) {
						break;
					}
					String[] credits = parsedTokens.get(1).split(" ");
					if (logger.isInfoEnabled()) {
						logger.info( "credits " + credits[1]);
					}
					
					try {
						int creditValue = Integer.parseInt(credits[1]);
						double metalValue = creditValue/value;
						if (logger.isInfoEnabled()) {
							logger.info( "creditValue " + Double.toString(metalValue));
						}
						
						galaticalValuesMap.put(metal, Double.toString(metalValue));
						
					} catch (NumberFormatException e) {
						break;
					}
				}
			}
		}
		return isMetal;
	}
}
