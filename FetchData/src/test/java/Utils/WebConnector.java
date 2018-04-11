package Utils;


import Pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebConnector extends BasePage {

    public static WebDriver driver;
    public static String browserName = "Chrome";

    public static WebDriver getCurrentDriver() {


        if (driver == null && browserName.equalsIgnoreCase("Mozilla")) {
            ProfilesIni profile = new ProfilesIni();
//            FirefoxProfile prof = profile.getProfile("ChineseMC");
//            prof.setPreference("browser.helperApps.neverAsk.openFile","image/png");
//            prof.setPreference("browser.helperApps.neverAsk.saveToDisk","image/png");
////            prof.setPreference("browser.helperApps.neverAsk.saveToDisk","application/zip");
            driver = new FirefoxDriver();

        } else if (driver == null && browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (driver == null && browserName.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("window.focus()");
        return driver;
    }


    public void capabilities() {

    }

    public static void quit() {
        getCurrentDriver().quit();
        driver = null;
    }

}
