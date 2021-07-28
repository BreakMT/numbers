package com.diko_studio.numbers.number;

public class OkpoIP extends Number {

	public static final String title = "ОКПО ИП";
	public static final int NUMBER_LENGTH = 10;
	public static final int CONTROL_NUMBER_LENGTH = 1;	
	
	public OkpoIP() {
		generateNumber(NUMBER_LENGTH - CONTROL_NUMBER_LENGTH);
		number += generateOKPOControlNumber();		
	}
	
}
