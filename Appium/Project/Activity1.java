package ProjectActivites;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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

public class Activity1 {
	AppiumDriver<MobileElement> driver=null;
	WebDriverWait wait;
 @BeforeTest
  public void setupMobile() throws IOException {
	  
	  
  DesiredCapabilities caps=new DesiredCapabilities();
  
 
  caps.setCapability("deviceName", "Pixel4_Emulator");
  caps.setCapability("platformName", "Android");
  caps.setCapability(  "automationName", "UiAutomator2" );
  caps.setCapability("appPackage", "com.google.android.apps.tasks");
  caps.setCapability("appActivity", ".ui.TaskListsActivity");
  caps.setCapability("noReset", true);
  
  driver=new  AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);
  
  System.out.println("opened tasks");
  wait = new WebDriverWait(driver, 10);
  }
  @Test
  
  
  public void calc() {
	  
	  String[] tasktoAdd= {
			  		"Complete Activity with Google Tasks",
			  		"Complete Activity with Google Keep",
			  		"Complete the second Activity Google Keep"
	  					};
	  for(String tasktoadd : tasktoAdd) {
	  
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
	    
	    driver.findElementByAccessibilityId("Create new task").click();
	    
	     wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
	     
	     driver.findElementById("add_task_title").sendKeys(tasktoAdd);
	     driver.findElementById("add_task_done").click();
	  }
	  
	 //Assertion
	  wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.id("task_name"),3));
	  List<MobileElement> taskAdded=driver.findElementsById("task_name");
	  Assert.assertEquals(taskAdded.size(),3);
	  Assert.assertEquals(taskAdded.get(2),"Complete Activity with Google Keep");
	  
	  
	     
  }
  
  @AfterTest
  public void closeMobile() {
	  driver.quit();
  }
  
  }
  