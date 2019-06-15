package com.tw.iconverter.lexer;

import org.junit.Test;

public class TestEvaluator {
	
	@Test
	public void test_case_1() {
		String line = "glob is I";
		new CustomEvaluator().processInput(line);
	}
	
	@Test 
	public void test_case_2() {
		String line = "prok is V";
		new CustomEvaluator().processInput(line);
	}
	
	@Test 
	public void test_case_3() {
		String line = "pish is X";
		new CustomEvaluator().processInput(line);
	}
	
	@Test 
	public void test_case_4() {
		String line = "tegj is L";
		new CustomEvaluator().processInput(line);
	}
	
	@Test 
	public void test_case_5() {
		String line = "glob is I";
		new CustomEvaluator().processInput(line);
		String line2 = "glob glob Silver is 34 Credits";
		new CustomEvaluator().processInput(line2);
	}
	
	@Test 
	public void test_case_6() {
		String line = "prok is V";
		new CustomEvaluator().processInput(line);
		String line2 = "glob prok Gold is 57800 Credits";
		new CustomEvaluator().processInput(line2);
	}
	
	@Test 
	public void test_case_7() {
		String line = "pish is X";
		new CustomEvaluator().processInput(line);
		String line2 = "pish pish Iron is 3910 Credits";
		new CustomEvaluator().processInput(line2);
	}

	@Test 
	public void test_case_8() {
		
		String line1 = "glob is I";
		String line2 = "prok is V";
		String line3 = "pish is X";
		String line4 = "tegj is L";
		String line5 = "glob glob Silver is 34 Credits";
		String line6 = "glob prok Gold is 57800 Credits";
		String line7 = "pish pish Iron is 3910 Credits";
		String line8 = "how much is pish tegj glob glob ?";
		String line9 = "how many Credits is glob prok Silver ?";
		String line10 = "how many Credits is glob prok Gold ?";
		String line11 = "how many Credits is glob prok Iron ?";
		String line12 = "how many silver is glob gold?";
		String line13 = "how many iron is glob gold?";
		String line14 = "how many iron is prok gold?";
		new CustomEvaluator().processInput(line1);
		new CustomEvaluator().processInput(line2);
		new CustomEvaluator().processInput(line3);
		new CustomEvaluator().processInput(line4);
		new CustomEvaluator().processInput(line5);
		new CustomEvaluator().processInput(line6);
		new CustomEvaluator().processInput(line7);
		new CustomEvaluator().processInput(line8);
		new CustomEvaluator().processInput(line9);
		new CustomEvaluator().processInput(line10);
		new CustomEvaluator().processInput(line11);
		new CustomEvaluator().processInput(line12);
		new CustomEvaluator().processInput(line13);
		new CustomEvaluator().processInput(line14);
		
	}
	
	
}
