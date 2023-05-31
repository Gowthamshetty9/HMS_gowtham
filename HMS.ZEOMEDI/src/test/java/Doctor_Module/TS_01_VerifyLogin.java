package Doctor_Module;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.HMS.testyantra.POM_repository.DoctorDashboardpage;
import com.HMS.testyantra.POM_repository.Loginpage;
import com.HMS.testyantra.genricutility.Baseclass;
@Listeners(com.HMS.testyantra.genricutility.Listnerimpclass.class)
public class TS_01_VerifyLogin extends Baseclass{
	  @Test(retryAnalyzer=com.HMS.testyantra.genricutility.retryanalyserclass.class)
	  public void verigylogin() throws Throwable {
		//welcome
		Loginpage loginpage=new Loginpage(driver);
		DoctorDashboardpage doctordashpage=new DoctorDashboardpage(driver);
		
		String USERNAME =fileutils.Readdatafromfile("username");
		String PASSWORD =fileutils.Readdatafromfile("password");

		loginpage.doctorslogin().click();
        Assert.fail();
		loginpage.usernametextfield().sendKeys(USERNAME);
		loginpage.passwordtextfield().sendKeys(PASSWORD);
		loginpage.submitbutton().click();
	    String DashboardpgTitle = driver.getTitle();
	    if (DashboardpgTitle.contains("Dashboard")) {
	    	System.out.println("Login sucessfully Doctor's dashboard page is displayed");
		}else {
			System.out.println("Login sucessfully Doctor's dashboard page is not displayed");
		}
	    doctordashpage.profileIcon().click();
	    doctordashpage.logoutbutton().click();
	    String HMShomepgTitle = driver.getTitle();
	    if (HMShomepgTitle.equals("Hospital Management System")) {
	    	System.out.println("Logout sucessfully and HMS homepage is displayed");
		}else {
			System.out.println("Logout not done and HMS homepage is not displayed");
		}
	}

}
