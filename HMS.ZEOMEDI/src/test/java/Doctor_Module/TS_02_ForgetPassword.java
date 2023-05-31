package Doctor_Module;

import org.testng.annotations.Test;

import com.HMS.testyantra.POM_repository.Loginpage;
import com.HMS.testyantra.genricutility.Baseclass;

public class TS_02_ForgetPassword extends Baseclass {
	@Test
    public void forget_password() throws Throwable {
	    Loginpage loginpage=new Loginpage(driver);
	    //loginpage.doctorslogin().click(); 
	    String USERNAME =fileutils.Readdatafromfile("username");
	    loginpage.usernametextfield().sendKeys(USERNAME);
	    loginpage.forgetpassword().click();
	    String CONTACTNO = excelutils.Readdatafromexcelfile("Sheet1", 1, 1);
	    loginpage.contactnum().sendKeys(CONTACTNO);
	    String EMAIL = excelutils.Readdatafromexcelfile("Sheet1", 2, 1);
	    loginpage.email().sendKeys(EMAIL);
	    loginpage.forgetsubmit().click();
	   String pageurl = driver.getCurrentUrl();
	    if (pageurl.contains("reset-password")) {
	    	System.out.println("Reset password page is displayed");
		}else {
			System.out.println("Reset password page is not displayed");
		}
	}
}

