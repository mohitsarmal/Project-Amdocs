package classProject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pom{
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public Pom(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        PageFactory.initElements(driver, this);
    }

    // Page Elements
    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "userEmail")
    private WebElement emailInput;

    @FindBy(css = "label[for='gender-radio-1']")
    private WebElement genderRadio;

    @FindBy(id = "userNumber")
    private WebElement mobileInput;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthInput;

    @FindBy(className = "react-datepicker__month-select")
    private WebElement monthDropdown;

    @FindBy(className = "react-datepicker__year-select")
    private WebElement yearDropdown;

    @FindBy(xpath = "//div[contains(@class, 'react-datepicker__day') and text()='28']")
    private WebElement dayElement;

    @FindBy(css = ".subjects-auto-complete__input input")
    private WebElement subjectsInput;

    @FindBy(css = "label[for='hobbies-checkbox-1']")
    private WebElement hobbies1Checkbox;

    @FindBy(css = "label[for='hobbies-checkbox-2']")
    private WebElement hobbies2Checkbox;

    @FindBy(css = "label[for='hobbies-checkbox-3']")
    private WebElement hobbies3Checkbox;

    @FindBy(id = "uploadPicture")
    private WebElement uploadPictureInput;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressInput;

    @FindBy(id = "react-select-3-input")
    private WebElement stateInput;

    @FindBy(id = "react-select-4-input")
    private WebElement cityInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    // Helper Method to Scroll and Click
    private void scrollAndClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    // Helper Method to Wait for Visibility
    private void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Helper Method to Click Using JavaScript
    private void clickElementUsingJavaScript(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Helper Method to Switch to iFrame
    private void switchToIframe(By iframeLocator) {
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(iframeLocator));
        driver.switchTo().frame(iframe);
    }

    // Helper Method to Switch to Default Content
    private void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void selectGender() {
        scrollAndClick(genderRadio);
    }

    public void enterMobile(String mobileNumber) {
        mobileInput.sendKeys(mobileNumber);
    }

    public void selectDateOfBirth(String month, String year, String day) {
        scrollAndClick(dateOfBirthInput);
        new Select(monthDropdown).selectByVisibleText(month);
        new Select(yearDropdown).selectByVisibleText(year);
        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='" + day + "']")));
        scrollAndClick(dayElement);
    }

   // public void selectSubjects(String subject) throws InterruptedException {
//        ((JavascriptExecutor) driver).executeScript("argument[0].scrollIntoView(true);",subjectsInput);
//        Thread.sleep(2000);
//
//            subjectsInput.sendKeys(subject);
//            subjectsInput.sendKeys(Keys.TAB);
//
//
//    }
   public void selectSubjects(String subject) throws InterruptedException {
       WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
       subjectsInput.sendKeys(subject);
       Thread.sleep(1000); // Wait for the dropdown to appear (use explicit wait in production code)
       subjectsInput.sendKeys(Keys.ENTER); // Press Enter to select the subject
   }


    public void selectHobbies() {
        scrollAndClick(hobbies1Checkbox);
        scrollAndClick(hobbies2Checkbox);
        scrollAndClick(hobbies3Checkbox);
    }

    public void uploadPicture(String filePath) {
        uploadPictureInput.sendKeys(filePath);
    }

    public void enterCurrentAddress(String address) {
        waitForElementToBeVisible(currentAddressInput);
        scrollAndClick(currentAddressInput);
        currentAddressInput.clear();
        currentAddressInput.sendKeys(address);
    }

    public void selectState(String stateName) {
        stateInput.sendKeys(stateName);
        stateInput.sendKeys(Keys.ENTER);
    }

    public void selectCity(String cityName) {
        cityInput.sendKeys(cityName);
        cityInput.sendKeys(Keys.ENTER);
    }

    public void clickSubmit() {
        clickElementUsingJavaScript(submitButton);
    }
}
