


//import org.openqa.selenium.remote.DesiredCapabilities;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
            driver = new FirefoxDriver();
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
//						DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
//						ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            driver = new InternetExplorerDriver();
            ie = driver;
        } else if (browserType.equals("IE") && ie != null) {
            driver = ie;
        }
//		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    //	Navigates to the login url
    public void navigate(String url) {

        log("opening URL" + "-----" + Config.getProperty(url));
        driver.get(Config.getProperty(url));
        driver.manage().window().maximize();
    }


    public void Homepage() {
        if (isLoggedin()) {
            waittillElementPresent("logoff");
            click("logoff");
        } else
            navigate("loginrl");
    }


    //clicks an element
    public void click(String objectName) {
        log("clicking on" + "-----" + objectName);
        waittillelementstoBeClickable(objectName);
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
        return count != 0;

    }

    public boolean areElementsPresent(String objectName) {
        WebElement searchList = driver.findElement(By.xpath(OR.getProperty("searchList")));
        List<WebElement> count = searchList.findElements(By.xpath(OR.getProperty(objectName)));
        System.out.println(count.size());
        for (int i = 0; i < count.size(); i++)
            if (count.get(i).getText() != null) {
                return true;
            }
        return false;
    }

    //	number of elements present
    public int findElementsCount(String objectName) {


        int count = driver.findElements(By.xpath(OR.getProperty(objectName))).size();

        return count;

    }

    //	Confirms that an element is displayed

    public boolean isElementDisplayed(String objectName) {

        try {

            Assert.assertTrue(driver.findElement(By.xpath(OR.getProperty(objectName))).isDisplayed());
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    //	Confirms that an element is not displayed
    public void isElementNotDisplayed(String objectName) {

        Assert.assertFalse(driver.findElement(By.xpath(OR.getProperty(objectName))).isDisplayed());


    }


    public boolean element_is_Not_Displayed(String objectName) {
        try {
            Assert.assertFalse(driver.findElement(By.xpath(OR.getProperty(objectName))).isDisplayed());
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    //	verifys a user is logged in

    /**
     * public boolean isLoggedin() {
     * log("Verifying if user is already logged in?");
     * <p>
     * return isElementpresent("AdminArea");
     * }
     **/
    public boolean isLoggedin() {
        log("Verifying if user is already logged in?");

        if (isElementpresent("AdminArea"))
            return true;
        else
            return false;
    }

    //	Confirms a condition is true
    public boolean assertTrue(String message, boolean condition) {

        //noinspection EmptyCatchBlock
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
        waittillElementPresent("email");
        input("email", Config.getProperty("defUsername"));
        waittillElementPresent("password");
        input("password", Config.getProperty("defPassword"));
        click("signinButton");
    }


    public void doTestLogin() {
        log("logging in the user with" + "-----" + Config.getProperty("defUsername") + "and" + "-----" + Config.getProperty("defPassword"));
        navigate("loginUrl");
        waittillElementPresent("email");
        input("email", Config.getProperty("TestUsername"));
        waittillElementPresent("password");
        input("password", Config.getProperty("TestPassword"));
        click("signinButton");
        Assert.assertFalse("Admin area is present", isElementpresent("AdminArea"));
    }

    public void embargoLogin() {
        log("logging in the user with" + "-----" + Config.getProperty("embUsername") + "and" + "-----" + Config.getProperty("embPassword"));
        navigate("loginUrl");
        waittillElementPresent("email");
        input("email", Config.getProperty("embUsername"));
        waittillElementPresent("password");
        input("password", Config.getProperty("embPassword"));
        click("signinButton");
        waittilltextPresent("currentLoggedInUser", "Test User Phase 2");

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
        WebDriverWait wait = new WebDriverWait(driver, 45);
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(OR.getProperty(objectName))));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(OR.getProperty(objectName))));
    }

    public void WaittillElementIsInvisible() {
        WebDriverWait wait = new WebDriverWait(driver, 500);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='fancybox-content']")));
    }

    //	Waits for 30 secs for a text to appear in an object by xpath
    public void waittilltextPresent(String objectName, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 45);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(OR.getProperty(objectName)), text));
    }

    public void waittillelementstoBeClickable(String objectName) {
        WebDriverWait wait = new WebDriverWait(driver, 45);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(objectName))));
    }

    public void waittillElementPresent(String objectName) {
        WebDriverWait wait = new WebDriverWait(driver, 45);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(OR.getProperty(objectName))));
    }

    public void waittillElementtoBeSelectable(String objectName) {
        WebDriverWait wait = new WebDriverWait(driver, 45);
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath(OR.getProperty(objectName))));
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
        //noinspection ForLoopReplaceableByForEach
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

    public void checkAllCheckboxes() {

        List<WebElement> lc = driver.findElements(By.xpath("//input[@ type='checkbox']"));

        for (WebElement l : lc) {
            boolean isnotChecked = !l.isSelected();
            if (isnotChecked) {
                l.click();
            }
        }

    }

    public void clickaLink(String linktext) {

        driver.findElement(By.linkText(linktext));
    }

    //	clicks on a weblink
    public void clickLinktext()

    {
        driver.findElement(By.linkText("Search Results")).click();
    }

    //Clicks the first element in the list
    public void clickOnefromList(String objectName) throws InterruptedException {

        WebElement droplist = driver.findElement(By.xpath(OR.getProperty(objectName)));
        List<WebElement> options = droplist.findElements(By.tagName("a"));
        System.out.println(options.size());

        options.get(0).click();
    }

    public String isSelected(String objectname) {

        WebElement element = driver.findElement(By.xpath(OR.getProperty(objectname)));
        Select mySelect = new Select(element);
        String selectedElement = mySelect.getFirstSelectedOption().getText();
        return selectedElement;
//		Assert.assertTrue(selectedElement.equalsIgnoreCase(text));


    }

    //	Get the current URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


    //	verify videos icons present after filtering search results
    public void verifyVideoProductsPresent(String objectName) throws InterruptedException {
//		Thread.sleep(4000);

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
        WebElement Searchlist = driver.findElement(By.xpath(OR.getProperty(objName)));
        List<WebElement> options = Searchlist.findElements(By.xpath(OR.getProperty(objectName)));
        System.out.println(options.size());
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
            String actualName = options.get(i).getText();
            Assert.assertTrue(brandName.equalsIgnoreCase(actualName));


        }
    }

    public void verifyFieldsDoNotContainsText(String objName, String objectName, String brandName) throws InterruptedException {
//		Thread.sleep(5000);

        WebElement Searchlist = driver.findElement(By.xpath(OR.getProperty(objName)));
        List<WebElement> options = Searchlist.findElements(By.xpath(OR.getProperty(objectName)));
        System.out.println(options.size());
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
            String actualName = options.get(i).getText();
            Assert.assertFalse(brandName.equalsIgnoreCase(actualName));


        }
    }

    public void FieldsContainPartOftheText(String objName, String objectName, String text) throws InterruptedException {

//		Thread.sleep(5000);

        WebElement Searchlist = driver.findElement(By.xpath(OR.getProperty(objName)));
        List<WebElement> options = Searchlist.findElements(By.xpath(OR.getProperty(objectName)));
        System.out.println(options.size());
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
            Assert.assertTrue("Text is not present", options.get(i).getText().contains(text));


        }

    }

    public void startswithtext(String objName, String objectName, String text) throws InterruptedException {


//		Thread.sleep(5000);

        WebElement Searchlist = driver.findElement(By.xpath(OR.getProperty(objName)));
        List<WebElement> options = Searchlist.findElements(By.xpath(OR.getProperty(objectName)));
        System.out.println(options.size());
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
            Assert.assertTrue("Text is not present", options.get(i).getText().startsWith(text));


        }
    }


    public void verify_Searchresults_Link_navigation() {
        clickLinktext();
        System.out.println(driver.getCurrentUrl());
        String expUrl = "https://manage.flix360.com/search/result/";
        Assert.assertEquals(driver.getCurrentUrl(), expUrl);
    }


    //choose a mpn from a auto suggest list
    public void ChooseFromList(String objectName, String tagname, String text) throws InterruptedException


    {
//		Thread.sleep(3000);
//		waittillElementPresent(objectName);
        WebElement mpnList = driver.findElement(By.xpath(OR.getProperty(objectName)));
        Thread.sleep(3000);
        List<WebElement> lc = mpnList.findElements(By.tagName(tagname));
        System.out.println(lc.size());
        for (int i = 0; i < lc.size(); i++) {
            Thread.sleep(3000);
            String value = lc.get(i).getText();
            System.out.println(value);
            if (value.contains(text)) {
                lc.get(i).click();
                Thread.sleep(5000);
            }


        }

    }


    //	verifys the title of the added product matches the name entered
    public void Verify(String objectName, String text) throws InterruptedException {
//		Thread.sleep(3000);

        WebElement title = driver.findElement(By.xpath(OR.getProperty(objectName)));
        System.out.println(title.getText());
        Assert.assertEquals(text, title.getText());
    }

    //	asserts that an element contains part of the text
    public void assertElementhasText(String objectName, String text) {

        System.out.println(driver.findElement(By.xpath(OR.getProperty(objectName))).getText());
        Assert.assertTrue(driver.findElement(By.xpath(OR.getProperty(objectName))).getText().contains(text));
    }

    //	Switch to an Iframe
    public void switch_to_popup() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame(0);

    }

    //	Return to default from Iframe
    public void switch_to_default() {
        driver.switchTo().defaultContent();
    }

    //	Navigates to the product page
    public void verifyifonProduct_Page() {

        String expurl = "http://dev-manage.flix360.com/samsung/product/info/id/340385/lang_id/4";
        String actUrl = driver.getCurrentUrl();
        System.out.println(actUrl);
        if (expurl != actUrl)
            driver.navigate().to(expurl);

    }

    //	Navigate sto xnl created product pageML2525 if not on the page already
    public void xml_created_product() {
        String curUrl = driver.getCurrentUrl();
        String expurl = "http://dev-manage.flix360.com/samsung/product/info/id/340386/lang_id/4";
        if (curUrl != expurl)
            driver.navigate().to(expurl);
    }


    //	Navigates to landing page
    public void LandingPage() throws InterruptedException {
//		if(!isElementpresent("AdminArea"))
        click("ManageContent");
        Thread.sleep(5000);
//		driver.navigate().to("http://dev-manage.flix360.com/samsung/search");

    }

    //	Deletes assets if an Asset carousel is presnt
    public void delete_Asset_ifpresent() throws InterruptedException {

        while (isElementpresent("AssetCarousel")) {
            WebElement mpnList = driver.findElement(By.xpath(OR.getProperty("AssetCarousel")));
            List<WebElement> lc = mpnList.findElements(By.tagName("img"));
            int assetcount = lc.size();
            System.out.print(assetcount);
            if (assetcount != 0) {
                lc.get(0).click();
                deleteAsset();
            }
        }
    }

    public void assetCarouselSize(int size) {

        WebElement mpnList = driver.findElement(By.xpath(OR.getProperty("AssetCarousel")));
        List<WebElement> lc = mpnList.findElements(By.tagName("img"));
        int assetcount = lc.size();
        System.out.println(assetcount);
        Assert.assertTrue(assetcount == size);

    }

    public void notEmpty(String objectName) {
        driver.findElement(By.xpath(OR.getProperty(objectName))).getSize();

    }
