package Utils;


import Pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static sun.net.www.protocol.http.AuthCacheValue.Type.Proxy;

public class WebConnector extends BasePage {

    public static WebDriver driver;
    public static String browserName = "Mozilla";

    public static WebDriver getCurrentDriver() {


        Proxy proxy = new Proxy();
        proxy.setHttpProxy("localhost:8090");
        proxy.setFtpProxy("localhost:8090");
        proxy.setSslProxy("localhost:8090");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        if (driver == null && browserName.equalsIgnoreCase("Mozilla")) {
            driver = new FirefoxDriver(capabilities);
        } else if (driver == null && browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (driver == null && browserName.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("window.focus()");
        return driver;
    }


    public void capabilities(){

    }
    public static void quit() {
        getCurrentDriver().quit();
        driver = null;
    }

}
