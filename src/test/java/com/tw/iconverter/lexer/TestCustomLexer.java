package com.tw.iconverter.lexer;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class TestCustomLexer {
	
	@Test 
	public void testtokenise_WhenLineIsBasic() {
		String line = "glob is X";
		new CustomLexer().tokenise(line);
	}
	
	@Test 
	public void testtokenise_WhenLineIsAnotherBasic() {
		String line = "prok is C";
		new CustomLexer().tokenise(line);
	}


	@Test 
	public void testtokenise_WhenLineIsMetal() {
		String line = "glob prok Gold is 57800 Credits";
		new CustomLexer().tokenise(line);
	}
	
}
