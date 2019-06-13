package com.tw.iconverter.lexer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tw.iconverter.factory.BaseTokenizer;
import com.tw.iconverter.factory.TokenizerFactory;


public class CustomEvaluator {
	
	private static Logger logger = LoggerFactory.getLogger(CustomEvaluator.class);

	public void processInput (String line) {
		
		TokenizerFactory factory = new TokenizerFactory();
		BaseTokenizer tokenizer = factory.getTokenizer(line);
		if (tokenizer != null) {
			tokenizer.parseLine(line);
		}
		
		
	}
	
}
