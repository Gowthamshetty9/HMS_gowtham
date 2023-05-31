package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class FetchDataVerify {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		 WebElement username = driver.findElement(By.xpath("//label[.='Username']"));
		 username.click();
		 username.sendKeys("rmgyantra");
		WebElement password = driver.findElement(By.id("inputPassword"));
		password.click();
		password.sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		WebElement projectname = driver.findElement(By.name("projectName"));
		projectname.click();
		projectname.sendKeys("myntra");
		WebElement projectmgr = driver.findElement(By.xpath("//input[@name='createdBy"));
		projectmgr.click();
		projectmgr.sendKeys("ravikumar");
		WebElement dropdown = driver.findElement(By.xpath("//label[.='Project Status ']/..//select[@name='status']"));
		Select select=new Select(dropdown);
		select.selectByVisibleText("On Gogin");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from project");
		//boolean flag = false;
		while (result.next()) {
			System.out.println(result.getString(1));
		}
		connection.close();
	}
}
