package Doctor_Module;

import org.testng.annotations.Test;

import com.HMS.testyantra.POM_repository.DoctorDashboardpage;
import com.HMS.testyantra.POM_repository.Loginpage;
import com.HMS.testyantra.genricutility.Baseclass;

public class TS_05_ManagePatient extends Baseclass {
	@Test
public void managepatient() throws Throwable {
		//Loginpage loginpage=new Loginpage(driver);
		DoctorDashboardpage doctordashpage=new DoctorDashboardpage(driver);
		/*
		String USERNAME =fileutils.Readdatafromfile("username");
		String PASSWORD =fileutils.Readdatafromfile("password");

		loginpage.doctorslogin().click();
 
		loginpage.usernametextfield().sendKeys(USERNAME);
		loginpage.passwordtextfield().sendKeys(PASSWORD);
		loginpage.submitbutton().click();
	    String DashboardpgTitle = driver.getTitle();
	    if (DashboardpgTitle.contains("Dashboard")) {
	    	System.out.println("Login sucessfully Doctor's dashboard page is displayed");
		}else {
			System.out.println("Login sucessfully Doctor's dashboard page is not displayed");
		}*/
	    doctordashpage.patientsmenu().click();
	    doctordashpage.managepatient().click();
	    String managepatientpage = driver.getTitle();
	    if (managepatientpage.equals("Doctor | Manage Patients")) {
			System.out.println("Manage patient page is displayed");
		}else {
			System.out.println("Manage patient page is not displayed");
		}
	    doctordashpage.viewpatient().click();
	    doctordashpage.addmedicalhistory().click();
	    String bp = excelutils.Readdatafromexcelfile("Sheet1", 14, 1);
	    String bs = excelutils.Readdatafromexcelfile("Sheet1", 15, 1);
	    String waight = excelutils.Readdatafromexcelfile("Sheet1", 16, 1);
	    String temp = excelutils.Readdatafromexcelfile("Sheet1", 17, 1);
	    String pres = excelutils.Readdatafromexcelfile("Sheet1", 18, 1);
	    String popupmsg = excelutils.Readdatafromexcelfile("Sheet1", 19, 1);
	    doctordashpage.bp().sendKeys(bp);
	    doctordashpage.bs().sendKeys(bs);
	    doctordashpage.weight().sendKeys(waight);
	    doctordashpage.temp().sendKeys(temp);
	    doctordashpage.prescription().sendKeys(pres);
	    doctordashpage.submitmedicalhistory().click();
	   webdriverutils.switchtoalertpopup(driver,popupmsg);
	    if (driver.getTitle().equals("Doctor | Manage Patients")) {
			System.out.println("Medical history is sucessfully created");
		}else {
			System.out.println("Medical history is not created");
		}    
}
}
