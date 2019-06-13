package model;

import java.util.Map;
import java.util.TreeMap;

public class GalacticalToken {

	private Map<String, String> tokenValueMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
;
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
