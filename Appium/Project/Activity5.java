package ProjectActivites;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity5 {

	AndroidDriver<MobileElement> driver = null;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "PixelEmulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);
		// Instantiate Appium Driver
		URL remoteURL = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(remoteURL, caps);
		driver.get("https://www.training-support.net/selenium/login-form");
	}

	@Test(priority = 0)
	public void SuccessfullyLoggedIn() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		
		// wait for the sign in frame
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath(
				"//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.view.View[1]")));

		// enter valid user name and password and click on login
		driver.findElementByXPath(
				"//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.widget.EditText[1]")
				.sendKeys("admin");
		driver.findElementByXPath(
				"//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.widget.EditText[2]")
				.sendKeys("password");

		driver.findElementByXPath(
				"//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.widget.Button")
				.click();
		// Assertion

		WebElement msg = driver.findElement(By.xpath("//*[@text='Welcome Back, admin']"));
		System.out.println(msg.getText());
		Assert.assertEquals(msg.getText(), "Welcome Back, admin");
		System.out.println("Valid Credentials : successful Login ");

	}

	@Test(priority = 1)
	public void clearInputCred() {

		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// clear user name and password entered in above method
		driver.findElementByXPath(
				"//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.widget.EditText[1]")
				.clear();
		driver.findElementByXPath(
				"//android.webkit.WebView/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.widget.EditText[2]")
				.clear();
		System.out.println("cleared Input");
	}

	@Test(priority = 2)
	public void invalidLogin() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		// wait for the sign in frame

		// enter invalid user name and password and click on login
		driver.findElementByXPath(
				"//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.widget.EditText[1]")
				.sendKeys("acdmin");
		driver.findElementByXPath(
				"//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.widget.EditText[2]")
				.sendKeys("passwodrd");

		driver.findElementByXPath(
				"//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.widget.Button")
				.click();
		// Assertion

		WebElement msg = driver.findElement(By.xpath("//*[@text='Invalid Credentials']"));
		System.out.println(msg.getText());
		Assert.assertEquals(msg.getText(), "Invalid Credentials");
		System.out.println("InValid Credentials : unsuccessful Login ");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}