package pageObjects.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    public CreateAccountPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "id_gender1")
    private WebElement title;

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "firstname")
    private WebElement addFirstName;

    @FindBy(id = "lastname")
    private WebElement addLastName;

    @FindBy(id = "days")
    private WebElement dob_day;

    @FindBy(xpath = "//select[@id='months']")
    private WebElement dob_month;

    @FindBy(id = "years")
    private WebElement dob_year;

    @FindBy(id = "address1")
    private WebElement addressLine1;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id = "id_country")
    private WebElement country;

    @FindBy(id = "phone_mobile")
    private WebElement mobile;

    @FindBy(id = "alias")
    private WebElement addressAlias;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    public WebElement getTitle() {
        return title;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getAddFirstName() {
        return addFirstName;
    }

    public WebElement getAddLastName() {
        return addLastName;
    }

    public WebElement getDob_day() {
        return dob_day;
    }

    public WebElement getDob_month() {
        return dob_month;
    }

    public WebElement getDob_year() {
        return dob_year;
    }

    public WebElement getAddressLine1() {
        return addressLine1;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getPostcode() {
        return postcode;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getMobile() {
        return mobile;
    }

    public WebElement getAddressAlias() {
        return addressAlias;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }
}
