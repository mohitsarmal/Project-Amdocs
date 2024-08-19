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
public class Task3 {
    public static void main(String args[]) {
        try {
            WebDriver driver =new FirefoxDriver();
            System.setProperty("webdriver.gecko.driver", "\"C:\\geckodriver.exe\"");
            driver.get("https://example.com/");
            WebElement link = driver.findElement(By.linkText("More information..."));
            link.click();

            link = driver.findElement(By.linkText("Domains"));
            link.click();

            link = driver.findElement(By.linkText(".ARPA Registry"));
            link.click();

            link = driver.findElement(By.linkText("Protocols"));
            link.click();

            link = driver.findElement(By.linkText("Performance"));
            link.click();
            Thread.sleep(1000);

            link = driver.findElement(By.linkText("Numbers"));
            link.click();
            Thread.sleep(1000);

            link = driver.findElement(By.linkText("IPv6 (AFRINIC)"));
            link.click();
            Thread.sleep(1000);

            link = driver.findElement(By.linkText("About"));
            link.click();
            Thread.sleep(2000);

            link = driver.findElement(By.linkText("Performance Reporting"));
            link.click();
            Thread.sleep(2000);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }}
