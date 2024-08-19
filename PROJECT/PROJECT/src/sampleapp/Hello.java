package sampleapp;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Hello {
    public static void main(String[] args) {
        System.out.print("Test");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\91769\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        try {
            driver.get("https://demoqa.com/automation-practice-form");

            //BASIC DETAILS
            driver.findElement(By.id("firstName")).sendKeys("Sahil");
            driver.findElement(By.id("lastName")).sendKeys("Chowdhary");
            driver.findElement(By.id("userEmail")).sendKeys("spsahilchowdhary@gmail.com");

            //RADIO BUTTON
            WebElement radio = driver.findElement(By.cssSelector("label[for='gender-radio-1']"));
            radio.click();

            //NUMBER
            driver.findElement(By.id("userNumber")).sendKeys("9894598985");

            // DATE
            WebElement dateElement = driver.findElement(By.id("dateOfBirthInput"));
            dateElement.click();

            // Select year
            WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
            Select selectYear = new Select(yearDropdown);
            selectYear.selectByVisibleText("2002");

            // Select month
            WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
            Select selectMonth = new Select(monthDropdown);
            selectMonth.selectByVisibleText("November");

            // Select day
            WebElement day = driver.findElement(By.className("react-datepicker__day--016"));
            day.click();

            //SUBJECTS
            WebElement subjectInput = driver.findElement(By.cssSelector(".subjects-auto-complete__input input"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", subjectInput);

            subjectInput.sendKeys("Physics");
            Thread.sleep(1000);
            subjectInput.sendKeys(Keys.TAB); // Ensure to trigger the selection


            subjectInput.sendKeys("English");
            Thread.sleep(1000);
            subjectInput.sendKeys(Keys.TAB);// Ensure to trigger the selection

            subjectInput.sendKeys("Computer Science");
            Thread.sleep(1000);
            subjectInput.sendKeys(Keys.TAB); // Ensure to trigger the selection


            //CHECKBOX
            WebElement checkbox1 = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
            checkbox1.click();
            WebElement checkbox2 = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']"));
            checkbox2.click();

            //IMAGE
            driver.findElement(By.id("uploadPicture")).sendKeys("D:\\Passport_photo.jpg");

            //ADDRESS
            driver.findElement(By.id("currentAddress")).sendKeys("Green Enclave Dagana Road Hoshiarpur");

            //STATE AND CITY
            WebElement state = driver.findElement(By.id("react-select-3-input"));
            state.sendKeys("Haryana");
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMillis(1000));
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id^='react-select-3-option'")));
            WebElement suggestions1 = driver.findElement(By.xpath("//div[@id='react-select-3-option-2']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",suggestions1);

            WebElement city = driver.findElement(By.id("react-select-4-input"));
            city.sendKeys("Panipat");
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id^='react-select-4-option'")));
            WebElement suggestions2 = driver.findElement(By.xpath("//div[@id='react-select-4-option-1']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",suggestions2);

            //SUBMIT BUTTON
            driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);

        } catch (Exception ex) {
            System.out.println("found error");
            ex.printStackTrace();
            driver.quit();
        }
    }
}
/*import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions;
import org.openqa.selenium.interactions.Actions;

public class Hello
{
    public static void main(String[]args) {
        //System.out.print("Test");
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\91769\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\91769\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        WebDriver driver=new FirefoxDriver();
        //driver.get("www.google.com");
        //driver.close();
        //WebDriver driver = new FirefoxDriver();
      /*  try{
            driver.get("https://wwww.yahoo.com");
            System.out.println("Title:" + driver.getTitle());
            driver.quit();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            if (driver!=null)
            {
                driver.quit();
            }........................

        try {
//               driver.get("https://www.naukri.com");
//             driver.findElement(By.className("suggestor-input")).sendkeys("amdocs");
            //Actions builder


//            driver.get("https://demoqa.com/text-box");
//            Actions builder = new Actions(driver);
//           driver.findElement(By.id("userName")).sendKeys("Mohit");
//           driver.findElement(By.i("mohith@gmail.com");d("userEmail")).sendKeys
//            driver.findElement(By.id("currentAddress")).sendKeys("Gurugram");
//            driver.findElement(By.id("permanentAddress")).sendKeys("Gurugram");
//            driver.findElement(By.id("submit")).sendKeys("KEYS.ENTER");

//            driver.get("https://demoqa.com/checkbox");
//            Actions builder = new Actions(driver);
//            driver.findElement(By.className("rct-checkbox")).click();

//            driver.get("https://demoqa.com/radio-button");
//            Actions builder = new Actions(driver);
//            driver.findElement(By.cssSelector("yesRadio")).click();

            driver.get("https://demoqa.com/automation-practice-form");
//            Actions builder = new Actions(driver);
//            driver.findElement(By.id("firstName")).sendKeys("Mohit");


//            driver.get("https://demoqa.com/automation-practice-form");
//            Actions builder = new Actions(driver);
//            driver.findElement(By.id("lastName")).sendKeys("Sarmal");

         //   driver.findElement(By.id("firstName")).sendKeys("Mohit");




            driver.findElement(By.id("firstname")).sendKeys( "Mohit");

                driver.findElement(By.id("lastname")).sendKeys("Sarmal");

                driver.findElement(By.id("userEmail")). sendKeys( "sarmalm@gmail.com");

                WebElement radio = driver.findElement(By.cssSelector("label [for='gender-radio-1']"));

                radio.click();

                driver.findElement(By.id("userNumber")).sendKeys( "95455596260"); WebElement dateElement = driver.findElement(By.id("dateOfBirthInput"));

                ((JavascriptExecutor) driver).executeScript( "arguments[0].value='16 Nov 2002';", dateElement);



            }

        catch (Exception ex){
            ex.printStackTrace();
            driver.quit();
        }
    }
}
*/