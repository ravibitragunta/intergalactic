package com.tw.iconverter.utils;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;


public class TestRomanNumberConverter {
	
	@Test 
	public void givenMMXVIIItoNumber_shouldreturn2018() {
		String romanLiteral = "MMXVIII";
		int result = RomanNumberConverter.romanToNumber(romanLiteral);
		assertThat(result).isEqualTo(2018);
	}
	
	@Test 
	public void givenMCMXLIVtoNumber_shouldReturn1944 () {
		String romanLiteral = "MCMXLIV";
		int result = RomanNumberConverter.romanToNumber(romanLiteral);
		assertThat(result).isEqualTo(1944);
	}
	
	@Test 
	public void givenMMMM_shouldFail() {
		String romanLiteral = "MMMM";
		int result = RomanNumberConverter.romanToNumber(romanLiteral);
		assertThat(result).isEqualTo(-1);
	}
	
	@Test 
	public void givenMMMXC_shouldReturn3090() {
		String romanLiteral = "MMMXC";
		int result = RomanNumberConverter.romanToNumber(romanLiteral);
		assertThat(result).isEqualTo(3090);
	}
	
	@Test 
	public void givenMMMXCM_shouldReturnFail() {
		String romanLiteral = "MMMXCM";
		int result = RomanNumberConverter.romanToNumber(romanLiteral);
		assertThat(result).isEqualTo(-1);
	}

}
