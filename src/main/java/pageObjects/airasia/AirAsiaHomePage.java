package pageObjects.airasia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.TestUtil;

public class AirAsiaHomePage extends TestUtil {

    public AirAsiaHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[starts-with(@class,'TripTypeSelector__TripTypeSelectInputWrapper')]")
    private WebElement tripType;

    @FindBy(xpath = "//div[starts-with(@class,'TripTypes__Label') and contains(text(),'One way')]")
    private WebElement oneWayTrip;

    @FindBy(xpath = "//div[starts-with(@class,'TripTypes__Label') and contains(text(),'Return')]")
    private WebElement returnTrip;

    @FindBy(xpath = "//div[starts-with(@class,'TripTypes__Label') and contains(text(),'Multi-city')]")
    private WebElement multiCityTrip;

    @FindBy(xpath = "//p[@id='airasia-dropdown-options-title' and contains(text(),'Guest')]")
    private WebElement guestOptions;

    @FindBy(xpath = "//div[starts-with(@class,'SelectionStepper__LabelContainer')]" +
            "/p[contains(text(),'Adult')]/parent::div/following-sibling::div/div/div[1]")
    private WebElement adultMinus;

    @FindBy(xpath = "//div[starts-with(@class,'SelectionStepper__LabelContainer')]" +
            "/p[contains(text(),'Adult')]/parent::div/following-sibling::div/div/div[2]")
    private WebElement adultPlus;

    @FindBy(xpath = "//input[@id='flight-place-picker' and @label='From']")
    private WebElement origin;

    @FindBy(xpath = "//input[@id='flight-place-picker' and @label='To']")
    private WebElement destination;

    @FindBy(xpath="//button[@id='wzrk-cancel']")
    private WebElement alertConfirmButton;

    @FindBy(xpath="//input[@label='Depart']")
    private WebElement departDate;

    @FindBy(xpath="//*[@id='fsw-search-button-container']")
    private WebElement searchButton;

    @FindBy(xpath="(//div[@id='aa-web-search-button'])[1]")
    public WebElement submitButton;

    @FindBy(id="flights-productTile-tile-1")
    private WebElement flights;



    @FindBy(xpath="//*[@id='closebutton']")
    private WebElement closeCalendar;

    public WebElement getCloseCalendar() {
        return closeCalendar;
    }

    public WebElement getFlights() {
        return flights;
    }

    public void closeAlert() {
        if(alertConfirmButton.isDisplayed())
        //wait.until(ExpectedConditions.alertIsPresent());
            alertConfirmButton.click();
    }

    public WebElement getTripType() {
        return tripType;
    }

    public WebElement getOneWayTrip() {
        return oneWayTrip;
    }

    public WebElement getReturnTrip() {
        return returnTrip;
    }

    public WebElement getMultiCityTrip() {
        return multiCityTrip;
    }

    public WebElement getGuestOptions() {
        return guestOptions;
    }

    public WebElement getAdultMinus() {
        return adultMinus;
    }

    public WebElement getAdultPlus() {
        return adultPlus;
    }

    public WebElement getOrigin() {
        return origin;
    }

    public WebElement getDestination() {
        return destination;
    }

    public WebElement getAlertConfirmButton() {
        return alertConfirmButton;
    }

    public WebElement getDepartDate() {
        return departDate;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }
}
