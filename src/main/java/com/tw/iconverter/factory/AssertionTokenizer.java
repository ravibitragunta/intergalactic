package com.tw.iconverter.factory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tw.iconverter.model.Tokens;

import static com.tw.iconverter.utils.Constants.ASSERTION_TOKEN_PATTERN;

public class AssertionTokenizer implements BaseTokenizer {
	
	private static Logger logger = LoggerFactory.getLogger(AssertionTokenizer.class);
	Tokens tokens = new Tokens();
	
	@Override
	public Tokens parseLine(String line) {
		
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
			tokens.setKey(assertionMatcher.group(1));
			tokens.setValue(assertionMatcher.group(3));
			tokens.setTokenType(TokenTypes.ASSERT);
		}
		return tokens;
	}

}
