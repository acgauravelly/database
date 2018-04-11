package Utils;


import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by ajay on 22/06/2017.
 */
public class Util {

    public static WebDriver driver;
    public static BrowserMobProxyServer server;

    public static WebDriver getCurrentDriver() {

        server = new BrowserMobProxyServer();
        server.start();
        int port = server.getPort();
        Proxy proxy = ClientUtil.createSeleniumProxy(server);
//		Proxy proxy = new Proxy();
        DesiredCapabilities seleniumCapabilities = new DesiredCapabilities();
        seleniumCapabilities.setCapability(CapabilityType.PROXY, proxy);
        driver = new FirefoxDriver(seleniumCapabilities);
        System.out.println("Port started:" + port);


        return driver;
    }


    public static void close() {
        getCurrentDriver().close();
    }

    public static void quit() throws IOException {
        server.newHar("C:\\CaptureNetworkTraffic\\test.har");
        Har har = server.getHar();
        File harfile = new File("C:\\CaptureNetworkTraffic\\test.har");
        har.writeTo(harfile);
        server.stop();
        getCurrentDriver().quit();
        driver = null;

    }


}