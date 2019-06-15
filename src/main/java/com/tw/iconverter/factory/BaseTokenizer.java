package com.tw.iconverter.factory;

import java.util.Collections;
import java.util.Map;

import com.tw.iconverter.model.GalacticalToken;
import com.tw.iconverter.model.Tokens;

public interface BaseTokenizer {
	
	static Map<String, String> galaticalValuesMap =
			Collections.unmodifiableMap(GalacticalToken.getInstance().getTokenValueMap());
	
	Tokens parseLine(String line);
	
}
