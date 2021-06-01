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
public class Activity4 {
	
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
        driver.get("https://www.training-support.net/selenium");
    }
        @Test(priority=1)
        public void AddingTask() {
        	WebDriverWait wait = new WebDriverWait(driver, 40);
        	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_shadow")));
        	
        	//-- Scroll to view
        	
        	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"To-Do List\"))")).click();
        	
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	
        	//driver.findElementByXPath("/android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.view.View[15]/android.view.View").click();
        	//driver.findElement(By.xpath("//*[@text='To-Do List']")).click();
        	  	        	
        	// --Adding Tasks
        	String[] tasks = {"Add tasks to list",
					  		  "Get number of tasks",
					  		  "Clear the list"};
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	
        	for(String task : tasks) {
        	driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[1]/android.widget.EditText").sendKeys(task);
        					
        	driver.findElementByXPath("//android.view.View/android.view.View[4]/android.view.View[1]/android.widget.Button").click();
        	}		
        }
        @Test(priority=2)
        public void ClearingTask() {
        	
        	//--Strike out each task
        	driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[2]/android.view.View").click();
        	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        	driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[3]/android.view.View").click();
        	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        	driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[4]/android.view.View").click();
        	//-- Clear All Task
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[3]").click();
        }
        @AfterClass
        public void afterClass() {
        	driver.quit();
    }
    }