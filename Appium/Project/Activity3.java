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

public class Activity3 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@BeforeTest
	public void setupMobile() throws IOException {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("deviceName", "Pixel4_Emulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");
		caps.setCapability("noReset", true);

		driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);

		System.out.println("opened tasks");
		wait = new WebDriverWait(driver, 10);
	}

	@Test

	public void calc() {

		// ---- Create Notes

		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("New text note")));

		driver.findElementByAccessibilityId("New text note").click();
		// ---- Title
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("editable_title")));
		driver.findElementById("editable_title").click();

		driver.findElementById("editable_title").sendKeys("new note1");
		// ---- Notes
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("edit_note_text")));
		driver.findElementById("edit_note_text").sendKeys("This is my notes for Appium Project");

		// ---- Set Reminder

		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("menu_switch_to_list_view")));
		driver.findElementById("menu_switch_to_list_view").click();
		String textBox = "resourceId(\"com.google.android.keep:id/menu_text\")";
		driver.findElement(MobileBy.AndroidUIAutomator(textBox)).click();

		driver.findElementByAccessibilityId("Open navigation drawer").click();

		// Assertion
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("index_note_title")));
		String result = driver.findElementById("index_note_title").getText();
		System.out.println(result);
		Assert.assertEquals(result, "new note1");

	}

	@AfterTest
	public void closeMobile() {
		driver.quit();
	}

}