package sampleapp;


import org.openqa.selenium.WebDriver;

        import org.openqa.selenium.firefox. FirefoxDriver;

public class Firefox{

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        WebDriver driver =new FirefoxDriver();

// Open a website
        driver.get("https://www.google.com");
        System.out.println("Page title is: "+driver.getTitle());
        driver.quit();
    }
        }