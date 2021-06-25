package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import pageObjects.automationpractice.CreateAccountPage;
import pageObjects.automationpractice.LoginPage;
import utilities.BaseClass;
import utilities.TestUtil;

import java.util.List;
import java.util.Map;

public class AutomationPracticeSteps extends TestUtil {

    public Logger log = LogManager.getLogger(this.getClass().getSimpleName());

    LoginPage loginPage = new LoginPage(driver);
    CreateAccountPage registerUser = new CreateAccountPage(driver);

    Faker faker = new Faker();

    @Given("User opens {string} application")
    public void user_is_on_the_my_store_page(String applicationName) {
        openApplication(applicationName);
    }

    @When("User clicks on Sign In link")
    public void user_clicks_on_sign_in_link() {
        buttonClick(loginPage.getSignInLink());
    }

    @When("User enters email in the create account section and Clicks on Create Account button")
    public void user_enters_in_the_create_account_section_and_clicks_on_create_account_button() {
        enterTextValue(loginPage.getEmailToCreateAccount(), faker.internet().emailAddress());
        buttonClick(loginPage.getCreateAccountButton());
    }

    @When("User clicks on Create Account button")
    public void user_clicks_on() {

        loginPage.getEmailToCreateAccount().clear();
        log.info("Cleared email field");
        buttonClick(loginPage.getCreateAccountButton());
        log.info("Clicked on Create Account Button");

    }

    @Then("User should see error message {string}")
    public void user_should_see_error_message(String string) {
        verifyElementText(loginPage.getErrorMessage(), string);
    }

    @Then("User should land on {string} page")
    public void user_should_land_on_page(String expPageTitle) {
        String pageTitle = driver.getTitle();
        log.debug("Expected Page Title: " + expPageTitle + " | Actual Page Title: " + pageTitle);
        Assert.assertEquals(pageTitle, expPageTitle);

    }

    @When("User enters the required user details and clicks on Register button")
    public void user_enters_the_required_user_details_and_clicks_on_register_button(DataTable dataTable) throws InterruptedException {

        List<Map<String, String>> user = dataTable.asMaps(String.class, String.class);

        buttonClick(registerUser.getTitle());
        enterTextValue(registerUser.getFirstName(), faker.name().firstName());
        enterTextValue(registerUser.getLastName(), faker.name().lastName());
        enterTextValue(registerUser.getEmail(), faker.internet().emailAddress());
        enterTextValue(registerUser.getPassword(), "21212121");
        selectOptionFromDropdownByValue(registerUser.getDob_day(), "27");
        selectOptionFromDropdownByValue(registerUser.getDob_month(), "9");
        selectOptionFromDropdownByValue(registerUser.getDob_year(), "2000");
        enterTextValue(registerUser.getAddFirstName(), faker.name().firstName());
        enterTextValue(registerUser.getAddLastName(), faker.name().lastName());
        enterTextValue(registerUser.getAddressLine1(), faker.address().buildingNumber());
        enterTextValue(registerUser.getCity(), faker.address().city());
        selectOptionFromDropdownByText(registerUser.getState(), user.get(0).get("State"));
        selectOptionFromDropdownByText(registerUser.getCountry(), user.get(0).get("Country"));
        enterTextValue(registerUser.getPostcode(), "80808");
        enterTextValue(registerUser.getMobile(), "09804823");
        enterTextValue(registerUser.getAddressAlias(), user.get(0).get("AddressType"));
        buttonClick(registerUser.getRegisterButton());
        Thread.sleep(500);
    }

}