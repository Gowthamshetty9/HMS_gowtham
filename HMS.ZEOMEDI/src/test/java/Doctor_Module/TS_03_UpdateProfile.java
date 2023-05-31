package Doctor_Module;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test; 
import com.HMS.testyantra.POM_repository.DoctorDashboardpage;
import com.HMS.testyantra.POM_repository.Loginpage;
import com.HMS.testyantra.genricutility.Baseclass;

public class TS_03_UpdateProfile extends Baseclass{
	@Test
public void updateprofile() throws Throwable {
	//Loginpage loginpage=new Loginpage(driver);
	DoctorDashboardpage doctordashpage=new DoctorDashboardpage(driver);
	/*loginpage.doctorslogin().click();
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
		doctordashpage.updateprofile().click();
		String fees = excelutils.Readdatafromexcelfile("Sheet1", 8, 1);
		String Specification = excelutils.Readdatafromexcelfile("Sheet1", 5, 1);
		String Name = excelutils.Readdatafromexcelfile("Sheet1", 6, 1);
		String Clinicaddress = excelutils.Readdatafromexcelfile("Sheet1", 7, 1);
		String Number = excelutils.Readdatafromexcelfile("Sheet1", 9, 1);
		String popuptext = excelutils.Readdatafromexcelfile("Sheet1", 11, 1);
		doctordashpage.specialization().sendKeys(Specification);
		//Specificationtextbox.sendKeys(Specification);
	    doctordashpage.name().sendKeys(Name);
	    //nametextbox.sendKeys(Name);
	    doctordashpage.clinicaddress().sendKeys(Clinicaddress);
	    //clinicaddresstextbox.sendKeys(Clinicaddress);
	    doctordashpage.doctorfees().sendKeys(fees);
	   // feestextbox.sendKeys(fees);
	    doctordashpage.doctorcontact().sendKeys(Number);
	    //contactnumtextbox.sendKeys(Number);
	    doctordashpage.updatebutton().click();
	    webdriverutils.switchtoalertpopup(driver, popuptext);
        String Editdoctorpgtitle = driver.getTitle();
        if (Editdoctorpgtitle.contains("Edit Doctor")) {
			System.out.println("Edit doctor's page is displayed");
		}else {
			System.out.println("Edit doctor's page is not displayed");
		} 
	}

}
