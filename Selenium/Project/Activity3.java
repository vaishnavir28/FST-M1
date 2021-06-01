package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
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
	public void getAlchemyImageurl() {
		// Check the image 
		title = driver.findElement(By.className("attachment-large")).getAttribute("src");

		//Print the src of image
		System.out.println("Image source url is : " + title);
	}

	@AfterMethod
	public void afterMethod() {

		driver.quit();

	}

}