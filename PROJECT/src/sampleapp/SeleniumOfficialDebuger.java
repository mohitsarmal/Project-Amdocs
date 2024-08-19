package sampleapp;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumOfficialDebuger {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.34.0-win64\\geckodriver.exe");

        // Set Chrome options (optional)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode (optional)

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to the Selenium official site
            driver.get("https://www.selenium.dev");
            // Example: Find and click on the "Downloads" link
            WebElement downloadsLink = driver.findElement(By.linkText("Downloads"));
            downloadsLink.click();

            // Example: Print the title of the current page
            System.out.println("Page title is: " + driver.getTitle());

            // Additional interactions can be added here...
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

