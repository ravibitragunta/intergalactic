package com.tw.iconverter.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public enum Metals {
	SILVER ("Silver"),
	IRON ("Iron"),
	GOLD ("Gold");
	private static Logger logger = LoggerFactory.getLogger(Metals.class);
	
	private String value;
	
	Metals (String value) {
		this.setValue(value);
	}
	
	public static boolean compareValue (String inputValue) {
		if (logger.isDebugEnabled()) {
			logger.debug("inputValue->" + inputValue);
		}
		boolean matched = false;
		for (Metals metal: Metals.values()) {
			if (logger.isDebugEnabled()) {
				logger.debug("metal->" + metal.toString());
			}
			if (metal.toString().equalsIgnoreCase(inputValue.trim())) {
				matched = true;
			}
				
		}
		return matched;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

}
