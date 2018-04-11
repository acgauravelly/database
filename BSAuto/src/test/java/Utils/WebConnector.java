package Utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebConnector {

    public static WebDriver driver;
    final static String USERNAME = "raimond.ko";
    final static String AUTO_KEY = "r1p39KgXDx7KLxq92sTm";
    final static String URL = "https://" + USERNAME + ":" + AUTO_KEY + "@hub-cloud.browserstack.com/wd/hub";


    public static WebDriver getCurrentDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(Platform.WIN8);
        caps.setBrowserName("chrome");

        driver = new RemoteWebDriver(new URL(URL), caps);

        return driver;

    }

    public static void quit() throws MalformedURLException {
        getCurrentDriver().quit();
    }
}
