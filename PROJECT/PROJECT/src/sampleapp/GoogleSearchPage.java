package sampleapp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class GoogleSearchPage {
    public static void main(String args[]) {
        WebDriver driver =new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "\"C:\\geckodriver.exe\"");
        try {
            driver.get("https://www.google.com");
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver");
            Thread.sleep(2000);

            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.DOWN).perform();  // Move to the first suggestion
            Thread.sleep(1000);
            actions.sendKeys(Keys.DOWN).perform();  // Move to the second suggestion
            Thread.sleep(1000);
            actions.sendKeys(Keys.RETURN).perform(); // Select the suggestion

            // Wait for the search results to load
            Thread.sleep(2000);
            System.out.println("Page Title: " + driver.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            driver.quit();
        }
    }

}
