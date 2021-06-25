package pageObjects.newtours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.TestUtil;

public class HomePage extends TestUtil {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'REGISTER')]")
    private WebElement registerLink;


    public void clickOnRegister(){
        wait.until(ExpectedConditions.elementToBeClickable(registerLink));
        registerLink.click();
    }


}
