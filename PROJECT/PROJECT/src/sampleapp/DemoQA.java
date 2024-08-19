package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoQA{
    public static void main(String[] args) {
        try {
            WebDriver driver =new FirefoxDriver();
            System.setProperty("webdriver.gecko.driver", "\"C:\\geckodriver.exe\"");
            driver.get("https://demoqa.com/automation-practice-form");
            driver.manage().window().maximize();

            JavascriptExecutor js = (JavascriptExecutor) driver;

            driver.findElement(By.id("firstName")).sendKeys("Mohit");
            driver.findElement(By.id("lastName")).sendKeys("Sarmal");
            driver.findElement(By.id("userEmail")).sendKeys("sarmalm7@gmail.com");


            WebElement genderRadioButton = driver.findElement(By.xpath("//label[text()='Male']"));
            js.executeScript("arguments[0].click();", genderRadioButton);
            driver.findElement(By.id("userNumber")).sendKeys("7718455491");


            WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
            js.executeScript("arguments[0].click();", dateOfBirthInput);
            WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
            Select monthSelect = new Select(monthDropdown);
            monthSelect.selectByVisibleText("March");
            WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
            Select yearSelect = new Select(yearDropdown);
            yearSelect.selectByVisibleText("2002");

            WebElement day = driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='31']"));
            js.executeScript("arguments[0].click();", day);


            WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
            subjectsInput.sendKeys("Computer Science");
            subjectsInput.sendKeys(Keys.ENTER);

            WebElement musicCheckbox = driver.findElement(By.xpath("//label[text()='Music']"));
            js.executeScript("arguments[0].click();", musicCheckbox);

            WebElement uploadPicture=driver.findElement(By.id("uploadPicture"));
            uploadPicture.sendKeys("C:\\Screenshot (56).png");

            driver.findElement(By.id("currentAddress")).sendKeys("La Casa PG , Gurugram , Haryana");

            WebElement ele=driver.findElement(By.id("react-select-3-input"));
            ele.sendKeys("Haryana");
            WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id^='react-select-3-option']")));
            WebElement suggestions=driver.findElement(By.xpath("//div[@id='react-select-3-option-2']"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",suggestions);
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();",suggestions);

            WebElement city = driver.findElement(By.id("react-select-4-input"));
            city.sendKeys("Panipat");
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id^='react-select-4-option'")));
            WebElement suggestions2 = driver.findElement(By.xpath("//div[@id='react-select-4-option-1']"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",suggestions2);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",suggestions2);

            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}


