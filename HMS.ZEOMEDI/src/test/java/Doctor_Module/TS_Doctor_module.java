package Doctor_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.HMS.testyantra.POM_repository.Addpatientpage;
import com.HMS.testyantra.POM_repository.DoctorDashboardpage;
import com.HMS.testyantra.genricutility.Baseclass;

public class TS_Doctor_module extends Baseclass{
@Test(groups = "endtoend")
	public void Update_Profile() throws Throwable {
		DoctorDashboardpage doctordashpage=new DoctorDashboardpage(driver);
		doctordashpage.updateprofile().click();
		String fees = excelutils.Readdatafromexcelfile("Sheet1", 8, 1);
		String Specification = excelutils.Readdatafromexcelfile("Sheet1", 5, 1);
		String Name = excelutils.Readdatafromexcelfile("Sheet1", 6, 1);
		String Clinicaddress = excelutils.Readdatafromexcelfile("Sheet1", 7, 1);
		String Number = excelutils.Readdatafromexcelfile("Sheet1", 9, 1);
		String popuptext = excelutils.Readdatafromexcelfile("Sheet1", 11, 1);
		WebElement Specificationtextbox = doctordashpage.specialization();
		webdriverutils.selectdropdownelement(driver, Specificationtextbox,Specification);
		WebElement nametextbox = doctordashpage.name();
		nametextbox.clear();
	    nametextbox.sendKeys(Name);
	    WebElement clinicaddresstextbox = doctordashpage.clinicaddress();
	    clinicaddresstextbox.clear();
	    clinicaddresstextbox.sendKeys(Clinicaddress);
	    WebElement feestextbox = doctordashpage.doctorfees();
	    feestextbox.clear();
	     feestextbox.sendKeys(fees);
	     WebElement contactnumtextbox = doctordashpage.doctorcontact();
	     contactnumtextbox.clear();;
	     contactnumtextbox.sendKeys(Number);
	    doctordashpage.updatebutton().click();
	    webdriverutils.switchtoalertpopup(driver, popuptext);
        String Editdoctorpgtitle = driver.getTitle();
        Assert.assertTrue(Editdoctorpgtitle.contains("Edit Doctor"), "Edit doctor's page is not displayed");
   
        Reporter.log("Edit doctor's page is displayed",true);
	}
@Test(groups = "endtoend")
	public void AddPatient() throws Throwable {
		DoctorDashboardpage doctordashboardpage=new DoctorDashboardpage(driver);
		  Addpatientpage addpatientpage=new Addpatientpage(driver);
		 doctordashboardpage.patientsmenu().click();
		  doctordashboardpage.addpatient().click();
		  String addpatientpgtitle = driver.getTitle();
		  String text = excelutils.Readdatafromexcelfile("Sheet1", 32, 1);
		  Assert.assertTrue(addpatientpgtitle.equals(text),"Addpatient page is not displayed");
		
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
		  Assert.assertTrue(addpatientpgtitle.equals(text), "Patient is sucessfully added");
		  
		  Reporter.log("Addpatient is pass",true);
	}
@Test(groups = "smoke")
	public void Manage_Patient() throws Throwable {
	DoctorDashboardpage doctordashpage=new DoctorDashboardpage(driver);
	doctordashpage.patientsmenu().click();
    doctordashpage.managepatient().click();
    String managepatientpage = driver.getTitle();
    Assert.assertTrue(managepatientpage.equals("Doctor | Manage Patients"),"Manage patient page is not displayed");
  
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
   Assert.assertTrue(driver.getTitle().equals("Doctor | Manage Patients"), "Medical history is not created");
    
     Reporter.log("Medical history is sucessfully created",true);
	}

	//@Test
	public void Cancel_Patient() throws Throwable {
		DoctorDashboardpage doctordashpage=new DoctorDashboardpage(driver);
		 doctordashpage.appointmenthistory().click();
		    doctordashpage.cancelappointment().click();
		    String popupmsg = excelutils.Readdatafromexcelfile("Sheet1", 22, 1);
		    String conforncancel = excelutils.Readdatafromexcelfile("Sheet1", 23, 1);
		    webdriverutils.switchtoalertpopup(driver,popupmsg);
		   String text = driver.findElement(By.xpath("//tbody/tr[2]/td[7]")).getText();
		   Assert.assertTrue(text.contains(conforncancel), "Patient not cancelled");
		
		   Reporter.log("Cancel_Patient is pass",true);
	}
	@Test(groups = "smoke")
	public void Search_patient() throws Throwable {
		DoctorDashboardpage doctordashpage=new DoctorDashboardpage(driver);
		Addpatientpage addpatient=new Addpatientpage(driver);
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
	   Assert.assertTrue(title.equals(text), "Manage patient page is not displayed");
	   
	   Reporter.log("Search_Patient is pass",true);
	}
}
