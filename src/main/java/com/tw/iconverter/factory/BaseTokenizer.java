package com.tw.iconverter.factory;

public abstract class BaseTokenizer {
	
	private String key;
	private String value;
	private TokenTypes tokenType;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public TokenTypes getTokenType() {
		return tokenType;
	}
	public void setTokenType(TokenTypes tokenType) {
		this.tokenType = tokenType;
	}
	
	public abstract void parseLine(String line);
	
}
