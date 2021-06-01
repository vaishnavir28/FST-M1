package MobileApp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1 {
	AppiumDriver<MobileElement> driver=null;
 @BeforeTest
  public void setupMobile() throws IOException {
	  
	  
  DesiredCapabilities caps=new DesiredCapabilities();
  
 
  caps.setCapability("deviceName", "Pixel4_Emulator");
  caps.setCapability("platformName", "Android");
  caps.setCapability(  "automationName", "UiAutomator2" );
  caps.setCapability("appPackage", "com.android.calculator2");
  caps.setCapability("appActivity", ".Calculator");
  caps.setCapability("noReset", true);
  
  driver=new  AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);
  
  System.out.println("opened claculator");
  }
  @Test
  public void calc() {
	  driver.findElementById("digit_7").click();
	  driver.findElementByAccessibilityId("multiply").click();
	  driver.findElementById("digit_3").click();
	  driver.findElementByAccessibilityId("equals").click();
	  String TestResult=driver.findElementById("result").getText();
	  System.out.println(TestResult);
	  Assert.assertEquals(TestResult, "21");
  }
  
  @AfterTest
  public void closeMobile() {
	  driver.quit();
  }
  
  }
  
  
