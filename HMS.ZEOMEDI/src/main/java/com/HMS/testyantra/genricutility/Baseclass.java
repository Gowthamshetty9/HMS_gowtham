package com.HMS.testyantra.genricutility;

import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.HMS.testyantra.POM_repository.DoctorDashboardpage;
import com.HMS.testyantra.POM_repository.Loginpage;
import com.beust.jcommander.Parameter;

public class Baseclass {
	public  static WebDriver driver;
	public excelutility excelutils=new excelutility();
	public fileutility fileutils=new fileutility();
	public webdriverutility webdriverutils=new webdriverutility();
	public javautility javautils=new javautility();
	public DataBaseutility dbutils=new DataBaseutility();
    // @Parameters("browser")
	@BeforeClass
	public void Openbrowser() throws Throwable {
		String browsername = fileutils.Readdatafromfile("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);
		}else if (browsername.equalsIgnoreCase("edge")) {
			EdgeOptions options1=new EdgeOptions();
			options1.addArguments("--remote-allow-origins=*");
			driver=new  EdgeDriver(options1);
		}else {
			FirefoxOptions options2=new FirefoxOptions();
			options2.addArguments("--remote-allow-origins=*");
			driver=new FirefoxDriver(options2);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get(fileutils.Readdatafromfile("url"));
		
		//Loginpage loginpage=new Loginpage(driver);
		//loginpage.doctorslogin().click();
	}
	@AfterClass
	public void postconditions() {
		driver.manage().window().minimize();
		driver.quit();
	}
	@BeforeSuite
	public void connect_DB() throws Throwable {
		dbutils.open_DB();
		System.out.println("__connect to db__");
	}
	@AfterSuite
	public void close_DB() throws SQLException {
		dbutils.close_DB();
		System.out.println("__db connection closed__");
	}
	@BeforeMethod
	public void logintoapp() throws Throwable {
		//driver.get(fileutils.Readdatafromfile("url"));
		Loginpage loginpage=new Loginpage(driver);
		loginpage.doctorslogin().click();
		
		String USERNAME =fileutils.Readdatafromfile("username");
		String PASSWORD =fileutils.Readdatafromfile("password");

		loginpage.usernametextfield().sendKeys(USERNAME);
		loginpage.passwordtextfield().sendKeys(PASSWORD);
		loginpage.submitbutton().click();
	    String DashboardpgTitle = driver.getTitle();
	    if (DashboardpgTitle.contains("Dashboard")) {
	    	System.out.println("Login sucessfully Doctor's dashboard page is displayed");
		}else {
			System.out.println("Login sucessfully Doctor's dashboard page is not displayed");
		}
	}
	@AfterMethod
	public void logout() {
		DoctorDashboardpage doctordashpage=new DoctorDashboardpage(driver);
		doctordashpage.profileIcon().click();
	    doctordashpage.logoutbutton().click();
	    String HMShomepgTitle = driver.getTitle();
	    if (HMShomepgTitle.equals("Hospital Management System")) {
	    	System.out.println("Logout sucessfully and HMS homepage is displayed");
		}else {
			System.out.println("Logout not done and HMS homepage is not displayed");
		}
	}
	/*@Test
	public void test() {
		System.out.println("  testing   ");
	}*/
}
