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

public class Activity3 {
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
  @Test(priority=0)
  public void sum() {
	  driver.findElementById("digit_5").click();
	  driver.findElementByAccessibilityId("plus").click();
	  driver.findElementById("digit_9").click();
	  driver.findElementByAccessibilityId("equals").click();
	  String TestResult=driver.findElementById("result").getText();
	  System.out.println(TestResult);
	  Assert.assertEquals(TestResult, "14");
  }
  
  @Test(priority=1)
  public void substract() {
	  driver.findElementById("digit_1").click();
	  driver.findElementById("digit_0").click();
	  driver.findElementByAccessibilityId("minus").click();
	  driver.findElementById("digit_5").click();
	  driver.findElementByAccessibilityId("equals").click();
	  String TestResult=driver.findElementById("result").getText();
	  System.out.println(TestResult);
	  Assert.assertEquals(TestResult, "5");
  }
  
  @Test(priority=2)
  public void multiply() {
	  driver.findElementById("digit_5").click();
	  driver.findElementByAccessibilityId("multiply").click();
	  driver.findElementById("digit_1").click();
	  driver.findElementById("digit_0").click();
	  driver.findElementById("digit_0").click();
	  driver.findElementByAccessibilityId("equals").click();
	  String TestResult=driver.findElementById("result").getText();
	  System.out.println(TestResult);
	  Assert.assertEquals(TestResult, "500");
  }
  
  @Test(priority=3)
  public void div() {
	  driver.findElementById("digit_5").click();
	  driver.findElementById("digit_0").click();
	  driver.findElementByAccessibilityId("divide").click();
	  driver.findElementById("digit_2").click();
	  driver.findElementByAccessibilityId("equals").click();
	  String TestResult=driver.findElementById("result").getText();
	  System.out.println(TestResult);
	  Assert.assertEquals(TestResult, "25");
  }
  
  @AfterTest
  public void closeMobile() {
	  driver.quit();
  }
  
  }