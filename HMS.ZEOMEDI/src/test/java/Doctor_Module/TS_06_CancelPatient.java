package Doctor_Module;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.HMS.testyantra.POM_repository.DoctorDashboardpage;
import com.HMS.testyantra.POM_repository.Loginpage;
import com.HMS.testyantra.genricutility.Baseclass;

public class TS_06_CancelPatient extends Baseclass{
	@Test
public void cancelpatient() throws Throwable {
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
	    doctordashpage.appointmenthistory().click();
	    doctordashpage.cancelappointment().click();
	    String popupmsg = excelutils.Readdatafromexcelfile("Sheet1", 22, 1);
	    String conforncancel = excelutils.Readdatafromexcelfile("Sheet1", 23, 1);
	    webdriverutils.switchtoalertpopup(driver,popupmsg);
	   String text = driver.findElement(By.xpath("//tbody/tr[2]/td[7]")).getText();
	   if (text.contains(conforncancel)) {
		System.out.println("Patient cancelled sucessfully");
	   }else {
		System.out.println("Patient not cancelled");
	   }
}
}
