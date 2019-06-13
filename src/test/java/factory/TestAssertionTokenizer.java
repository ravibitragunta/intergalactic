package factory;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.tw.iconverter.factory.AssertionTokenizer;

import model.GalacticalToken;

public class TestAssertionTokenizer {
	
	@Test 
	public void testtokenise_WhenLineIsBasic() {
		String line = "glob is X";
		Map<String, String> dummyMap = GalacticalToken.getInstance().getTokenValueMap();
		new AssertionTokenizer().parseLine(line);
		assertEquals("X", dummyMap.get("glob")) ;
	}

}
