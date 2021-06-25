package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.airasia.AirAsiaFlightSearchPage;
import pageObjects.airasia.AirAsiaHomePage;
import utilities.BaseClass;
import utilities.TestUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class AirAsiaSteps extends TestUtil {

    AirAsiaHomePage homePage = new AirAsiaHomePage(driver);
    AirAsiaFlightSearchPage flightSearchPage = new AirAsiaFlightSearchPage(driver);

    @When("User enters the required flight search details")
    public void user_enters_the_required_flight_search_details(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> searchDetails = dataTable.asMaps(String.class, String.class);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(homePage.getFlights()));
        try {
            homePage.getFlights().click();
            wait.until(ExpectedConditions.alertIsPresent());
            Alert simpleAlert = driver.switchTo().alert();
            simpleAlert.dismiss();
            System.out.println("Alert closed");
        } catch (Exception e) {
            homePage.closeAlert();

            System.out.println("Alert closed in catch block");
        }

        wait.until(ExpectedConditions.visibilityOf(homePage.getTripType()));
        homePage.getTripType().click();
        homePage.getOneWayTrip().click();
        Thread.sleep(2000);

        homePage.getOrigin().click();
        homePage.getOrigin().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        homePage.getOrigin().sendKeys(searchDetails.get(0).get("From"));
        homePage.getOrigin().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        Thread.sleep(2000);
        homePage.getDestination().click();
        homePage.getDestination().sendKeys(searchDetails.get(0).get("To"));
        homePage.getDestination().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        Thread.sleep(2000);
        homePage.getDepartDate().click();
        homePage.getDepartDate().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        homePage.getDepartDate().sendKeys("23/09/2021");
        homePage.getCloseCalendar().click();

    }

    @When("User Clicks on Search button")
    public void user_clicks_on_search_button() throws InterruptedException {

        try{
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(homePage.getSearchButton())));
            homePage.getSearchButton().click();
            log.debug("Clicked on Search");
            Thread.sleep(3000);

        }catch(Exception e){
            log.error("Issue found when searching for flights: "+e.getMessage());
        }


    }

    @Then("Flight search results are displayed on a new tab")
    public void flight_search_results_are_displayed_on_a_new_tab() throws InterruptedException {

        String pageTitle = "";
        String mainWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        log.debug("Parent Window: " + mainWindow);
        for (String s : windows) {
            log.debug("Windows returned: " + s);
            if (!mainWindow.equalsIgnoreCase(s)) {
                log.debug("Inside if block working on child Window " + s);
                driver.switchTo().window(s);
                Thread.sleep(2000);
                pageTitle = driver.getTitle();
            }
        }

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert simpleAlert = driver.switchTo().alert();
            simpleAlert.dismiss();
            log.info("Alert closed");
        } catch (Exception e) {
            flightSearchPage.acceptPrivacyAlert();
            log.info("Alert closed in catch block");
        }
        //verify if the correct trip is being searched
        log.info("Expected title: New Delhi DEL – London LHR trips | Actual title: " + pageTitle);
        Assert.assertEquals(pageTitle, "New Delhi DEL\u200E – London LHR\u200E trips");
    }

    @Then("Total number of search results should not be zero")
    public void total_number_of_search_results_should_not_be_zero() {
        int count = flightSearchPage.countOfResult();
        log.info("Total Flight search count : " + count);

        //verify if there are any valid searches with prices shown
        Assert.assertTrue(count > 0);

    }
}
