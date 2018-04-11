package Utils;


import Pages.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("All")
public class WebConnector extends BasePage {

    public static WebDriver driver;
    public static String browserName = "Chrome";
    public static String mobileBrowser = "Android";
    public static Dimension dimension;

    public static WebDriver getCurrentDriver() {
        if (driver == null && browserName.equalsIgnoreCase("Chrome")) {
            if (mobileBrowser.equalsIgnoreCase("iphone")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("-user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 6_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10A5376e Safari/8536.25");
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
                driver = new ChromeDriver(options);
            } else if (mobileBrowser.equalsIgnoreCase("android")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("-user-agent=Mozilla/5.0 (Linux; Android 4.4.2; Nexus 4 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Mobile Safari/537.36");
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
                driver = new ChromeDriver(options);
            } else if (mobileBrowser.equalsIgnoreCase("ipad")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("-user-agent=Mozilla/5.0 (iPad; CPU OS 6_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10A5376e Safari/8536.25");
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
                driver = new ChromeDriver(options);
            } else if (mobileBrowser.equalsIgnoreCase("windows phone")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("-user-agent=Mozilla/5.0 (compatible; MSIE 10.0; Windows Phone 8.0; Trident/6.0; IEMobile/10.0; ARM; Touch; NOKIA; Lumia 920)");
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
                driver = new ChromeDriver(options);
            }
//            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            if (mobileBrowser.equalsIgnoreCase("iphone5")) {
                dimension = new Dimension(320, 568);
                driver.manage().window().setSize(dimension);
            } else if (mobileBrowser.equalsIgnoreCase("Android")) {
                dimension = new Dimension(360, 640);
                driver.manage().window().setSize(dimension);
            } else if (mobileBrowser.equalsIgnoreCase("ipad")) {
                dimension = new Dimension(768, 1024);
                driver.manage().window().setSize(dimension);
            }

        }
        return driver;
    }
//            if (driver == null && browserName.equalsIgnoreCase("Mozilla")) {
//                //            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
//                driver = new FirefoxDriver();
//            } else if (driver == null && browserName.equalsIgnoreCase("Chrome")) {
//                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
//                driver = new ChromeDriver(options);
//            } else if (driver == null && browserName.equalsIgnoreCase("IE")) {
//                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
//                driver = new InternetExplorerDriver();
//            }
//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
////        ((JavascriptExecutor) driver).executeScript("window.focus()");
//        } else if (mobileBrowser.equalsIgnoreCase("android")) {
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("-user-agent=Mozilla/5.0 (Linux; Android 4.4.2; Nexus 4 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Mobile Safari/537.36");
//
//
//            if (driver == null && browserName.equalsIgnoreCase("Mozilla")) {
//                //            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
//                driver = new FirefoxDriver();
//            } else if (driver == null && browserName.equalsIgnoreCase("Chrome")) {
//                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
//                driver = new ChromeDriver(options);
//            } else if (driver == null && browserName.equalsIgnoreCase("IE")) {
//                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
//                driver = new InternetExplorerDriver();
//            }
//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//
//        }
////        dimension = new Dimension(300, 677);
////        driver.manage().window().setSize(dimension);
//        return driver;
//    }


    public void capabilities() {

    }

    public static void quit() {
//        proxy.stop();
//        getCurrentDriver().close();
        driver.quit();
        driver = null;
    }

}
