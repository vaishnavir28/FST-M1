package MobileApp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@BeforeTest
	public void setupMobile() throws IOException {


		DesiredCapabilities caps=new DesiredCapabilities();
		  
		 
		  caps.setCapability("deviceName", "Pixel4_Emulator");
		  caps.setCapability("platformName", "Android");
		  caps.setCapability(  "automationName", "UiAutomator2" );
		  caps.setCapability("appPackage", "com.android.chrome");
		  caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		  caps.setCapability("noReset", true);
		  
		  driver=new  AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);
		  
		  System.out.println("opened chrome");
		  wait = new WebDriverWait(driver, 10);
		  }
		  @Test
		  public void calc() {
			  driver.get("https://www.training-support.net/");
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  
			  String pageTitle=driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
			  
			  System.out.println(pageTitle);

	}

	@AfterTest
	public void closeMobile() {
		driver.quit();
	}

}