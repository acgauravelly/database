package Utils;


import Pages.BasePage;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("All")
public class WebConnector extends BasePage {

    public static WebDriver driver;
    public static String browserName = "Chrome";
    public static BrowserMobProxy proxy;
    String paramValue;

    public static WebDriver getCurrentDriver() {
        if (driver == null && browserName.equalsIgnoreCase("Mozilla")) {
            driver = new FirefoxDriver();

        } else if (driver == null && browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
//        ((JavascriptExecutor) driver).executeScript("window.focus()");
        return driver;
    }


    public void capabilities() {

    }

    public static void quit() {
//        proxy.stop();
//        getCurrentDriver().close();
        getCurrentDriver().quit();
        driver = null;
    }

}
