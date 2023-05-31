package Doctor_Module;

import org.testng.annotations.Test;

import com.HMS.testyantra.POM_repository.Addpatientpage;
import com.HMS.testyantra.POM_repository.DoctorDashboardpage;
import com.HMS.testyantra.POM_repository.Loginpage;
import com.HMS.testyantra.genricutility.Baseclass;

class TS_04_Addpatient extends Baseclass {
	@Test
  public void addpatient() throws Throwable {
	 // Loginpage loginpage=new Loginpage(driver);	
	  DoctorDashboardpage doctordashboardpage=new DoctorDashboardpage(driver);
	  Addpatientpage addpatientpage=new Addpatientpage(driver);
	 /* loginpage.doctorslogin().click();  
	String USERNAME =fileutils.Readdatafromfile("username");
	loginpage.usernametextfield().sendKeys(USERNAME);
	String PASSWORD =fileutils.Readdatafromfile("password");
	loginpage.passwordtextfield().sendKeys(PASSWORD);
	loginpage.submitbutton().click();
    String DashboardpgTitle = driver.getTitle();
	  if (DashboardpgTitle.contains("Dashboard")) {
		 	System.out.println("Login sucessfully Doctor's dashboard page is displayed");
	  }else {
	    	System.out.println("Login sucessfully Doctor's dashboard page is not displayed");
			}*/
	  doctordashboardpage.patientsmenu().click();
	  doctordashboardpage.addpatient().click();
	  String addpatientpgtitle = driver.getTitle();
	  String text = excelutils.Readdatafromexcelfile("Sheet1", 32, 1);
	  if (addpatientpgtitle.equals(text)) {
		  System.out.println("Addpatient page is sucessfully displayed");
	  }else {
		System.out.println("Addpatient page is not displayed");
	  }
	  //Read patient details
	  String patientname = excelutils.Readdatafromexcelfile("Sheet1", 26, 1);
	  String patientno = excelutils.Readdatafromexcelfile("Sheet1", 27, 1);
	  String patientemail = excelutils.Readdatafromexcelfile("Sheet1", 28, 1);
	  String patientaddress = excelutils.Readdatafromexcelfile("Sheet1", 29, 1);
	  String patientage = excelutils.Readdatafromexcelfile("Sheet1", 30, 1);
	  String patientmedicalhistory = excelutils.Readdatafromexcelfile("Sheet1", 31, 1);
	  //Enter patient details
	 int num = javautils.getrandomnum();
	  addpatientpage.patientname().sendKeys(patientname);
	  addpatientpage.patientcontact().sendKeys(patientno);
	  addpatientpage.patientemail().sendKeys(num+patientemail);
	  addpatientpage.patientaddress().sendKeys(patientaddress);
	  addpatientpage.patientage().sendKeys(patientage);
	  addpatientpage.patientmedicalhistory().sendKeys(patientmedicalhistory);
	  addpatientpage.addpatientbutton().click();
	  if (addpatientpgtitle.equals(text)) {
		  System.out.println("Patient is sucessfully added");
	  }else {
		System.out.println("Patient is not added");
	  }
  }
}



