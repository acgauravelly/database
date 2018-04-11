package Util;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Created by ajay on 10/08/2017.
 */
public class Connector {

    public static WebDriver driver;

    public static WebDriver getCurrentDriver() {
        final String PROXY = "138.201.186.128:80";
        if (driver == null) {

            Proxy proxy = new Proxy();
            proxy.setHttpProxy(PROXY).setSslProxy(PROXY).setFtpProxy(PROXY).setSocksProxy(PROXY);
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(CapabilityType.PROXY, proxy);
            driver = new FirefoxDriver(capabilities);

        }
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        return driver;
    }

    public static void quit() {
        getCurrentDriver().quit();
        driver = null;
    }
}
