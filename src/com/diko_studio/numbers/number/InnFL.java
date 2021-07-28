package com.diko_studio.numbers.number;

public class InnFL extends Number {
	
	public static final String title = "ИНН ФЛ";
	private static final int NUMBER_LENGTH = 12;
	private static final int CONTROL_NUMBER_LENGTH = 2;
	
	public InnFL() {
		generateNumber(NUMBER_LENGTH - CONTROL_NUMBER_LENGTH);
		number += generateFirstControlNumber();
		number += generateSecondControlNumber();
	}	
	
	private String generateFirstControlNumber() {
		final int[] factor = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
		int coef = 0;
		
		for (int i = 0; i < NUMBER_LENGTH - CONTROL_NUMBER_LENGTH; i++) {			
			coef += Character.getNumericValue(number.charAt(i)) * factor[i]; 
		}
		
		coef = coef % 11;
		
		if (coef >= 10) {
			coef = 0;
		}
		
		return Integer.toString(coef);
	}
		
	private String generateSecondControlNumber() {
		final int[] factor = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
		int coef = 0;
		
		for (int i = 0; i < NUMBER_LENGTH - CONTROL_NUMBER_LENGTH + 1; i++) {			
			coef += Character.getNumericValue(number.charAt(i)) * factor[i]; 
		}
		
		coef = coef % 11;
		
		if (coef >= 10) {
			coef = 0;
		}
		
		return Integer.toString(coef);
	}	

}