//Drag and drop used in category priority

    public void DragandDrop(String cat1, String cat2) {
        WebElement element = driver.findElement(By.xpath(OR.getProperty(cat1)));
        WebElement target = driver.findElement(By.xpath(OR.getProperty(cat2)));
        (new Actions(driver)).dragAndDrop(element, target).perform();
    }
//	Gets the text of the first category after prioritising

    public void FirstElementText(String objName, String objectName, String text) throws InterruptedException {
//		Thread.sleep(5000);

        WebElement CategoryList = driver.findElement(By.xpath(OR.getProperty(objName)));
        List<WebElement> Categories = CategoryList.findElements(By.xpath(OR.getProperty(objectName)));
        System.out.println(Categories.size());
        System.out.println(Categories.get(0).getText());
        Assert.assertTrue("Text is not present", Categories.get(0).getText().equalsIgnoreCase(text));

    }
//Asserts the numbers of rows in specification upload table are same as expected

    public void Assert_number_of_Rows_ina_Table(String objName) {
        WebElement SpecificationUploaded = driver.findElement(By.xpath(OR.getProperty(objName)));
        List<WebElement> Rows = SpecificationUploaded.findElements(By.tagName("tr"));
        int count = Rows.size();
        System.out.println(count);
        int expRows = 38;
        Assert.assertTrue(count == expRows);
    }

