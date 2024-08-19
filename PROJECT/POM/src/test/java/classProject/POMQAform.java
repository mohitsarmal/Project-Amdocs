package classProject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class POMQAform{

    private WebDriver driver;
    private Pom formsPage;

    @BeforeClass
    public void setUpClass() {
        System.out.println("Initializing Demo QA form (POM)");
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
    }

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        formsPage = new Pom(driver);
    }

    @Test
    public void testFormSubmission() throws InterruptedException {
        formsPage.enterFirstName("Mohit");
        formsPage.enterLastName("Sarmal");
        formsPage.enterEmail("mohit28novem@gmail.com");
        formsPage.selectGender();
        formsPage.enterMobile("1234567890");
        formsPage.selectDateOfBirth("October", "2002", "28");
        try{
            formsPage.selectSubjects("Physics");
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        formsPage.selectHobbies();
        formsPage.uploadPicture("C:\\Screenshot (56).png");
        formsPage.enterCurrentAddress("123 jalandhar");
        formsPage.selectState("Haryana");
        formsPage.selectCity("Panipat");
        formsPage.clickSubmit();

        // Sleep added for demo purposes; avoid using in production code.
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        // Sleep added for demo purposes; avoid using in production code.
        Thread.sleep(3000);
        if (driver != null) {
           // driver.quit();
        }
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("Demo QA form (POM) completed.");
        // You can add any cleanup code here that needs to run after all tests
    }
}
