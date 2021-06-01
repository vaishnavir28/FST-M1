package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
	WebDriver driver;
	String Title;
	@BeforeMethod
	public void intializeBrowser() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs");
	}
	@Test
	public void navigateToJobs() {
		driver.findElement(By.xpath("//li[@id= 'menu-item-24']/following::a")).click();

		Title = driver.getTitle();
		System.out.println("href"+Title);
		Assert.assertEquals(Title, "Job Dashboard – Alchemy Jobs");

	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}