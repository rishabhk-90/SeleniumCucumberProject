package pageObjects.airasia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TestUtil;

import java.util.List;

public class AirAsiaFlightSearchPage extends TestUtil {

    public AirAsiaFlightSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//p[contains(text(),'Accept')]")
    private WebElement acceptAlert;

    public void acceptPrivacyAlert() {
        if (acceptAlert.isDisplayed())
            acceptAlert.click();
    }

    public int countOfResult() {

        List<WebElement> list = driver.findElements(By.xpath("//div[starts-with(@class,'ResultCardstyled__ResultCardActionsPrice')]" +
                "/div/child::strong/span[contains(text(),'£')]"));

        log.info("Count of Flights found: " + list.size());
        for (WebElement webElement : list) {
            log.debug(webElement.getText());
        }
        return list.size();
    }

}
