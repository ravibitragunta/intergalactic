package factory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.tw.iconverter.factory.AssertionTokenizer;
import com.tw.iconverter.model.Tokens;

public class TestAssertionTokenizer {
	
	@Test 
	public void testtokenise_WhenLineIsBasic() {
		String line = "glob is X";
		Tokens token = new AssertionTokenizer().parseLine(line);
		assertEquals("X", token.getValue()) ;
	}

}
