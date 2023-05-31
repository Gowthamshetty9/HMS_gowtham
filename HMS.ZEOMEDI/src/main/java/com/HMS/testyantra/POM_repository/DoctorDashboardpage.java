package com.HMS.testyantra.POM_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorDashboardpage {

	public DoctorDashboardpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath = "//span[@class='username']") WebElement profileIcon;
	public WebElement profileIcon() {
		return profileIcon;
}
	@FindBy(xpath = "//a[@href='logout.php']") WebElement logoutbutton;
	public WebElement logoutbutton() {
		return logoutbutton;
	}
	@FindBy(xpath = "//p/a[@href='edit-profile.php']") WebElement updateprofile;
	public WebElement updateprofile() {
		return updateprofile;
	}
	@FindBy(xpath = "//select[@name='Doctorspecialization']") WebElement specialization;
	public WebElement specialization() {
		return specialization;
	}
	@FindBy(name = "docname") WebElement name;
	public WebElement name() {
		return name;
	}
	@FindBy(name = "clinicaddress") WebElement clinicaddress;
	public WebElement clinicaddress() {
		return clinicaddress;
	}
	@FindBy(name = "docfees") WebElement doctorfees;
	public WebElement doctorfees() {
		return doctorfees;
	}
	@FindBy(name = "doccontact") WebElement doctorcontact;
	public WebElement doctorcontact() {
		return doctorcontact;
	}
	@FindBy(xpath = "//button[@type='submit']") WebElement updatebutton;
	public WebElement updatebutton() {
		return updatebutton;
	}
	@FindBy(xpath = "//span[.=' Patients ']") WebElement patientsmenu;
	public WebElement patientsmenu() {
		return patientsmenu;
	}
	@FindBy(xpath = "//span[.=' Manage Patient ']") WebElement managepatient;
	public WebElement managepatient() {
		return managepatient;
	}
	@FindBy(xpath = "//td[.='PatNew678']/..//a[2]") WebElement viewpatient;
	public WebElement viewpatient() {
		return viewpatient;
	}
	@FindBy(xpath = "//button[text()='Add Medical History']") WebElement addmedicalhistory;
	public WebElement addmedicalhistory() {
		return addmedicalhistory;
	}
	@FindBy(name = "bp") WebElement bp;
	public WebElement bp() {
		return bp;
	}
	@FindBy(name = "bs") WebElement bs;
	public WebElement bs() {
		return bs;
	}
	@FindBy(name = "weight") WebElement weight;
	public WebElement weight() {
		return weight;
	}
	@FindBy(name = "temp") WebElement temp;
	public WebElement temp() {
		return temp;
	}
	@FindBy(name = "pres") WebElement prescription;
	public WebElement prescription() {
		return prescription;
	}
	@FindBy(xpath = "//button[@name='submit']") WebElement submitmedicalhistory;
	public WebElement submitmedicalhistory() {
		return submitmedicalhistory;
	}
	@FindBy(xpath = "//span[text()=' Appointment History ']") WebElement appointmenthistory;
	public WebElement appointmenthistory() {
		return appointmenthistory;
	}
	@FindBy(xpath = "//a[@title='Cancel Appointment']") WebElement cancelappointment;
	public WebElement cancelappointment() {
		return cancelappointment;
	}
	@FindBy(xpath = " //span[text()=' Add Patient']") WebElement addpatient;
	public WebElement addpatient() {
		return addpatient;
	}
	@FindBy(xpath = "//span[.=' Search ']") WebElement searchmenu;
	public WebElement searchmenu() {
		return searchmenu;
	}
	@FindBy(name = "searchdata") WebElement patientsearch;
	public WebElement patientsearch() {
		return patientsearch;
	}
	@FindBy(id = "submit") WebElement searchpatientbutton;
	public WebElement searchpatientbutton() {
		return searchpatientbutton;
	}
	@FindBy(xpath = "//td[.='1234554321']/../td[7]//i[@class='fa fa-edit']") WebElement editpatient;
	public WebElement editpatient() {
		return editpatient;
	}
	@FindBy(xpath = "//a[contains(.,'Change')]") WebElement changepassword;
	public WebElement changepassword() {
		return changepassword;
	}
	
}
