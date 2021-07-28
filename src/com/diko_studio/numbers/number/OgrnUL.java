package com.diko_studio.numbers.number;

public class OgrnUL extends Number {

	public static final String title = "ОГРН";
	private static final int NUMBER_LENGTH = 13;
	private static final int CONTROL_NUMBER_LENGTH = 1;	
	private static final int MIN_FIRST_NUMBER = 0;
	private static final int MAX_FIRST_NUMBER = 3;	
	private static final int MOD_NUMBER = 11;
	
	public OgrnUL() {
		generateNumber(NUMBER_LENGTH - CONTROL_NUMBER_LENGTH, MIN_FIRST_NUMBER, MAX_FIRST_NUMBER);
		number += generateControlNumber(MOD_NUMBER);
	}	
	
	protected String generateControlNumber(int modNumber) {
		long intNumber = Long.parseLong(number);
		long coef = intNumber % modNumber;
		if (coef > 9) {
			String stringCoef = Long.toString(coef);
			coef = Character.getNumericValue(stringCoef.charAt(stringCoef.length() - 1));
		}
		return Long.toString(coef);
	}	

}
