 package com.HMS.testyantra.genricutility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class javascriptutility {
JavascriptExecutor js;
public javascriptutility()
{
	
}
public javascriptutility(WebDriver driver) {
	js=(JavascriptExecutor) driver;
}
public void scrollup() {
	js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
}
public void sendkeys(WebElement element,String data) {
	js.executeScript("arguments[0].value=arguments[1]",element);
}
public void click(WebElement element) {
	js.executeScript("argument[0].click()", element);
}
public void clickelementbyid(String elementid) {
	js.executeScript("document.getElementById('elementId').click()");
}
public String getTheText(WebElement element) {
	String textfieldvalue = (String) js.executeScript("return arguments[0].value;", element);
	return textfieldvalue;
}
public String getCurrenturl() {
	String url=(String) js.executeScript("return window.location.title");
	return url;
}
public String getTitle() {
	String title=(String) js.executeScript("return document.title");
	return title;
}
public void Scrolltillelement(WebElement element) {
	js.executeScript("argument[0].scrollintoview()",element);
}
public void scrolldown() {
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
}
public void lunchApplication(String url) {
	js.executeScript("window.location=arguments[0]",url);
}
}
