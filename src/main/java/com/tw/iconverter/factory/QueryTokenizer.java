package com.tw.iconverter.factory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tw.iconverter.model.Tokens;
import static com.tw.iconverter.utils.Constants.QUERY_TOKEN_PATTERN;

public class QueryTokenizer implements BaseTokenizer {

	private static Logger logger = LoggerFactory.getLogger(QueryTokenizer.class);
			
	@Override
	public Tokens parseLine(String line) {
		Tokens tokens = new Tokens();
		Pattern queryPattern = Pattern.compile(QUERY_TOKEN_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher queryMatcher = queryPattern.matcher(line);

		if (queryMatcher.find()) {

			if (logger.isDebugEnabled()) {
				logger.debug("Group 1 " + queryMatcher.group(1));
				logger.debug("Group 2 " + queryMatcher.group(2));
			}
		}
		tokens.setKey("query");
		tokens.setValue(queryMatcher.group(2));
		tokens.setTokenType(TokenTypes.QUERY);
		return tokens;
	}
}
