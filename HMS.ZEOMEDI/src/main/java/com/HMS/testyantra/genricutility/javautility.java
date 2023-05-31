package com.HMS.testyantra.genricutility;

import java.util.Date;
import java.util.Random;

public class javautility {
	
public int getrandomnum() {
	Random num=new Random();
	int randomnum = num.nextInt(1000);
	return randomnum;
}
public String currentsystemdate() {
	Date date1=new Date();
	String currentdate = date1.toString();
	String[] splitform = currentdate.split(" ");
	String month = splitform[1];
	String year = splitform[5];
	String date = splitform[2];
	String formet=year+"-"+month+"-"+date;
	return formet;
}
}
