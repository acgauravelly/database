package Utils;


import Pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebConnector extends BasePage {

    public static WebDriver driver;
    public static String browserName = "Mozilla";

    public static WebDriver getCurrentDriver()  {


//        // File firebug = new File(System.getProperty("user.dir") + "\\resources\\firebug-2.0.1.xpi");
//        // File netExport = new File(System.getProperty("user.dir") + "\\resources\\netExport-0.9b3.xpi");
//        File firebug = new File("C:\\Users\\ajay\\Desktop\\Automation\\Xpis\\firebug-2.0.17.xpi");
//        File netExport = new File("C:\\Users\\ajay\\Desktop\\Automation\\Xpis\\netExport-0.9b7.xpi");
//        // File harExport = new File("C:\\Users\\ajay\\Desktop\\Automation\\Xpis\\harexporttrigger-0.5.0-beta.10.xpi");
//try {
//
//
//        FirefoxProfile profile = new FirefoxProfile();
//
//        profile.addExtension(firebug);
//        profile.addExtension(netExport);
//        // profile.addExtension(harExport);
//        // Preferences for firebug
//        profile.setPreference("extensions.firebug.currentVersion", "2.0.17");
//        profile.setPreference("extensions.firebug.addonBarOpened", true);
//        profile.setPreference("extensions.firebug.console.enableSites", true);
//        profile.setPreference("extensions.firebug.script.enableSites", true);
//        profile.setPreference("extensions.firebug.net.enableSites", true);
//        profile.setPreference("extensions.firebug.previousPlacement", 1);
//        profile.setPreference("extensions.firebug.allPagesActivation", "on");
//        profile.setPreference("extensions.firebug.delayLoad", true);
//        profile.setPreference("extensions.firebug.onByDefault", true);
//        profile.setPreference("extensions.firebug.defaultPanelName", "net");
//        profile.setPreference("extensions.firebug.netSearchHeaders", true);
//        profile.setPreference("extensions.firebug.netRequestHeadersVisible", true);
//        profile.setPreference("extensions.firebug.netResponseHeadersVisible", true);
//        profile.setPreference("extensions.firebug.netCachedHeadersVisible", true);
//        profile.setPreference("extensions.firebug.netBFCacheResponses", true);
//        profile.setPreference("extensions.firebug.netSearchParameters", true);
//        profile.setPreference("extensions.netmonitor.har.contentAPIToken", true);
//        profile.setPreference("devtools.netmonitor.har.enableAutoExportToFile", true);
//        profile.setPreference("extensions.firebug.net.defaultPersist", false);
//
//
//        // Preferences for netexport
//        profile.setPreference("extensions.firebug.netexport.alwaysEnableAutoExport", true);
//        profile.setPreference("extensions.firebug.netexport.autoExportToFile", true);
//        profile.setPreference("extensions.firebug.netexport.Automation", true);
//        profile.setPreference("extensions.firebug.netexport.showPreview", true);
//        profile.setPreference("extensions.firebug.netexport.defaultLogDir", "C:\\CaptureNetworkTraffic");
//        profile.setPreference("extensions.firebug.netexport.defaultFileName", "test.Har");
//        // profile.setPreference("extensions.firebug.netexport.DownThemAll", ".html");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("Mozilla");
//        capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
//        capabilities.setCapability(FirefoxDriver.PROFILE, profile);

        if (driver == null && browserName.equalsIgnoreCase("Mozilla")) {
            driver = new FirefoxDriver();
        } else if (driver == null && browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (driver == null && browserName.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("window.focus()");
//
//    }catch (IOException e){
//    System.out.println(e.getCause());
//    }
        return driver;
    }

    public void capabilities(){

    }
    public static void quit() {
        getCurrentDriver().quit();
        driver = null;
    }

}
