package utilities;

import com.aventstack.extentreports.reporter.FileUtil;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;

public class TestUtil extends BaseClass {

    public Logger log = LogManager.getLogger(this.getClass().getSimpleName());

    public void checkCheckBox(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
        if (!element.isSelected())
            element.click();
        log.debug("Checked the checkbox -> " + element);
    }

    public void unCheckCheckBox(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
        if (element.isSelected())
            element.click();
        log.debug("Un-checked the checkbox -> " + element);
    }

    public void buttonClick(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        log.debug("Clicked on button -> " + element);
    }

    public void enterTextValue(WebElement element, String text) {

        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        log.debug("Entered text, " + text + " in text box");
    }

    public void selectOptionFromDropdownByText(WebElement element, String text) {

        try {
            Thread.sleep(200);
            Select option = new Select(element);
            option.selectByVisibleText(text);
            log.debug("Option Selected from dropdown(by text): " + text);
        } catch (Exception e) {
            log.error("Error is selecting dropdown");
        }

    }

    public void selectOptionFromDropdownByValue(WebElement element, String text) {
        try {
            Thread.sleep(200);
            Select option = new Select(element);
            option.selectByValue(text);
            log.debug("Option Selected from dropdown(by value): " + text);

        } catch (Exception e) {
            log.error("Error is selecting dropdown option");
        }
    }


    public void verifyElementText(WebElement element, String text) {

        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(text, element.getText());
        log.info("Expected text: " + text + " | Actual text: " + element.getText());
    }

//    public static Scenario message;
//
//    public static void takeScreenShotAfterEveryStep() {
//        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
//        message.embed(screenshot, "image/png");
//    }

    public static byte[] getByteScreenshot() throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        return fileContent;
    }

    public static void selectDateUsingJSExecutor(WebDriver driver, WebElement element, String date){

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].setAttribute('value','"+date+"');",element);
        System.out.println("Selected Date :" +date);
    }
}
