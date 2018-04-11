import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


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

    public WebConnector() {
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

    public void openBrowser(String browserType) {
        log("opening browser" + "-----" + browserType);
        if (browserType.equals("Mozilla") && mozilla == null) {
            ProfilesIni profile = new ProfilesIni();

            FirefoxProfile myprofile = profile.getProfile("Local");

            driver = new FirefoxDriver(myprofile);
            /**        driver= new FirefoxDriver();
             DesiredCapabilities capabilities = DesiredCapabilities.firefox();
             capabilities.setCapability("marionette", true);

             driver = new FirefoxDriver(capabilities);**/
            mozilla = driver;
        } else if (browserType.equals("Mozilla") && mozilla != null) {
            driver = mozilla;

        } else if (browserType.equals("HTML") && html == null) {
            driver = new HtmlUnitDriver(true);
            html = driver;
        } else if (browserType.equals("HTML") && html != null) {
            driver = html;

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
        driver.findElement(By.xpath(OR.getProperty(objectName))).click();

    }

    //	input to the field
    public void input(String objectName, String text)

    {
        log("entering" + "-----" + text + "---in---" + "-----" + objectName + "field");

        driver.findElement(By.xpath(OR.getProperty(objectName))).clear();
        driver.findElement(By.xpath(OR.getProperty(objectName))).sendKeys(text);
    }

    //	selects a particular element from the dropdown
    public void select(String objectName, String text) {
        log("selecting an " + objectName + "with" + text);
        driver.findElement(By.xpath(OR.getProperty(objectName))).sendKeys(text);
    }

    //	Asserts if an element is present
    public boolean isElementpresent(String objectName) {
        log("verifying if" + "-----" + objectName + "-----" + " is present");
        int count = driver.findElements(By.xpath(OR.getProperty(objectName))).size();
        if (count == 0)

            return false;
        else

            return true;

    }

    //	number of elements present
    public int findElementsCount(String objectName) {


        int count = driver.findElements(By.xpath(OR.getProperty(objectName))).size();

        return count;

    }

    //	Confirms that an element is displayed

    public boolean isElementDisplayed(String objectName) throws InterruptedException {

        try {

            Assert.assertTrue(driver.findElement(By.xpath(OR.getProperty(objectName))).isDisplayed());
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    //	Confirms that an element is not displayed
    public boolean isElementNotDisplayed(String objectName) {

        Assert.assertFalse(driver.findElement(By.xpath(OR.getProperty(objectName))).isDisplayed());
        return false;

    }


    public boolean Element_is_Not_Displayed(String objectName) {
        try {
            Assert.assertFalse(driver.findElement(By.xpath(OR.getProperty(objectName))).isDisplayed());
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

    //does login with default credentials
    public void doDefLogin() {
        log("logging in the user with" + "-----" + Config.getProperty("defUsername") + "and" + "-----" + Config.getProperty("defPassword"));
        navigate("loginUrl");
        input("email", Config.getProperty("defUsername"));
        input("password", Config.getProperty("defPassword"));
        click("signinButton");
    }


    //	selects an element from the dropdown
    public void dropList(String objectName, String text) {

        WebElement droplist = driver.findElement(By.xpath(OR.getProperty(objectName)));
        droplist.sendKeys(text);
    }

    //	getting a list of dropdown elements
    public void listofDropdown(String objectName) {
        WebElement droplist = driver.findElement(By.xpath(OR.getProperty(objectName)));
        List<WebElement> options = droplist.findElements(By.tagName("a"));
        System.out.println(options.size());
        for (int i = 0; i <= options.size(); i++) {
            System.out.println(options.get(i).getText());

        }
    }

    //ExplicitWait-------waits for the element to be available
    public void expWait(String objectName) {
        driver.findElement(By.xpath(objectName));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(OR.getProperty(objectName))));
    }

    public void expWaitVisible(String objectName) {
        driver.findElement(By.xpath(objectName));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(OR.getProperty(objectName))));
    }

    //	Waits for 120 secs for a text to appear in an object by xpath
    public void waittilltextPresent(String objectName, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(OR.getProperty(objectName)), text));
    }

    //	gets the text of an object
    public String getText(String objectName) {

        return driver.findElement(By.xpath(OR.getProperty(objectName))).getText();

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
        // TODO Auto-generated method stub
        APPLICATION_LOGS.debug(timetaken);
    }

    //******************************************************************************************************************************************************

    //	Starts stop watch
    public void StartStopWatch()

    {

        startTime = System.currentTimeMillis();
    }

    //	Stops stopwatch
    public void StopStopWatch()

    {

        stopTime = System.currentTimeMillis();
    }

    //	Returns the time taken for an execution
    public long CheckElapsedStopWatchTime() {

        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
        return elapsedTime;
    }


    public void choose_category(String objectName1, String objectName2, String objectName3) throws InterruptedException {
        //		click("c1Unselectall");
        click(objectName1);
        //		Thread.sleep(3000);
        //		click("c2Unselectall");
        click(objectName2);
        Thread.sleep(3000);
        //		click("c3Unselectall");
        click(objectName3);
        Thread.sleep(3000);
        click("c5Unselectall");


    }

    //	Click checkbox by name
    public void ClickChecboxByName(String checkBoxValue) {
        List<WebElement> lc = driver.findElements(By.xpath(OR.getProperty("checkBox")));
        for (int i = 0; i < lc.size(); i++) {
            String value = lc.get(i).getAttribute("value");

            if (value == checkBoxValue) {
                lc.get(i).click();
            }
        }
    }

    //clicks an checkbox if not selected already
    public void clickCheckboxifNotSelected(String objectName) {
        log("clicking on" + "-----" + objectName);
        WebElement checkBox = driver.findElement(By.xpath(OR.getProperty(objectName)));
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
    }

    //	Unchecks checkbox if already selected
    public void UncheckCheckboxifSelected(String objectName) {
        log("clicking on" + "-----" + objectName);
        WebElement checkBox = driver.findElement(By.xpath(OR.getProperty(objectName)));
        if (checkBox.isSelected()) {
            checkBox.click();
        }
    }


    //	No of elements with a value
    public void checkboxSixe(String objectname) {
        List<WebElement> lc = driver.findElements(By.xpath(OR.getProperty(objectname)));
        for (int i = 0; i <= lc.size(); i++) {
            System.out.println(lc.get(i).getAttribute("value"));
        }

    }

    //	Unchecks all checkboxes if selected
    public void UncheckAllCheckBoxes() {

        List<WebElement> lc = driver.findElements(By.xpath("//input[@ type='checkbox']"));

        for (WebElement l : lc) {
            boolean isChecked = l.isSelected();
            if (isChecked) {
                l.click();
            }
        }
    }

    //	clicks on a weblink
    public void clickLinktext(String text)

    {
        driver.findElement(By.linkText(text)).click();
    }

    //Clicks the first element in the list
    public void clickOnefromList(String objectName) throws InterruptedException {
        Thread.sleep(4000);
        WebElement droplist = driver.findElement(By.xpath(OR.getProperty(objectName)));
        List<WebElement> options = droplist.findElements(By.tagName("a"));
        System.out.println(options.size());

        options.get(0).click();
    }

    //	Get the current URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


    //	verify videos icons present after filtering search results
    public void verifyVideoProductsPresent(String objectName) throws InterruptedException {
        Thread.sleep(4000);
        WebElement searchlist = driver.findElement(By.xpath(OR.getProperty(objectName)));
        List<WebElement> options = searchlist.findElements(By.xpath("//td[@aria-describedby='list47_assets']"));
        System.out.println(options.size());
        for (int i = 0; i < options.size(); i++) {

            Dimension size = options.get(i).getSize();
            System.out.println(size);
//			WebElement Videoicons=driver.findElement(By.xpath(OR.getProperty("VideoProducts")));

//			options.get(i).findElement(By.xpath(OR.getProperty("VideoProducts"))).


        }

    }

    //	Search by brand in natural search and verify the search results are for the searched brand
    public void verifyFieldsContainsText(String objName, String objectName, String brandName) throws InterruptedException {
        Thread.sleep(5000);
        WebElement Searchlist = driver.findElement(By.xpath(OR.getProperty(objName)));
        List<WebElement> options = Searchlist.findElements(By.xpath(OR.getProperty(objectName)));
        System.out.println(options.size());
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
            Assert.assertEquals(brandName, options.get(i).getText());


        }
    }

    public void FieldsContainPartOftheText(String objName, String objectName, String text) throws InterruptedException {

        Thread.sleep(5000);
        WebElement Searchlist = driver.findElement(By.xpath(OR.getProperty(objName)));
        List<WebElement> options = Searchlist.findElements(By.xpath(OR.getProperty(objectName)));
        System.out.println(options.size());
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
            Assert.assertTrue("Text is not present", options.get(i).getText().contains(text));


        }

    }


    public void verify_Searchresults_Link_navigation() {
        clickLinktext("Search Results");
        System.out.println(driver.getCurrentUrl());
        String expUrl = "https://dev-manage.flix360.com/search/result/";
        Assert.assertEquals(driver.getCurrentUrl(), expUrl);
    }


    //choose a mpn from a auto suggest list
    public void ChooseFromList(String text) throws InterruptedException {
        Thread.sleep(3000);
        WebElement mpnList = driver.findElement(By.xpath(OR.getProperty("dropDown")));
        List<WebElement> lc = mpnList.findElements(By.tagName("a"));
        for (int i = 0; i < lc.size(); i++) {
            String value = lc.get(i).getText();
            System.out.println(value);
            if (value.contains(text)) {
                lc.get(i).click();
                Thread.sleep(3000);
            }
        }
    }

    //	verifys the title of the added product matches the name entered
    public void Verify(String objectName, String text) throws InterruptedException {
        Thread.sleep(3000);
        WebElement title = driver.findElement(By.xpath(OR.getProperty(objectName)));
        System.out.println(title.getText());
        Assert.assertEquals(text, title.getText());
    }

    //	asserts that an element contains part of the text
    public void assertElementhasText(String objectName, String text) throws InterruptedException {

        waittilltextPresent(objectName, text);
        System.out.println(driver.findElement(By.xpath(OR.getProperty(objectName))).getText());
        Assert.assertTrue(driver.findElement(By.xpath(OR.getProperty(objectName))).getText().contains(text));
    }

    //	Switch to an Iframe
    public void switch_to_popup() throws InterruptedException {
        Thread.sleep(5000);
        driver.switchTo().frame(0);

    }

    //	Return to default from Iframe
    public void switch_to_default() {
        driver.switchTo().defaultContent();
    }

    //	Navigates to the product page
    public void verifyifonProduct_Page() {

        String expurl = "http://dev-manage.flix360.com/product/info/id/347969/lang_id/11";
        String actUrl = driver.getCurrentUrl();
        System.out.println(actUrl);
        if (expurl != actUrl)
            driver.navigate().to("http://dev-manage.flix360.com/product/info/id/347969/lang_id/1");

    }

    //	Navigates to landing page
    public void LandingPage() {
        if (!isElementpresent("searchfield"))
            click("ManageContent");
    }
//delete if  assets is present on a product
    public void delete_Asset_ifpresent() throws InterruptedException {
        if (isElementpresent("AssetCarousel")) {
            WebElement Assets = driver.findElement(By.xpath(OR.getProperty("AssetCarousel")));
            List<WebElement> lc = Assets.findElements(By.tagName("img"));
            int assetcount = lc.size();
            if (assetcount != 0) {
                for (int i = 0; i < assetcount; i++)
                    lc.get(i).click();
                click("deleteButton");
                switch_to_popup();
                click("DELETE");
                switch_to_default();
                Thread.sleep(3000);
            }
        }
    }

    //	close the driver.
    public void close() {
        driver.close();
    }

}





