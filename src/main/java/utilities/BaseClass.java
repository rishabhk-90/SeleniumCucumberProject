package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Logger log = LogManager.getLogger(BaseClass.class);
    public static final String configFilePath = "C:\\Users\\Resham Seth\\Downloads\\SeleniumCucumberProject\\src\\test\\resources\\Config.properties";

    public static WebDriver initializeDriver() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, 10);
        log.debug("Driver Initialized successfully");
        return driver;
    }


    public static Properties readConfigFile(String filePath) {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties.load(fileInputStream);

            return properties;

        } catch (IOException exp) {
            log.error("Error in reading config properties file");
        }
        return null;
    }

    public static void openApplication(String applicationName) {

        Properties prop = readConfigFile(configFilePath);

        switch (applicationName) {
            case "NewTours":
                driver.get(prop.getProperty("NewTours"));
                log.info("Opening New Tours application");
                break;
            case "Automation Practice":
                driver.get(prop.getProperty("AutomationPractice"));
                log.info("Opening Automation Practice application");
                break;
            case "AirAsia":
                driver.get(prop.getProperty("AirAsia"));
                log.info("Opening Air Asia application");
                break;
            default:
                log.error("Unable to open application. Provided name does not match any options");

        }
    }


}
