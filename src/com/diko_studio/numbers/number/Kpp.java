package com.diko_studio.numbers.number;

public class Kpp extends Number{
	
	public static final String title = "КПП";
	public static final int NUMBER_LENGTH = 9;	

	public Kpp() {
		do {
			generateNumber(NUMBER_LENGTH);
		} while (number.charAt(4) == '0' && number.charAt(5) == '0');
	}

}
