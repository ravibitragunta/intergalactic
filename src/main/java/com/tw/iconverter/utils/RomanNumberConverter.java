package com.tw.iconverter.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RomanNumberConverter {

	private static final String ROMAN_LITERAL_REGEX_PATTERN = "^(?=[MDCLXVI])M{0,3}(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$";
	private static Logger logger = LoggerFactory.getLogger(RomanNumberConverter.class);

	public static boolean validateRomanLiteral(String romanLiteral) {

		Pattern regex = Pattern.compile(ROMAN_LITERAL_REGEX_PATTERN);
		Matcher regexMatcher = regex.matcher(romanLiteral);

		return regexMatcher.matches();

	}

	public static int romanToNumber(String romanLiteral) {

		String romanNumeral = romanLiteral.toUpperCase();

		if (logger.isInfoEnabled()) {
			logger.info("Pattern matching for " + romanNumeral);
		}

		int result = 0;

		if (!validateRomanLiteral(romanNumeral)) {

			if (logger.isInfoEnabled()) {
				logger.info(romanLiteral + " is not valid roman number");
			}
			return -1;
		} else {

			List<RomanNumbers> romanNumerals = RomanNumbers.getSortedValues();
			int i = 0;

			while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
				RomanNumbers symbol = romanNumerals.get(i);
				if (romanNumeral.startsWith(symbol.name())) {
					result += symbol.getValue();
					romanNumeral = romanNumeral.substring(symbol.name().length());
				} else {
					i++;
				}
			}
			return result;
		}
	}

}
