package com.diko_studio.numbers.number;

public class InnUL extends Number {

	public static final String title = "ИНН ЮЛ";
	public static final int NUMBER_LENGTH = 10;
	public static final int CONTROL_NUMBER_LENGTH = 1;
	
	public InnUL() {
		generateNumber(NUMBER_LENGTH - CONTROL_NUMBER_LENGTH);
		number += generateControlNumber();		
	}
	
	private String generateControlNumber() {
		final int[] factor = {2, 4, 10, 3, 5, 9, 4, 6, 8};
		int coef = 0;
		
		for (int i = 0; i < NUMBER_LENGTH - CONTROL_NUMBER_LENGTH; i++) {			
			coef += Character.getNumericValue(getNumber().charAt(i)) * factor[i]; 
		}
		
		coef = coef % 11;
		
		if (coef >= 10) {
			coef = 0;
		}
		
		return Integer.toString(coef);
	}
	
}
