package com.tw.iconverter.factory;

import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.tw.iconverter.utils.Constants.*;

public class TokenizerFactory {

	private static Logger logger = LoggerFactory.getLogger(TokenizerFactory.class);
	public static BaseTokenizer getTokenizer(String line) {
		Pattern pattern = null;
		if (pattern.compile(ASSERTION_TOKEN_PATTERN, Pattern.CASE_INSENSITIVE).matcher(line).find()) {
			if (logger.isDebugEnabled()) {
				logger.debug("Assertion Matched");
			}
			return new AssertionTokenizer();
		}

		else if (pattern.compile(METAL_TOKEN_PATTERN, Pattern.CASE_INSENSITIVE).matcher(line).find()) {
			if (logger.isDebugEnabled()) {
				logger.debug("Metal Matched");
			}
			return new MetalTokenizer();
		}

		else if (pattern.compile(QUERY_TOKEN_PATTERN, Pattern.CASE_INSENSITIVE).matcher(line).find()) {
			if (logger.isDebugEnabled()) {
				logger.debug("Query Matched");
			}
			return new QueryTokenizer();
		}

		else {
			logger.info(INVALID_QUERY_RESPONSE);
			return null;
		}
			
			
	}
}
