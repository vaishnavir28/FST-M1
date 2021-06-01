package Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity9 {
	WebDriver driver;

	@BeforeTest
	public void IntializeBrowser() {
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");

	}

	@Test
	public void jobList() {
		driver.findElement(By.id("user_login")).sendKeys("root");
		//Location
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		//Job Title
		driver.findElement(By.id("wp-submit")).click();
		//click on job list
		driver.findElement(By.xpath("//div[text()= 'Job Listings']")).click();
		//webdriver wait to find to view
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class= 'page-title-action']")));
		//add new job
		driver.findElement(By.xpath("//a[@class= 'page-title-action']")).click();
		//close popup
		driver.findElement(By.xpath("//button[@aria-label= 'Close dialog']")).click();
		//ApplicationEmail
		driver.findElement(By.id("_application")).sendKeys("https://w3.ibm.com");
		//company mail
		driver.findElement(By.id("_company_website")).sendKeys("https://w3.ibm.com");
		//company location
		driver.findElement(By.id("_job_location")).sendKeys("Bangalore");
		//company name
		driver.findElement(By.id("_company_name")).sendKeys("IBM");

		//company twitter
		driver.findElement(By.id("_company_twitter")).sendKeys("IBM@Twitter");

		//company tagline
		driver.findElement(By.id("_company_tagline")).sendKeys("International Business machine");

		//date
		driver.findElement(By.id("_job_expires")).sendKeys("AUGUST31 2021");
		//Job Title
		driver.findElement(By.id("post-title-0")).sendKeys("SDET");
		//publish Job
		WebDriverWait wait1=new WebDriverWait(driver,20);
		wait1.until(ExpectedConditions.elementToBeClickable(By.className("editor-post-publish-button__button")));

		driver.findElement(By.className("editor-post-publish-button__button")).click();
		//Validate double check message
		boolean msg=driver.findElement(By.xpath("//p[text()= 'Double-check your settings before publishing.']")).isDisplayed();
		Assert.assertEquals(msg, true);
		//publish job
		driver.findElement(By.xpath("//button[text()= 'Publish']")).click();
		boolean jobCreated=driver.findElement(By.xpath("//a[text()= 'Full Stack tester']")).isDisplayed();
		Assert.assertEquals(jobCreated, true);	

	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}


}