package Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;

	@BeforeMethod
	public void intiallizeBrowser() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://alchemy.hguy.co/jobs/");
	}
	@Test
	public void SearchJob() {
		//Click on Jobs
		driver.findElement(By.xpath("//li[@id= 'menu-item-24']/following::a")).click();
		driver.findElement(By.xpath("//li[1]/a")).click();
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_keywords")));
		driver.findElement(By.id("search_keywords")).sendKeys("Virtual Manufacturing Engineer",Keys.RETURN);
		driver.findElement(By.xpath("//h3[text()= 'Virtual Manufacturing Engineer']")).click();
		//input[@value= 'Apply for job']
		driver.findElement(By.xpath("//input[@value= 'Apply for job']")).click();
		String text=driver.findElement(By.className("job_application_email")).getText();
		System.out.println("To apply for this job email your details to "+text);


	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}