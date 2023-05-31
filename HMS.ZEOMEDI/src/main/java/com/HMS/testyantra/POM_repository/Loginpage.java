package com.HMS.testyantra.POM_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
public Loginpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//a[@href='hms/doctor/']") WebElement doctorslogin;
public WebElement doctorslogin() {
	return doctorslogin;
}
@FindBy(xpath = "//input[@name='username']") WebElement usernametextfield;
public WebElement usernametextfield() {
	return usernametextfield;
}
@FindBy(xpath = "//input[@name='password']") WebElement passwordtextfield;
public WebElement passwordtextfield() {
	return passwordtextfield;
}
@FindBy(name = "submit") WebElement submitbutton;
public WebElement submitbutton() {
	return submitbutton;
}
@FindBy(xpath = "//a[@href='forgot-password.php']") WebElement forgetpassword;
public WebElement forgetpassword() {
	return forgetpassword;
}
@FindBy(name = "contactno") WebElement contactnum;
public WebElement contactnum() {
	return contactnum;
}
@FindBy(name = "email") WebElement email;
public WebElement email() {
	return email;
}
@FindBy(name = "submit") WebElement forgetsubmit;
public WebElement forgetsubmit() {
	return forgetsubmit;
}
}
