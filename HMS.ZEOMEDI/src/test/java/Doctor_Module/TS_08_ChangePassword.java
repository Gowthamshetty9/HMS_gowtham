package Doctor_Module;

import org.testng.annotations.Test;

import com.HMS.testyantra.POM_repository.DoctorDashboardpage;
import com.HMS.testyantra.POM_repository.Loginpage;
import com.HMS.testyantra.genricutility.Baseclass;

public class TS_08_ChangePassword extends Baseclass {
	@Test
public void changepassword() throws Throwable {
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
	    doctordashpage.profileIcon().click();
	    doctordashpage.changepassword().click();
	    
}
}
