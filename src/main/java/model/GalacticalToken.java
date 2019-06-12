package model;

import java.util.HashMap;
import java.util.Map;

public class GalacticalToken {

	private Map<String, String> tokenValueMap = new HashMap<>();
	private static GalacticalToken instance;

	private GalacticalToken() {
	}
	
	public static synchronized GalacticalToken getInstance() {
		if (instance == null) {
			instance = new GalacticalToken(); 
		}
		return instance;
	}

	public Map<String, String> getTokenValueMap() {
		return tokenValueMap;
	}

}
