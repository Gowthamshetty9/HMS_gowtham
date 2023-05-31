package com.HMS.testyantra.genricutility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listnerimpclass implements ITestListener {

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {
	
	}

	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		System.out.println("----i am listning----");
		
		TakesScreenshot takesscreanshot=(TakesScreenshot) Baseclass.driver;
		File src = takesscreanshot.getScreenshotAs(OutputType.FILE);
		String datetime = LocalDateTime.now().toString().replace(" ", "-").replace(":", "-");
		File dest = new File("screanshots/"+" "+testname+" "+datetime+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void onTestSkipped(ITestResult result) {
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
	
	}

}
