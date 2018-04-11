package Util;


import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebConnector extends BasePage {

    public static WebDriver driver;
    public static String browserName = "Chrome";
//            System.getProperty("browser");

    public static WebDriver getCurrentDriver() {


        if (driver == null && browserName.equalsIgnoreCase("Mozilla")) {
            driver = new FirefoxDriver();
        } else if (driver == null && browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (driver == null && browserName.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

//        ((JavascriptExecutor) getCurrentDriver()).executeScript("window.focus()");
        return driver;
    }



    public static void quit() {
        getCurrentDriver().quit();
        driver = null;
    }

}
