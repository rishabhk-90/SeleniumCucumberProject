package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import pageObjects.newtours.HomePage;
import pageObjects.newtours.RegisterPage;
import utilities.TestUtil;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class NewToursSteps extends TestUtil {

    public Logger log = LogManager.getLogger(this.getClass().getSimpleName());

    HomePage homePage = new HomePage(driver);
    RegisterPage registerPage = new RegisterPage(driver);
    Faker faker = new Faker(new Locale("en-GB"));

    String password;

    @When("User clicks on Register link")
    public void user_clicks_on_register_link() {
        homePage.clickOnRegister();
    }

    @Then("User should be registered successfully and should see message as {string}")
    public void userShouldBeRegisteredSuccessfullyAndShouldSeeMessageAs(String arg0) {

        String actual = registerPage.getRegistrationSuccess().getText();
        log.info("Expected : " + arg0 + " | Actual : " + actual);
        Assert.assertEquals(arg0, actual);
    }

    @When("User enters the required registration details")
    public void user_enters_the_required_registration_details(DataTable dataTable) {
        List<Map<String, String>> user = dataTable.asMaps(String.class, String.class);

        registerPage.getFirstName().sendKeys(faker.name().firstName());
        registerPage.getLastName().sendKeys(faker.name().lastName());
        registerPage.getPhone().sendKeys(faker.phoneNumber().cellPhone());
        registerPage.getEmail().sendKeys(faker.internet().emailAddress());
        registerPage.getAddress1().sendKeys(faker.address().streetAddress());
        registerPage.getCity().sendKeys(faker.address().city());
        registerPage.getState().sendKeys(faker.address().state());
        registerPage.getPostalCode().sendKeys(faker.address().zipCode());
        selectOptionFromDropdownByText(registerPage.getCountry(), user.get(0).get("Country").toUpperCase());
        registerPage.getUserName().sendKeys(user.get(0).get("UserName"));
        password = faker.internet().password(5, 8);
        registerPage.getPassword().sendKeys(password);
        registerPage.getCnfPassword().sendKeys(password);
    }

    @When("Clicks on Submit button")
    public void clicks_on_submit_button() {
        registerPage.clickOnSubmit();
    }
}