//	Verifys if a delete button is not present under assets if any assets are present

    public void Assert_deleteButton_not_present_forAllAssets() throws InterruptedException {
        if (isElementpresent("AssetCarousel")) {
            WebElement Assets = driver.findElement(By.xpath(OR.getProperty("AssetCarousel")));
            List<WebElement> lc = Assets.findElements(By.tagName("img"));
            int assetcount = lc.size();
            if (assetcount != 0) {
                for (int i = 0; i < assetcount; i++)
                    lc.get(i).click();
                Assert.assertFalse(isElementpresent("deleteButton"));
                Thread.sleep(3000);
            }


        }
    }

    //	Delete a manuall uploaded asset of an xml product
    public void delete_manual_Asset() throws InterruptedException {


        if (isElementpresent("AssetCarousel")) {
//			Thread.sleep(5000);
            WebElement Assetlist = driver.findElement(By.xpath(OR.getProperty("AssetCarousel")));
            List<WebElement> lc = Assetlist.findElements(By.tagName("img"));
            int assetcount = lc.size();
            System.out.println(assetcount);
            if (assetcount != 0) {
                for (int i = 0; i < assetcount; i++)
                    lc.get(1).click();
                deleteAsset();
            }
//				Assert.assertFalse(driver.findElements(By.xpath("Assetname")).contains(assetname));

        }
    }


    //	Adds an asset
    public void addAsset(String AssetLink, String Assetname, String filetoUpload) throws InterruptedException {
        click(AssetLink);
        click("AddButton");
        switch_to_popup();
        input("Name", Assetname);
        input("File", filetoUpload);
        click("save&update");
        switch_to_default();
        Thread.sleep(3000);

    }

    //	deletes asset
    public void deleteAsset() throws InterruptedException {
        click("deleteButton");
        switch_to_popup();
        click("DELETE");
        switch_to_default();
    }

    //Adds description to batch upload assets in pink one by one
    public void updateassetsinPink() throws InterruptedException {
        Thread.sleep(3000);
        click("Test1");
        click("BUAddLanguageButton");
        select("BULanguageField", "English");
        input("BulangTitle", "Testimage");
        click("AddLanguageonpopup");
        switch_to_default();
        Thread.sleep(3000);
        isElementDisplayed("BUDescription");
        input("BUDescription", "This is a test image upload");

        click("Wildlife");
        click("AddLanguageButton2");
        select("BULanguageField", "English");
        input("BulangTitle", "TestVideo");
        click("AddLanguageonpopup");
        switch_to_default();
        Thread.sleep(3000);
        List<WebElement> desc = driver.findElements(By.tagName("textarea"));
        System.out.println(desc.size());
        desc.get(1).sendKeys("TESTVideo");
        //		driver.findElement(By.xpath(OR.getProperty("Description2"))).sendKeys("This is a test video upload");
        //		input("BUDescription","This is a test video upload");
    }

    public void DeleteAsset() throws InterruptedException {
        click("deleteButton");
        switch_to_popup();
        click("DELETE");
        switch_to_default();
    }

    public void uploadVideo(String file) throws InterruptedException {
        click("Videos");
        delete_Asset_ifpresent();
        click("AddButton");
        switch_to_popup();
        input("Title", "TestTitle");
        input("File", file);
        input("V-Code", "Videos");
        select("Type", "Other");
        click("Save&Update");
        switch_to_default();
    }

