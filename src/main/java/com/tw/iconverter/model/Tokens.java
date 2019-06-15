package com.tw.iconverter.model;

import com.tw.iconverter.factory.TokenTypes;

public class Tokens {
	
	private String key;
	private String value;
	private TokenTypes tokenType;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public TokenTypes getTokenType() {
		return tokenType;
	}
	public void setTokenType(TokenTypes tokenType) {
		this.tokenType = tokenType;
	}
	
	
	

}
