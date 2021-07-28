package com.diko_studio.numbers.number;

import com.diko_studio.numbers.utils.Utils;

abstract public class Number {

	protected String number;
	
	protected void generateNumber(int numberLength) {
		number = "";
		for (int i = 0; i < numberLength; i++) {
			number += Integer.toString(Utils.returnRandom(0, 9));
		}
	}
	
	protected void generateNumber(int numberLength, int firstNumberMin, int firstNumberMax) {
		generateNumber(numberLength);
		String newNumber = new String(number.substring(1));
		number = new String(Utils.returnRandom(firstNumberMin, firstNumberMax) + newNumber);
	}
	
	public String getNumber() {
		if (number != null) {
			return number;
		}
		
		return "0";
	}
	
	protected String addZeroAtStart(int n) {
		String numberWithZero = Integer.toString(n);
		if (n < 10) {
			numberWithZero = "0" + numberWithZero;
		}
		return numberWithZero;
	}
	
	protected String generateOKPOControlNumber() {
		int sum = 0;
		for (int i = 0; i < number.length(); i++) {
			sum += Character.getNumericValue(number.charAt(i)) * (i + 1);
		}
		int coef = sum % 11;
		if (coef > 9) {
			sum = 0;
			for (int i = 0; i < number.length(); i++) {
				sum += Character.getNumericValue(number.charAt(i)) * (i + 3);
			}
			coef = sum % 11;
			if (coef > 9) {
				coef = 0;
			}
		}
		return Integer.toString(coef);		
	}	
	
}
