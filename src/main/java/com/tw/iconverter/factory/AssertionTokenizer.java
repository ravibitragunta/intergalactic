package com.tw.iconverter.factory;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.GalacticalToken;

import static com.tw.iconverter.utils.Constants.ASSERTION_TOKEN_PATTERN;

public class AssertionTokenizer extends BaseTokenizer {
	
	private static Logger logger = LoggerFactory.getLogger(AssertionTokenizer.class);
	private static Map<String, String> galaticalValuesMap =
			GalacticalToken.getInstance().getTokenValueMap();
	@Override
	public void parseLine(String line) {
		
		if (logger.isDebugEnabled()) {
			logger.debug( "parsing " + line);
		}
		
		Pattern assertionPattern = Pattern.compile(ASSERTION_TOKEN_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher assertionMatcher = assertionPattern.matcher(line);
		
		if (assertionMatcher.find()) {
			if (logger.isDebugEnabled()) {
				logger.debug( "Group 1 " + assertionMatcher.group(1));
				logger.debug( "Group 2 " + assertionMatcher.group(2));
				logger.debug( "Group 3 " + assertionMatcher.group(3));
			}
			this.setKey(assertionMatcher.group(1));
			this.setValue(assertionMatcher.group(3));
			this.setTokenType(TokenTypes.ASSERT);
			galaticalValuesMap.put(this.getKey(),this.getValue());
		}
		
	}

}
