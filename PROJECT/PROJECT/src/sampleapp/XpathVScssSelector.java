package sampleapp;

import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.firefox. FirefoxDriver;
        import org.openqa.selenium.By;


public class XpathVScssSelector {


    public static void main(String[] args){
        WebDriver driver =new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        driver.get("https://www.wikipedia.org/");

// Using XPath
        WebElement searchInputXPath = driver.findElement(By.xpath("//input[@id='searchInput']"));
        searchInputXPath.sendKeys("Selenium (software)");

// Using CSS Selector
    WebElement searchInputCSS = driver.findElement(By.cssSelector("#searchInput"));
    searchInputCSS.sendKeys("WebDriver");
    driver.quit();
}}