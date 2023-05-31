package Doctor_Module;

import org.testng.annotations.Test;

import com.HMS.testyantra.POM_repository.Addpatientpage;
import com.HMS.testyantra.POM_repository.DoctorDashboardpage;
import com.HMS.testyantra.POM_repository.Loginpage;
import com.HMS.testyantra.genricutility.Baseclass;

public class TS_07_SearchPatient extends Baseclass {
	@Test
public void searchpatient() throws Throwable {
		//Loginpage loginpage=new Loginpage(driver);
		DoctorDashboardpage doctordashpage=new DoctorDashboardpage(driver);
		Addpatientpage addpatient=new Addpatientpage(driver);
		/*String USERNAME =fileutils.Readdatafromfile("username");
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
	    String patientname = excelutils.Readdatafromexcelfile("Sheet1", 35, 1);
	    String patientage = excelutils.Readdatafromexcelfile("Sheet1", 36, 1);
	    doctordashpage.searchmenu().click();
	    doctordashpage.patientsearch().sendKeys(patientname);
	    doctordashpage.searchpatientbutton().click();
	    doctordashpage.editpatient().click();
	    addpatient.patientage().clear();
	    addpatient.patientage().sendKeys(patientage);
	    addpatient.addpatientbutton().click();
	    Thread.sleep(3000);
	   String title = driver.getTitle();
	   String text = excelutils.Readdatafromexcelfile("Sheet1", 37, 1);
	    if (title.equals(text)) {
			System.out.println("Manage patient page will displayed");
		}else {
			System.out.println("Manage patient page is not displayed");
		}
}
}
