package Programs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium");
       WebElement button = driver.findElement(By.xpath("//button[contains(@class,'ui inverted huge blue')]"));
       System.out.println(button.getText());
       button.click();
        WebElement txt = driver.findElement(By.id("content"));
        System.out.println(txt.getText());
        driver.close();
    }
}	