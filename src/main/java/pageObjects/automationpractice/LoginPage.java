package pageObjects.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseClass;
import utilities.TestUtil;

public class LoginPage extends TestUtil {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    private WebElement signInLink;

    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement emailToCreateAccount;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailToSignIn;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement password;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='create_account_error']/ol/li[contains(text(),'Invalid email address.')]")
    private WebElement errorMessage;

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getEmailToCreateAccount() {
        return emailToCreateAccount;
    }

    public WebElement getCreateAccountButton() {
        return createAccountButton;
    }

    public WebElement getSignInLink() {
        return signInLink;
    }

    public void signInToAccount(String email, String pass) {

        log.info("inside signInAccount method");
        enterTextValue(emailToSignIn,email);
        enterTextValue(password,pass);
        buttonClick(signInButton);
        log.info("Entered email and password");
        buttonClick(createAccountButton);
        log.info("Clicked on Create Account button");

    }

}
