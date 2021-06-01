package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
	WebDriver driver;
	String title;
	@BeforeMethod
	public void beforeMethod() {
		//Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		//Open browser
		driver.get("https://alchemy.hguy.co/jobs");
	}
	@Test
	public void getAlchemyWebsiteSecondTitle() {
		// Check the title of the page

		title = driver.findElement(By.xpath("//h2")).getText();

		//Print the title of the page
		System.out.println("Website Header second title is: " + title);

		//Assertion for page title
		Assert.assertEquals("Quia quis non", title);	
	}


	@AfterMethod
	public void afterMethod() {

		driver.quit();

	}


}