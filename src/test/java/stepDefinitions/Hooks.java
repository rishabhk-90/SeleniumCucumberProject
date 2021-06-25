package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;
import utilities.TestUtil;

import java.io.IOException;

public class Hooks extends BaseClass {

    public WebDriver driver;

    @Before("@NewTours")
    public void initDriverNewTours() {

        driver = BaseClass.initializeDriver();
        log.info("Opening browser for NewTours application");
    }

    @Before("@AutomationPractice")
    public void initDriverAutoPractice() {

        driver = BaseClass.initializeDriver();
        log.info("Opening browser for Automation Practice application");
    }

    @Before("@AirAsia")
    public void initDriverAirAsia() {

        driver = BaseClass.initializeDriver();
        log.info("Opening browser for Air Asia application");
    }

    @AfterStep
    public void as(Scenario scenario) {
        try {
            scenario.attach(TestUtil.getByteScreenshot(), "image/png", "screenshot");
        } catch (IOException e) {
            log.info("Error getting screenshot: -> " + e.getMessage());
        }
    }

    @After
    public void teardown() {
        driver.quit();
        log.info("Closing browser");
    }
}
