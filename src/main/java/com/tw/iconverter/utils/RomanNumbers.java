package com.tw.iconverter.utils;

import java.util.Arrays;
import static java.util.Comparator.comparing;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNumbers {

	I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);

	private Integer value;

	RomanNumbers(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static List<RomanNumbers> getSortedValues() {

		return Arrays.stream(values()).sorted(comparing((RomanNumbers e) -> e.value).reversed())
				.collect(Collectors.toList());

	}

}
