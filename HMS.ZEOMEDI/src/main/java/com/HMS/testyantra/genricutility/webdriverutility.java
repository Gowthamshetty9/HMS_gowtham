package com.HMS.testyantra.genricutility;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverutility {
public void maximizewindow(WebDriver driver) {
	driver.manage().window().maximize();
}
public void minimizewindow(WebDriver driver) {
	driver.manage().window().minimize();
}
public void implicitwait(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
public void explicitwait(WebDriver driver,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
}
public void explicitwait(WebDriver driver,String title) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.titleIs(title));
}
public void explicitwaiturl(WebDriver driver,String url) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.urlToBe(url));
}
public void ignoreexception(WebDriver driver) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.ignoring(NoSuchElementException.class);
}
public void selectdropdownelement(WebDriver driver,WebElement element,int index) {
	Select select=new Select(element);
	select.selectByIndex(index);
}
public void selectdropdownelement(WebDriver driver,WebElement element,String text) {
	Select select=new Select(element);
	select.selectByVisibleText(text);
}
public void selectdropdownelement(WebDriver driver,WebElement element) {
	Select select=new Select(element);
	List<WebElement> alloptions = select.getOptions();
	for (WebElement eachoptions : alloptions) {
		String optiontext = eachoptions.getText();
		System.out.println(optiontext);
	}
}
public void mouseoveraction(WebDriver driver,WebElement element) {
	Actions actions=new Actions(driver);
	actions.moveToElement(element).perform();
}
public void scrolltoelement(WebDriver driver,WebElement element) {
	Actions actions=new Actions(driver);
	actions.scrollToElement(element).perform();
}
public void doubleclickaction(WebDriver driver,WebElement element) {
	Actions actions=new Actions(driver);
	actions.doubleClick(element).perform();
}
public void switchframe(WebDriver driver,String id) {
	driver.switchTo().frame(id);
}
public void switchframe(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
}
public WebElement activeelement(WebDriver driver) {
	WebElement active = driver.switchTo().activeElement();
	return active;
}
public void switchtoalertpopup(WebDriver driver,String text) {
	String popuptext = driver.switchTo().alert().getText().trim();
	if (popuptext.equalsIgnoreCase(text)) {
		driver.switchTo().alert().accept();
	}else {
		driver.switchTo().alert().dismiss();
	}
}
public void screanshot(WebDriver driver,String screanshotname) throws Throwable {
	TakesScreenshot ts=(TakesScreenshot) driver;
	File srcfile = ts.getScreenshotAs(OutputType.FILE);
	String datetime = LocalDateTime.now().toString().replace(':', '-');
	File destfile=new File("./screanshots/"+screanshotname+""+datetime+".png");
	FileUtils.copyFile(srcfile, destfile);
}
public void switchtowindow(WebDriver driver,String text) {
	Set<String> wids = driver.getWindowHandles();
	for (String wid : wids) {
		driver.switchTo().window(wid);
		String title = driver.getTitle();
		if (title.contains(text)) {
			break;
		}
	}
}
public void switchtopopup(WebDriver driver) {
	driver.switchTo().alert().accept();
}
}

	

