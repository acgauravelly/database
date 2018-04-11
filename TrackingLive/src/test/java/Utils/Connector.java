package Utils;


import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Connector extends BasePage {

    public static WebDriver driver;


    public static WebDriver getCurrentDriver(){
        if (driver == null) {
            File firebug = new File("C:\\Users\\Ajay\\Desktop\\Automation\\Xpis\\firebug-2.0.17.xpi");
            File netExport = new File("C:\\Users\\Ajay\\Desktop\\Automation\\Xpis\\netExport-0.9b7.xpi");

//            ProfilesIni profilesIni=new ProfilesIni();
//            FirefoxProfile profile = profilesIni.getProfile("Track");
            FirefoxProfile profile = new FirefoxProfile();
            try {
                profile.addExtension(firebug);
                profile.addExtension(netExport);
                } catch (IOException e) {
                e.printStackTrace();
            }

            // Preferences for firebug
            profile.setPreference("extensions.firebug.currentVersion", "2.0.17");
            profile.setPreference("extensions.firebug.addonBarOpened", true);
            profile.setPreference("extensions.firebug.console.enableSites", true);
            profile.setPreference("extensions.firebug.script.enableSites", true);
            profile.setPreference("extensions.firebug.net.enableSites", true);
            profile.setPreference("extensions.firebug.previousPlacement", 1);
            profile.setPreference("extensions.firebug.allPagesActivation", "on");
            profile.setPreference("extensions.firebug.delayLoad", true);
            profile.setPreference("extensions.firebug.onByDefault", true);
            profile.setPreference("extensions.firebug.defaultPanelName", "net");
            profile.setPreference("extensions.firebug.netSearchHeaders", true);
            profile.setPreference("extensions.firebug.netRequestHeadersVisible", true);
            profile.setPreference("extensions.firebug.netResponseHeadersVisible", true);
            profile.setPreference("extensions.firebug.netCachedHeadersVisible", true);
            profile.setPreference("extensions.firebug.netBFCacheResponses", true);
            profile.setPreference("extensions.firebug.netSearchParameters", true);
            profile.setPreference("extensions.netmonitor.har.contentAPIToken", true);
            profile.setPreference("devtools.netmonitor.har.enableAutoExportToFile", true);
            profile.setPreference("extensions.firebug.net.defaultPersist", false);
            profile.setPreference("devtools.netmonitor.har.pageLoadedTimeout", "20000");



            // Preferences for netexport
            profile.setPreference("extensions.firebug.netexport.alwaysEnableAutoExport", true);
            profile.setPreference("extensions.firebug.netexport.autoExportToFile", true);
            profile.setPreference("extensions.firebug.netexport.saveFiles", true);
            profile.setPreference("extensions.firebug.netexport.Automation", true);
            profile.setPreference("extensions.firebug.netexport.showPreview", true);
            profile.setPreference("extensions.firebug.netexport.defaultLogDir", "C:\\CaptureNetworkTrafficLIVE");
            profile.setPreference("extensions.firebug.netexport.defaultFileName", "test.har");
            profile.setPreference("extensions.firebug.netexport.DownThemAll", ".html");
            profile.setPreference("extensions.firebug.netexport.pageLoadedTimeout", "60000");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("Mozilla");
            capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
            capabilities.setCapability(FirefoxDriver.PROFILE, profile);

//            initialise the Driver
            driver = new FirefoxDriver(profile);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        }


        return driver;
    }


    public static void quit(){
        getCurrentDriver().quit();
        driver=null;
    }
}
