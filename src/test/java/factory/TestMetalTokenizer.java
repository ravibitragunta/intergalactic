package factory;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.tw.iconverter.factory.MetalTokenizer;

import model.GalacticalToken;

public class TestMetalTokenizer {
	@Test 
	public void testtokenise_WhenLineIsBasic() {
		Map <String, String> dummyMap = GalacticalToken.getInstance().getTokenValueMap();
		dummyMap.put("glob", "I");
		dummyMap.put("prok", "V");
		String line = "glob prok Gold is 57800 Credits";
		new MetalTokenizer().parseLine(line);
		assertEquals("14450.0", dummyMap.get("Gold")) ;
		
	}
	
	@Test 
	public void test_method1() {
		Map <String, String> dummyMap = GalacticalToken.getInstance().getTokenValueMap();
		dummyMap.put("glob", "I");
		dummyMap.put("prok", "V");
		dummyMap.put("pish", "X");
		dummyMap.put("tegz", "L");
		String line = "pish pish Iron is 3910 Credits";
		new MetalTokenizer().parseLine(line);
		assertEquals("195.5", dummyMap.get("Iron")) ;
	}

}
