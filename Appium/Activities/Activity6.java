package MobileApp;

import static org.testng.Assert.assertEquals;
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
public class Activity6 {
	
	AndroidDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
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
    public void ValidSignup() {
    	    	
    	wait = new WebDriverWait(driver,30);
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
    	
    	//-- Scroll to view    	
    	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"Popups\"))")).click();
    	
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	driver.findElementByXPath("//android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View[1]/android.view.View[4]/android.widget.Button").click();
    	
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	// -- Valid Credentials
    	
    	driver.findElementByXPath("//android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]").sendKeys("admin");
    	driver.findElementByXPath("//android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]").sendKeys("password");
    	driver.findElementByXPath("//android.view.View/android.view.View[2]/android.view.View/android.widget.Button").click();
    	
    	//--Assertions
    	
    	WebElement msg = driver.findElement(By.xpath("//*[@text='Welcome Back, admin']"));
     System.out.println(msg.getText());
     Assert.assertEquals(msg.getText(), "Welcome Back, admin");
    }
    @Test(priority=2)
    public void FormClear() {
    	
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElementByXPath("//android.webkit.WebView/android.view.View[1]/android.view.View[5]/android.widget.Button").click();
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	// --- Clearing the credentials
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	
 	driver.findElementByXPath("//android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]").clear();
       	
 	driver.findElementByXPath("//android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]").clear();
 	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
     	
    @Test(priority=3)
    public void InvalidSignup() {
    	// -- Invalid Credentials
     	
    	driver.findElementByXPath("//android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]").sendKeys("admin");
    	driver.findElementByXPath("//android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]").sendKeys("passwrd");
    	driver.findElementByXPath("//android.view.View/android.view.View[2]/android.view.View/android.widget.Button").click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	//--Assertions
    	
     WebElement message = driver.findElement(By.xpath("//*[@text='Invalid Credentials']"));
     System.out.println(message.getText());
     Assert.assertEquals(message.getText(), "Invalid Credentials");   	
    }
}
  