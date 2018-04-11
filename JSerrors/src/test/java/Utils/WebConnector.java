package Utils;


import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

@SuppressWarnings("All")
public class WebConnector extends BasePage {

    public static WebDriver driver;
    public static String browserName = "Chrome";


    public static WebDriver getCurrentDriver() {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
//
//        Map<String, Object> perfLogPrefs = new HashMap<String, Object>();
//        perfLogPrefs.put("traceCategories", "browser,devtools.timeline,devtools"); // comma-separated trace categories
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("perfLoggingPrefs", perfLogPrefs);
//        cap.setCapability(ChromeOptions.CAPABILITY, options);

        Map<String, Object> perfLogPrefs = new HashMap<String, Object>();
        perfLogPrefs.put("traceCategories", "browser,devtools.timeline,devtools");
        perfLogPrefs.put("enableNetwork", true);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("perfLoggingPrefs", perfLogPrefs);
        cap.setCapability(ChromeOptions.CAPABILITY, options);

        if (driver == null && browserName.equalsIgnoreCase("Mozilla")) {
            //            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (driver == null && browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
            driver = new ChromeDriver(cap);
        } else if (driver == null && browserName.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
