package com.HMS.testyantra.genricutility;

import java.io.FileInputStream;
import java.util.Properties;

public class fileutility {
public String Readdatafromfile(String key) throws Throwable {
	FileInputStream fis =new FileInputStream("./src/test/resources/HMS.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String value = pobj.getProperty(key);
	return value;
}
}
