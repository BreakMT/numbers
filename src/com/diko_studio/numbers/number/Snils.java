package com.diko_studio.numbers.number;

import com.diko_studio.numbers.utils.Utils;

public class Snils extends Number {

	public static final String title = "СНИЛС";
	public static final int NUMBER_LENGTH = 11;
	public static final int CONTROL_NUMBER_LENGTH = 2;
	
	public Snils() {
		generateNumber(NUMBER_LENGTH - CONTROL_NUMBER_LENGTH);
		long nineDigits = Long.parseLong(number);
		if (nineDigits <= 1001998) {
			number += Integer.toString(Utils.returnRandom(0, 9)) + Integer.toString(Utils.returnRandom(0, 9));
		} else {
			number += generateControlNumber();			
		}
	}
	
	private String generateControlNumber() {
		int sum = 0;
		for (int i = 0; i < number.length(); i++) {
			sum += Character.getNumericValue(number.charAt(i)) * (number.length() - i);
		}
		while (sum > 101) {
			sum = sum % 101;
		}
		if (sum < 100) {
			return addZeroAtStart(sum);
		}
		if (sum == 100 || sum == 101) {
			return "00";
		}
		return "ER";
	}

}
