import junit.framework.AssertionFailedError;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;


public class Utilities {
    Logger logger = Logger.getLogger(Utilities.class.getName());
    Properties OR = null;
    Properties Config = null;
    public static WebDriver driver = null;
    public static String browserName = System.getProperty("browser");
    static Utilities w = null;
    long startTime;
    long stopTime;

    public Utilities() {
        if (OR == null)

            try {
                OR = new Properties();
                FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\OR.properties");
                OR.load(fs);

                Config = new Properties();
                fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\" + OR.getProperty("testEnv") + "_config.properties");
                Config.load(fs);
            } catch (Exception e) {
                System.out.println("error initialising");
            }
        System.out.println(OR.getProperty("testEnv"));
        System.out.println(Config.getProperty("loginUrl"));

    }

    public WebDriver getCurrentDriver() {

        if (driver == null) {
            if (browserName.equalsIgnoreCase("Mozilla")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chrome\\chromedriver.exe");
                driver = new ChromeDriver();
            }
        }
        return driver;
    }

    public void navigate(String url) {
        getCurrentDriver().get(url);

    }

    public void typeText(By locator, String text) {
        getCurrentDriver().findElement(locator).clear();
        getCurrentDriver().findElement(locator).sendKeys(text);
    }

    public void clickElement(By locator) {
        getCurrentDriver().findElement(locator).click();
    }

    public boolean isElementPresent(By locator) {
        int count = getCurrentDriver().findElements(locator).size();
        if (count == 0)
            return false;
        else
            return true;
    }
    public int elementsCount(By locator)
    {
       int elementsCount= getCurrentDriver().findElements(locator).size();
        return elementsCount;
    }
    public boolean isElementDisplayed(By locator)
    {
        try {
        getCurrentDriver().findElement(locator).isDisplayed();
        return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public boolean isLoggedin(By locator) {


        if (isElementPresent(locator))
            return true;
        else
            return false;
    }

    public boolean assertTrue(String message,boolean condition) {

        try {
            Assert.assertTrue(message, condition);
            return true;
        } catch (AssertionFailedError e) {
            System.out.println(e.getMessage());

        }
        return false;


    }
    public void doDefaultLogin()
    {

    }

}



