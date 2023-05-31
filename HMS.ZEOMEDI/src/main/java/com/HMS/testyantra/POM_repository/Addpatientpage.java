package com.HMS.testyantra.POM_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Addpatientpage {
public Addpatientpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(name = "patname") WebElement patientname;
public WebElement patientname() {
	return patientname;
}
@FindBy(name = "patcontact") WebElement patientcontact;
public WebElement patientcontact() {
	return patientcontact;
}
@FindBy(name = "patemail") WebElement patientemail;
public WebElement patientemail() {
	return patientemail;
}
@FindBy(name = "pataddress") WebElement patientaddress;
public WebElement patientaddress() {
	return patientaddress;
}
@FindBy(xpath = "//label[@for='rg-male']") WebElement maleradiobutton;
public WebElement maleradiobutton() {
	return maleradiobutton;
}
@FindBy(name = "patage") WebElement patientage;
public WebElement patientage() {
	return patientage;
}
@FindBy(name = "medhis") WebElement patientmedicalhistory;
public WebElement patientmedicalhistory() {
	return patientmedicalhistory;
}
@FindBy(name = "submit") WebElement addpatientbutton;
public WebElement addpatientbutton() {
	return addpatientbutton;
}

}
