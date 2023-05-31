package com.HMS.testyantra.genricutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryanalyserclass implements IRetryAnalyzer{
	int count=0;
	int retry=2;
	public boolean retry(ITestResult result) {
		if (count<retry) {
			count++;
			return true;
		}
	
		return false;
	}

}
