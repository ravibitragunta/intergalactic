package com.tw.iconverter.lexer;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tw.iconverter.compute.ExpressionEvaluator;
import com.tw.iconverter.compute.ICompute;
import com.tw.iconverter.factory.BaseTokenizer;
import com.tw.iconverter.factory.TokenTypes;
import com.tw.iconverter.factory.TokenizerFactory;
import com.tw.iconverter.model.GalacticalToken;
import com.tw.iconverter.model.Tokens;

public class CustomEvaluator {

	private static Logger logger = LoggerFactory.getLogger(CustomEvaluator.class);
	protected static Map<String, String> galaticalValuesMap = GalacticalToken.getInstance().getTokenValueMap();

	public void processInput(String line) {

		BaseTokenizer tokenizer = TokenizerFactory.getTokenizer(line);
		Tokens tokens = null;
		if (tokenizer != null) {
			tokens = tokenizer.parseLine(line);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("tokenizer is of type -->" + logger.getName());
		}

		if (tokenizer != null) {
			if (tokens.getTokenType().equals(TokenTypes.ASSERT) || 
					tokens.getTokenType().equals(TokenTypes.METAL)) {
				galaticalValuesMap.put(tokens.getKey(), tokens.getValue());
			} else {
				String expression = tokens.getValue();
				ICompute evaluator = ExpressionEvaluator.getEvaluator(expression);
				evaluator.compute(tokens.getValue());
			}
		}

	}

}
