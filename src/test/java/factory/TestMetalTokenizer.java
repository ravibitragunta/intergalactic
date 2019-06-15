package factory;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import org.junit.Test;
import com.tw.iconverter.factory.MetalTokenizer;
import com.tw.iconverter.model.GalacticalToken;
import com.tw.iconverter.model.Tokens;

public class TestMetalTokenizer {
	@Test 
	public void testtokenise_WhenLineIsBasic() {
		Map <String, String> dummyMap = GalacticalToken.getInstance().getTokenValueMap();
		dummyMap.put("glob", "I");
		dummyMap.put("prok", "V");
		String line = "glob prok Gold is 57800 Credits";
		Tokens token = new MetalTokenizer().parseLine(line);
		assertEquals("14450.0", token.getValue()) ;
		
	}
	
	@Test 
	public void test_method1() {
		Map <String, String> dummyMap = GalacticalToken.getInstance().getTokenValueMap();
		dummyMap.put("glob", "I");
		dummyMap.put("prok", "V");
		dummyMap.put("pish", "X");
		dummyMap.put("tegz", "L");
		String line = "pish pish Iron is 3910 Credits";
		Tokens token = new MetalTokenizer().parseLine(line);
		assertEquals("195.5", token.getValue()) ;
	}

}
