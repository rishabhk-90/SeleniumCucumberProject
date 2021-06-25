package pageObjects.newtours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.TestUtil;

public class RegisterPage extends TestUtil {

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phone;

    @FindBy(xpath = "//input[@name='userName']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='address1']")
    private WebElement address1;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement city;

    @FindBy(xpath = "//input[@name='state']")
    private WebElement state;

    @FindBy(xpath = "//input[@name='postalCode']")
    private WebElement postalCode;

    @FindBy(xpath = "//select[@name='country']")
    private WebElement country;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement cnfPassword;

    @FindBy(xpath = "//input[@name='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//b[contains(text(),'Note: Your user name is')]")
    private WebElement registrationSuccess;


    public void clickOnSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getRegistrationSuccess() {
        return registrationSuccess;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getAddress1() {
        return address1;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getPostalCode() {
        return postalCode;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getCnfPassword() {
        return cnfPassword;
    }
}
