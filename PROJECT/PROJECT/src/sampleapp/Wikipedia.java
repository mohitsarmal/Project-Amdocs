package sampleapp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Wikipedia {
    public static void main(String[] args) {

        WebDriver driver =new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "\"C:\\geckodriver.exe\"");
        try {
            driver.get("https://www.wikipedia.org/");
            List<WebElement> languageLinks = driver.findElements(By.cssSelector(".central-featured-lang a"));
            System.out.print(languageLinks.size());
            System.out.println(languageLinks);
            for (int i = 0; i < languageLinks.size(); i++) {
                try {
                    WebElement link = languageLinks.get(i);
                    String url = link.getAttribute("href");

                    if (url != null && !url.isEmpty()) {
                        System.out.println("Language Link: " + url);
                        link.click();
                        Thread.sleep(2000);
                        driver.navigate().back();
                        languageLinks = driver.findElements(By.cssSelector(".central-featured-lang a"));
                    }
                } catch (Exception e) {
                    System.out.println("Could not click link or navigate back: " + e.getMessage());
                }
            }
            WebElement languageDropdown = driver.findElement(By.id("searchLanguage"));
            Select selectLanguage = new Select(languageDropdown);
            selectLanguage.selectByVisibleText("Deutsch");

            WebElement searchInput = driver.findElement(By.id("searchInput"));
            if (searchInput != null) {
                searchInput.sendKeys("Selenium WebDriver");
                searchInput.sendKeys(Keys.RETURN);
                Thread.sleep(5000);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
