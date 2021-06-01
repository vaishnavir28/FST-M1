package Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver;

	@BeforeMethod
	public void intiallizeBrowser() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://alchemy.hguy.co/jobs");
	}
	@Test
	public void PostJob() {
		//Click on Jobs
		driver.findElement(By.xpath("//li[3]/a")).click();
		//Email
		driver.findElement(By.id("create_account_email")).sendKeys("Tes11@gmail.com");
		//Location
		driver.findElement(By.id("job_location")).sendKeys("Bangalore");
		//Job Title
		driver.findElement(By.id("job_title")).sendKeys("SDET");
		//Job Type
		Select sel=new Select(driver.findElement(By.id("job_type")));
		sel.selectByVisibleText("Freelance");
		//Application email/URL
		driver.findElement(By.id("application")).sendKeys("https://w3.ibm.com/");
		//Company Name
		driver.findElement(By.id("company_name")).sendKeys("IBM");
		//Description
		driver.switchTo().frame("job_description_ifr");
		driver.findElement(By.xpath("//body")).sendKeys("Desc");
		driver.switchTo().defaultContent();
		//Preview
		driver.findElement(By.xpath("//p/input[4]")).click();
		//Submit job
		driver.findElement(By.id("job_preview_submit_button")).click();
		driver.findElement(By.id("menu-item-24")).click();
		driver.findElement(By.id("search_keywords")).sendKeys("Fullstacktester",Keys.RETURN);
		boolean JobTitle=driver.findElement(By.xpath("//h3[text()= 'Fullstacktester']")).isDisplayed();
		Assert.assertEquals(JobTitle, true);

	}
	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}
}