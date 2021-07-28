package com.diko_studio.numbers;

import com.diko_studio.numbers.number.InnFL;
import com.diko_studio.numbers.number.InnUL;
import com.diko_studio.numbers.number.Kpp;
import com.diko_studio.numbers.number.OgrnIP;
import com.diko_studio.numbers.number.OgrnUL;
import com.diko_studio.numbers.number.OkpoIP;
import com.diko_studio.numbers.number.OkpoUL;
import com.diko_studio.numbers.number.Snils;

public class Numbers {
	
	InnUL innUL;	
	InnFL innFL;
	Kpp kpp;
	OgrnUL ogrnUL;
	OgrnIP ogrnIP;
	OkpoUL okpoUL;
	OkpoIP okpoIP;
	Snils snils;
	
	public Numbers() {
		regenerateAll();
	}

	public void regenerateAll() {
		innUL = new InnUL();
		innFL = new InnFL();
		kpp = new Kpp();
		ogrnUL = new OgrnUL();
		ogrnIP = new OgrnIP();
		okpoUL = new OkpoUL();
		okpoIP = new OkpoIP();
		snils = new Snils();				
	}
	
}
