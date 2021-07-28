package com.diko_studio.numbers.utils;

import java.util.Random;

public class Utils {

	private static Random random = new Random();
	
	public static int returnRandom(int min, int max) {		
		return random.nextInt((max - min) + 1) + min;
	} 
}
