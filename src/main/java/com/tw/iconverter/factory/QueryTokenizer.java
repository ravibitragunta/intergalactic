package com.tw.iconverter.factory;

import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tw.iconverter.utils.Metals;
import com.tw.iconverter.utils.RomanNumberConverter;

import model.GalacticalToken;
import static com.tw.iconverter.utils.Constants.QUERY_TOKEN_PATTERN;
import static com.tw.iconverter.utils.Constants.INVALID_QUERY_RESPONSE;

public class QueryTokenizer extends BaseTokenizer {

	private static Logger logger = LoggerFactory.getLogger(QueryTokenizer.class);
	private String metalSearch = "(Silver|Gold|Iron){1}";
	private static Map<String, String> galaticalValuesMap = GalacticalToken.getInstance().getTokenValueMap();

	@Override
	public void parseLine(String line) {
		Pattern queryPattern = Pattern.compile(QUERY_TOKEN_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher queryMatcher = queryPattern.matcher(line);
		StringBuilder galacticalNumeral = new StringBuilder();

		if (queryMatcher.find()) {

			if (logger.isDebugEnabled()) {
				logger.debug("Group 1 " + queryMatcher.group(1));
				logger.debug("Group 2 " + queryMatcher.group(2));
				logger.debug("Group 3 " + queryMatcher.group(3));
			}

			String queryString = queryMatcher.group(3);

			Pattern metalPattern = Pattern.compile(metalSearch, Pattern.CASE_INSENSITIVE);
			Matcher metalMatcher = metalPattern.matcher(line);
			String metal = null;
			if (metalMatcher.find()) {

				if (logger.isDebugEnabled()) {
					logger.debug("Group 1 " + metalMatcher.group(1));
				}

				metal = metalMatcher.group(1);
			}
			
			Arrays.asList(queryString.split(" ")).forEach((e) -> {

				if (!Metals.compareValue(e) ){

					if (logger.isDebugEnabled()) {
						logger.debug("Key -->" + e);
						logger.debug("value -->" + galaticalValuesMap.get(e));
					}
					galacticalNumeral.append(galaticalValuesMap.get(e));
				}
			});

			int value = RomanNumberConverter.romanToNumber(galacticalNumeral.toString());
			
			if (value == -1) {
				logger.info(INVALID_QUERY_RESPONSE);
				return;
			}
				

			if (logger.isDebugEnabled()) {
				logger.debug("Final String -->" + galacticalNumeral.toString());
				logger.debug("Metal Value -->" + Double.toString(value));
				logger.debug("metal -->" + metal);
			}
			this.setKey(queryString);
			this.setTokenType(TokenTypes.QUERY);
			if (metal != null) {
				try {
					Double metalValue = Double.parseDouble(galaticalValuesMap.get(metal)) * value;

					if (logger.isDebugEnabled()) {
						logger.debug("Final String -->" + galacticalNumeral.toString());
						logger.debug("Metal Value -->" + Double.toString(metalValue));
					}
					this.setValue(Double.toString(metalValue) + " Credits");
				} catch (Exception e) {
					logger.info("Invalid Input. Cannot process this line.");
				}
			} else {
				this.setValue(Integer.toString(value));
			}

			logger.info(this.getKey() + " is " + this.getValue());

		} else {
			logger.info(INVALID_QUERY_RESPONSE);
		}
	}
}
