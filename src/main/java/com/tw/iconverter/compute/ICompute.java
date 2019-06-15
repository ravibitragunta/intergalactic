package com.tw.iconverter.compute;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tw.iconverter.model.GalacticalToken;
import com.tw.iconverter.utils.Metals;
import com.tw.iconverter.utils.RomanNumberConverter;

public interface ICompute {
	static Map<String, String> galaticalValuesMap = Collections
			.unmodifiableMap(GalacticalToken.getInstance().getTokenValueMap());

	public void compute(String token);

	default double evaluateExpression(String expression) {
		StringBuilder galacticalNumeral = new StringBuilder();
		String metalSearch = "(Silver|Gold|Iron){1}";

		Pattern metalPattern = Pattern.compile(metalSearch, Pattern.CASE_INSENSITIVE);
		Matcher metalMatcher = metalPattern.matcher(expression);
		
		Arrays.asList(expression.split(" ")).forEach((e) -> {
			if (!Metals.compareValue(e) && e != null) {
				galacticalNumeral.append(galaticalValuesMap.get(e));
			}
		});

		int value = 1;

		if (galacticalNumeral.length() > 0) {
			value = RomanNumberConverter.romanToNumber(galacticalNumeral.toString());
		}
		
		if (metalMatcher.find()) {
			String metal = null;
			metal = metalMatcher.group(1);
			Double metalValue = 1d;
			if (metal != null) {
				try {
					metalValue = Double.parseDouble(galaticalValuesMap.get(metal)) * value;
					return metalValue;

				} catch (Exception e) {
					metalValue = -1d;
				}
				return metalValue;
			} 
		}
		return value;

	}

}
