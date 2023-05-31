package com.HMS.testyantra.POM_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePassword {
public ChangePassword(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(name = "cpass") WebElement currentpassword;
public WebElement currentpassword() {
	return currentpassword;
}
@FindBy(name = "npass") WebElement newpassword;
public WebElement newpassword() {
	return newpassword;
}
}
