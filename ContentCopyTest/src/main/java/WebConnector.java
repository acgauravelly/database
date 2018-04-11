import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

@SuppressWarnings("ALL")
public class WebConnector {

    Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
    Properties OR = null;
    Properties Config = null;
    public WebDriver driver = null;
    WebDriver mozilla = null;
    WebDriver html = null;
    WebDriver chrome = null;
    WebDriver ie = null;
    static WebConnector w = null;
    long startTime;
    long stopTime;

  /*8  public WebConnector() {
        if (OR == null)

            try {
                OR = new Properties();
                FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\OR.properties");
                OR.load(fs);

                Config = new Properties();
                fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\" + OR.getProperty("testEnv") + "_config.properties");
                Config.load(fs);
            } catch (Exception e) {
                System.out.println("error initialising");
            }
        System.out.println(OR.getProperty("testEnv"));
        System.out.println(Config.getProperty("loginUrl"));

    }
**/
    public void openBrowser(String browserType) {
        log("opening browser" + "-----" + browserType);
        if (browserType.equals("Mozilla") && mozilla == null) {
            ProfilesIni profile = new ProfilesIni();

//            FirefoxProfile myprofile = profile.getProfile("Local");
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Mozilla\\geckodriver.exe");
            driver = new FirefoxDriver();
            /**        driver= new FirefoxDriver();
             DesiredCapabilities capabilities = DesiredCapabilities.firefox();
             capabilities.setCapability("marionette", true);

             driver = new FirefoxDriver(capabilities);**/
            mozilla = driver;
        } else if (browserType.equals("Mozilla") && mozilla != null) {
            driver = mozilla;
/**
        } else if (browserType.equals("HTML") && html == null) {
            driver = new HtmlUnitDriver(true);
            html = driver;
        } else if (browserType.equals("HTML") && html != null) {
            driver = html;
**/
        } else if (browserType.equals("Chrome") && chrome == null) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Chrome\\chromedriver.exe");
            System.out.println(System.getProperty("user.dir"));
            driver = new ChromeDriver();
            chrome = driver;
        } else if (browserType.equals("Chrome") && chrome != null) {
            driver = chrome;
        } else if (browserType.equals("IE") && ie == null) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\IE\\IEDriverServer.exe");
            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
            ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            driver = new InternetExplorerDriver(ieCapabilities);
            ie = driver;
        } else if (browserType.equals("IE") && ie != null) {
            driver = ie;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //	Navigates to the login url
    public void navigate(String url) {
        log("opening URL" + "-----" + Config.getProperty(url));
        driver.get(Config.getProperty(url));
    }


    public void Homepage() {
        if (isLoggedin())
            click("logoff");
        else
            navigate("loginUrl");
    }


    //clicks an element
    public void click(String objectName) {
        log("clicking on" + "-----" + objectName);
        driver.findElement(By.cssSelector(OR.getProperty(objectName))).click();

    }

    //	input to the field
    public void input(String objectName, String text)

    {
        log("entering" + "-----" + text + "---in---" + "-----" + objectName + "field");

        driver.findElement(By.cssSelector(OR.getProperty(objectName))).clear();
        driver.findElement(By.cssSelector(OR.getProperty(objectName))).sendKeys(text);
    }

    //	selects a particular element from the dropdown
    public void select(String objectName, String text) {
        log("selecting an " + objectName + "with" + text);
        driver.findElement(By.cssSelector(OR.getProperty(objectName))).sendKeys(text);
    }

    //	Asserts if an element is present
    public boolean isElementpresent(String objectName) {
        log("verifying if" + "-----" + objectName + "-----" + " is present");
        int count = driver.findElements(By.cssSelector(OR.getProperty(objectName))).size();
        if (count == 0)

            return false;
        else

            return true;

    }

    //	number of elements present
    public int findElementsCount(String objectName) {


        int count = driver.findElements(By.cssSelector(OR.getProperty(objectName))).size();

        return count;

    }

    //	Confirms that an element is displayed

    public boolean isElementDisplayed(String objectName) throws InterruptedException {

        try {

            Assert.assertTrue(driver.findElement(By.cssSelector(OR.getProperty(objectName))).isDisplayed());
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    //	Confirms that an element is not displayed
    public boolean isElementNotDisplayed(String objectName) {

        Assert.assertFalse(driver.findElement(By.cssSelector(OR.getProperty(objectName))).isDisplayed());
        return false;

    }


    public boolean Element_is_Not_Displayed(String objectName) {
        try {
            Assert.assertFalse(driver.findElement(By.cssSelector(OR.getProperty(objectName))).isDisplayed());
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    //	verifys a user is logged in
    public boolean isLoggedin() {
        log("Verifying if user is already logged in?");

        if (isElementpresent("topmenu"))
            return true;
        else
            return false;
    }

    //	Confirms a condition is true
    public boolean assertTrue(String message, boolean condition) {

        try {
            Assert.assertTrue(message, condition);
            return true;
        } catch (NoSuchElementException ex) {

        }
        return false;
    }

    //	gets the text of an object
    public String getText(String objectName) {

        return driver.findElement(By.cssSelector(OR.getProperty(objectName))).getText();

    }

    //**************singleton*****************************************************************************************************************************
    public static WebConnector getInstance() {
        if (w == null)
            w = new WebConnector();
        return w;

    }

    //	***********Logging******************************
    public void log(String msg) {
        APPLICATION_LOGS.debug(msg);
    }

    public void log(Object println) {
        APPLICATION_LOGS.debug(println);

    }

    public void logTime(Object timetaken) {

        APPLICATION_LOGS.debug(timetaken);
    }


//*******************************************************************************************************************************************************************************
public void findElementbyClassName(String classname){
    driver.findElement(By.className(classname));

}
public void findElementbycssSelector(String objectName) {

driver.findElement(By.cssSelector(OR.getProperty(objectName)));

}
    public class CsvObject
    {
        public String XmlLink;
        public String WebLink;
    }

public ArrayList<CsvObject> readCsv(){
    String csvFile = "C:\\Users\\ajay\\Desktop\\microsoft.csv";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";

    ArrayList<CsvObject> csvObjects = new ArrayList<CsvObject>();
    try {

        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {

            // use comma as separator
            String[] links = line.split(cvsSplitBy);
            String xmlLink = links[0];
            String webLink = links[2];
            System.out.println(xmlLink + " - " + webLink);
            CsvObject csvObject = new CsvObject();
            csvObject.XmlLink = xmlLink;
            csvObject.WebLink = webLink;

            csvObjects.add(csvObject);
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    return csvObjects;
}




    public  void readXml(String xmlPath) {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document dDoc = builder.parse(getXml());

            XPath xPath = XPathFactory.newInstance().newXPath();
            Node node = (Node) xPath.evaluate("/specification/@group_title", dDoc, XPathConstants.NODE);
            System.out.println(node.getNodeValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getXml(){

    ArrayList<CsvObject> csvObjects=readCsv();
    for(CsvObject csvObject : csvObjects) {

        String xmLink = csvObject.XmlLink;

//        readXml(xmLink);
    }
    }
}




