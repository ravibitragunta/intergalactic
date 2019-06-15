package com.tw.iconverter.compute;

public class ExpressionEvaluator {
	
	public static ICompute getEvaluator(String expression) {
		return new ComapreAndFare();
	}
	

}
