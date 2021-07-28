package com.diko_studio.numbers.number;

public class OkpoUL extends Number {
	
	public static final String title = "ОКПО ЮЛ";	
	public static final int NUMBER_LENGTH = 8;
	public static final int CONTROL_NUMBER_LENGTH = 1;	

	public OkpoUL() {
		generateNumber(NUMBER_LENGTH - CONTROL_NUMBER_LENGTH);
		number += generateOKPOControlNumber();
	}	

}
