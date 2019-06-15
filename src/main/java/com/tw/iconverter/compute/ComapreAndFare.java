package com.tw.iconverter.compute;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tw.iconverter.model.GalacticalToken;
import static com.tw.iconverter.utils.Constants.CUSTOM_QUERY_TOKEN_PATTERN;

public class ComapreAndFare  implements ICompute{
	static Map<String, String> galaticalValuesMap =
			Collections.unmodifiableMap(GalacticalToken.getInstance().getTokenValueMap());
	private static Logger logger = LoggerFactory.getLogger(ComapreAndFare.class);

	public void compute (String token) {
		
		Pattern queryPattern = Pattern.compile(CUSTOM_QUERY_TOKEN_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher queryMatcher = queryPattern.matcher(token);
		String metalSearch = "(Silver|Gold|Iron){1}";
		if (queryMatcher.find()) {
			String rhsToken = queryMatcher.group(3);
			double rhs = evaluateExpression(rhsToken);
			if (queryMatcher.group(1) != null) {
				String lshToken = queryMatcher.group(1).trim();
				
				Pattern metalPattern = Pattern.compile(metalSearch, Pattern.CASE_INSENSITIVE);
				Matcher metalMatcher = metalPattern.matcher(lshToken);
				if (metalMatcher.find()) {
					double lhs = evaluateExpression(queryMatcher.group(1).trim());
					logger.info(Double.toString(1/(lhs/rhs)) + " "+ lshToken  
						+ " is " + queryMatcher.group(3));
				} else {
					logger.info(queryMatcher.group(3) + " is " +  rhs + " credits");
				}
			}		
		}
	}

}