//	list find elements by xpath

    public void elementList(String xpath, String xpath1, String lang) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(OR.getProperty(xpath)));

        Thread.sleep(5000);

        List<WebElement> element1 = element.findElements(By.xpath(xpath1));

        System.out.println(element1.size());

        for (int i = 0; i < element1.size(); i++)
//		for(WebElement products:element1) {
        {
            String language = element1.get(i).getAttribute("original-title");
            System.out.println(language);
            if (language.contains(lang)) {
                element1.get(i).click();
            }

        }


    }

    public void FindElement(String objectName) {
        driver.findElement(By.xpath(OR.getProperty(objectName)));


    }

    public void FindElements(String objectName) {
        List<WebElement> element = driver.findElements(By.xpath(OR.getProperty(objectName)));
    }

    public void Promotionslist(String objectName, String objectName1, String text) throws InterruptedException {
        WebElement Searchlist = driver.findElement(By.xpath(OR.getProperty(objectName)));
        List<WebElement> Promotions = Searchlist.findElements(By.xpath(OR.getProperty(objectName1)));
        System.out.println(Promotions.size());
        Promotions.get(0).click();
        assertElementhasText("Assetname", text);
        deleteAsset();
        Thread.sleep(3000);
        WebElement Searchlist1 = driver.findElement(By.xpath(OR.getProperty(objectName)));
        List<WebElement> Promotions1 = Searchlist1.findElements(By.xpath(OR.getProperty(objectName1)));
        Promotions1.get(0).click();
        assertElementhasText("Assetname", text);
        deleteAsset();

    }

    public void editAsset(String text) throws InterruptedException {
        click("EditButton");
        switch_to_popup();
        input("Title", text);
        click("save&update");
        switch_to_default();


    }

    //	Mouse hover
    public void MouseHover(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

    }

    public void verifyCategory_Restriction() throws InterruptedException {

        Actions action = new Actions(driver);

//		waittillElementPresent("Categories");

        WebElement categories = driver.findElement(By.linkText("Categories"));

        action.moveToElement(categories).perform();

        click("CategoriesDutch");

        Wait();

//		waittillElementPresent("SubCat");

        WebElement Subcat = driver.findElement(By.xpath(OR.getProperty("SubCat")));

        Actions action1 = new Actions(driver);
        action1.moveToElement(Subcat).perform();
        List<WebElement> subcategories = Subcat.findElements(By.tagName("strong"));

        System.out.println("Subcategories are" + "" + subcategories.size());

        Assert.assertTrue("Mobiel is not restricted", subcategories.size() == 6);

    }

    public void verifyProduct_Restriction() throws InterruptedException {
        navigate("Testproduct");

        assertElementhasText("NoProduct", "----- NO Product ----");

    }

    public void AssignUsertoGroup(String Group) throws InterruptedException {

        select("SearchBy", "Lastname");

        input("SSearchField", "Selenium");

        Wait();

        click("Userseditbutton");

        switch_to_popup();

        select("Groups", "abc");

        click("save&update");

        switch_to_default();

        waittillElementPresent("EditAlertStatus");
    }

    public void RemoveUserfromGroup() throws InterruptedException {


        select("SearchBy", "Lastname");

        input("SSearchField", "Selenium");

//		Wait();
        waittillelementstoBeClickable("Userseditbutton");

        click("Userseditbutton");

        switch_to_popup();

        select("Groups", "None");

        click("save&update");

        switch_to_default();

        waittillElementPresent("EditAlertStatus");
    }

    public void delete_Promotion_ifpresent(String product) throws InterruptedException {
        navigate(product);

        click("PromotionsLink");

        while (isElementpresent("ListofPromos")) {
            WebElement mpnList = driver.findElement(By.xpath(OR.getProperty("ListofPromos")));
            List<WebElement> lc = mpnList.findElements(By.xpath(OR.getProperty("PromotionsNamelist")));
            int promocount = lc.size();
            System.out.print(promocount);
            if (promocount != 0) {
                lc.get(0).click();
                deleteAsset();
            }

            /**    for (int i=0;i<assetcount;i++){
             //					lc.get(i).click();
             for(WebElement assets:lc) {
             assets.click();
             Thread.sleep(3000);
             click("deleteButton");
             switch_to_popup();
             click("DELETE");
             switch_to_default();
             Thread.sleep(3000);
             }**/
        }
    }


    //wait
    public void Wait() throws InterruptedException {
        Thread.sleep(5000);
    }


    //	close the driver.
    public void close()


    {
        driver.close();
    }

    public void print(String text)

    {
        System.out.print(text);
    }

    public void printsize(int size)

    {
        System.out.print(size);
    }


}





