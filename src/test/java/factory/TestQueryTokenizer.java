package factory;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.tw.iconverter.factory.QueryTokenizer;
import com.tw.iconverter.model.GalacticalToken;
import com.tw.iconverter.model.Tokens;

public class TestQueryTokenizer {
	
	@Test 
	public void test_method1() {
		Map <String, String> dummyMap = GalacticalToken.getInstance().getTokenValueMap();
		dummyMap.put("glob", "I");
		dummyMap.put("prok", "V");
		dummyMap.put("pish", "X");
		dummyMap.put("tegj", "L");
		dummyMap.put("iron", "195.5");
		String line2 = "how many Credits is glob prok Iron ?";
		QueryTokenizer query = new QueryTokenizer();
		Tokens tokens =  query.parseLine(line2);
		assertEquals("glob prok Iron  is 782.0 Credits", tokens.getKey() + " is " + tokens.getValue()) ;
		
	}

}
