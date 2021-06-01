package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {
	WebDriver driver;

	@BeforeMethod
	public void intiallizeBrowser() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}
	@Test
	public void LoginPage() {

		//Email
		driver.findElement(By.id("user_login")).sendKeys("root");
		//Location
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		//Job Title
		driver.findElement(By.id("wp-submit")).click();
		//get user name after login
		String user=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/ul[2]/li/a/span")).getText();
		Assert.assertEquals(user, "root");
	}
	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}
}