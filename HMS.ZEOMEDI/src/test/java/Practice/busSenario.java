package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class busSenario {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.findElement(By.xpath("//span[contains(@class,'chNavIcon appendBottom2 chSprite chBus')]")).click();
		WebElement from = driver.findElement(By.xpath("//input[@data-cy='fromCityVal']"));
		from.click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("mysore");
		driver.findElement(By.xpath("//span[.='Mysore, Karnataka']")).click();
		driver.switchTo().activeElement().sendKeys("mangalore");
		driver.findElement(By.xpath("//span[.='Mangaluru (Mangalore), Karnataka']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Fri May 12 2023']")).click();
		driver.findElement(By.id("search_button")).click();
		List<WebElement> travels = driver.findElements(By.xpath("//span[contains(@class,'latoBlack font')]"));
		List<WebElement> price = driver.findElements(By.xpath("//span[@id='price']"));

		int min = Integer.MAX_VALUE;
		String minAgency = "";
		for (int i = 0; i < travels.size(); i++) {
			String traveler = travels.get(i).getText();
			String amount = price.get(i).getText().replaceAll("[^0-9]", "");
			System.out.println(traveler + "-" + amount);
			int num = Integer.parseInt(amount);
			if (num< min) {
				min = num;
				minAgency = traveler;
			}

		}
		System.out.println(minAgency + "-" + min);
	}

}
