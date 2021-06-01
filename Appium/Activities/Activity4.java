package MobileApp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
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

public class Activity4 {
	AppiumDriver<MobileElement> driver=null;
	WebDriverWait wait;
 @BeforeTest
  public void setupMobile() throws IOException {
	  
	  
  DesiredCapabilities caps=new DesiredCapabilities();
  
 
  caps.setCapability("deviceName", "Pixel4_Emulator");
  caps.setCapability("platformName", "Android");
  caps.setCapability(  "automationName", "UiAutomator2" );
  caps.setCapability("appPackage", "com.android.contacts");
  caps.setCapability("appActivity", ".activities.PeopleActivity");
  caps.setCapability("noReset", true);
  
  driver=new  AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);
  
  System.out.println("opened claculator");
  }
  @Test
  public void calc() {
	  
	  // Click on add new contact floating button
      driver.findElementByAccessibilityId("Create new contact").click();
      
      // Find the first name, last name, and phone number fields
      MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='First name']");
      MobileElement lastName = driver.findElementByXPath("//android.widget.EditText[@text='Surname']");
      MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");
      
      // Enter the text in the fields
      firstName.sendKeys("Aaditya");
      lastName.sendKeys("Varma");
      phoneNumber.sendKeys("9991284782");
      
      // Save the contact
      driver.findElementById("editor_menu_save_button").click();
      
      // Wait for contact card to appear
      wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));

      // Assertion
      MobileElement mobileCard = driver.findElementById("toolbar_parent");
      Assert.assertTrue(mobileCard.isDisplayed());
      
      String contactName = driver.findElementById("large_title").getText();
      Assert.assertEquals(contactName, "Aaditya Varma");
  }
  
  @AfterTest
  public void closeMobile() {
	  driver.quit();
  }
  
  }
  
  