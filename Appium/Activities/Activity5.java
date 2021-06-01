package MobileApp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class Activity5 {
	AppiumDriver<MobileElement> driver=null;
	WebDriverWait wait;
 @BeforeTest
  public void setupMobile() throws IOException {
	  
	  
  DesiredCapabilities caps=new DesiredCapabilities();
  
 
  caps.setCapability("deviceName", "Pixel4_Emulator");
  caps.setCapability("platformName", "Android");
  caps.setCapability(  "automationName", "UiAutomator2" );
  caps.setCapability("appPackage", "com.google.android.apps.messaging");
  caps.setCapability("appActivity", ".ui.ConversationListActivity");
  caps.setCapability("noReset", true);
  
  driver=new  AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);
  
  System.out.println("opened smsapp");
  wait = new WebDriverWait(driver, 10);
  }
  @Test
  public void calc() throws Throwable {
	  
	  // Click on add new contact floating button
	  
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")).click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("recipient_text_view")));
	  

	  
		
		  String textBox=
		  "resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";
		  driver.findElement(MobileBy.AndroidUIAutomator(textBox)).sendKeys(
		  "8984689006");
		  
		  
		  Thread.sleep(2000);
		  
		  
			
			
			  String selectNum=
			  "resourceId(\"com.google.android.apps.messaging:id/contact_picker_create_group\")";
			  driver.findElement(MobileBy.AndroidUIAutomator(selectNum)).click();
			  
			  

			  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("compose_message_text")));
			  
			  String enterMsg=
			  "resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")";
			  driver.findElement(MobileBy.AndroidUIAutomator(enterMsg)).
			  sendKeys("Hello from Appium");
			  
				
				  String sendMsg=
				  "resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")";
				  driver.findElement(MobileBy.AndroidUIAutomator(sendMsg)).click();
				  
				  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id(
				  "message_text")));
				  
				  // Assertion 
				  String messageLocator =
				  "resourceId(\"com.google.android.apps.messaging:id/message_text\")"; 
				  String sentMessageText =
				  driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
				  Assert.assertEquals(sentMessageText, "Hello from Appium");
				  
				  
				  
				 
		       
      
  }
  
  @AfterTest
  public void closeMobile() {
	  driver.quit();
  }
  
  }
  
  