package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static Utils.WebConnector.getCurrentDriver;

@SuppressWarnings("ALL")
public class BasePage {


    public void goToUrl(String url) throws InterruptedException {

        getCurrentDriver().get(url);
        Thread.sleep(2000);
    }

    public void navigateToUrl(String url) {

        getCurrentDriver().navigate().to(url);
//        getCurrentDriver().manage().window().maximize();
    }

    public WebElement findElement(By locator) {

        return getCurrentDriver().findElement(locator);
    }

    public List<WebElement> findElements(By locator) {

        return getCurrentDriver().findElements(locator);
    }

    public void click(By locator) {
        waitForElement(locator);
        findElement(locator).click();

    }

    public void cleanFolder() {
        File file = new File("C:\\CaptureNetworkTraffic");
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }
    }

    public void clearCache() {
        getCurrentDriver().manage().deleteAllCookies();
    }


    public void clearCookies() {
        getCurrentDriver().manage().deleteAllCookies();
        getCurrentDriver().navigate().refresh();
    }

    public void playJwPlayer(long stopTime) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getCurrentDriver();
        js.executeScript("jwplayer().play();");
        Thread.sleep(stopTime);
        js.executeScript("jwplayer().stop();");

    }

    public void writetoField(By locator, String text) {
//
//        findElement(locator).clear();
        findElement(locator).sendKeys(text);
    }

    public void clearField(By locator) {
        findElement(locator).clear();
    }

    public boolean isElementPresent(By locator) {

        if (findElements(locator).size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isElementDisplayed(By locator) {
        if (findElement(locator).isDisplayed()) {
            return true;
        } else
            return false;

    }

    public static void sleep(int secs) throws InterruptedException {
        Thread.sleep(secs);
    }

    public void verifyTextofaField(By locator, String text) {
        waitForElement(locator);
        System.out.println(findElement(locator).getText());
//        Assert.assertTrue(findElement(locator).getText().equalsIgnoreCase(text));
        Assert.assertEquals(text, findElement(locator).getText());

    }

    public void verifyFieldContainsText(By locator, String text) {
        waitForElement(locator);
        System.out.println(findElement(locator).getText());
        Assert.assertTrue(findElement(locator).getText().contains(text));


    }

    public void confirmFieldsStartswith(By locator, By locator1, String text) throws InterruptedException {
        Thread.sleep(5000);
        WebElement Searchlist = findElement(locator);
        List<WebElement> options = Searchlist.findElements(locator1);
        System.out.println(options.size());
        if (options.size() != 0) {
            for (WebElement option : options) {
                System.out.println(option.getText());
                Assert.assertTrue(" name doesnt start with " + option.getText(), option.getText().toLowerCase().startsWith(text));
            }
        } else {
            Assert.fail("Zero results returned");
        }

    }


    public String isSelected(By locator) {

        WebElement element = findElement(locator);
        Select mySelect = new Select(element);
        String selectedElement = mySelect.getFirstSelectedOption().getText();
        return selectedElement;
//		Assert.assertTrue(selectedElement.equalsIgnoreCase(text));


    }


    public void moveToElementandClick(WebElement element) {

//        WebElement element = findElement(locator);

        Actions actions = new Actions(getCurrentDriver());
        actions.moveToElement(element).click().perform();
    }


    public String getPageTitle() {

        return getCurrentDriver().getTitle();
    }

    public String getCurrentUrl() {
        return getCurrentDriver().getCurrentUrl();
    }

    public void switchToIframe() {
        getCurrentDriver().switchTo().frame(0);
    }

    public void switchToDefaultPage() {
        getCurrentDriver().switchTo().defaultContent();
    }


    public void select(By locator, String text) throws InterruptedException {
        WebElement dropdown = findElement(locator);
        Select element = new Select(dropdown);
        Thread.sleep(3000);
        element.selectByVisibleText(text);
    }

    public void waitForElement(By locator) {

        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), 30);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElement(WebElement locator) {

        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickCheckboxifNotSelected(By locator, String attributeName, String language) {

        List<WebElement> checkBoxes = findElements(locator);
        for (WebElement checkBox : checkBoxes) {
            String checkBoxAttribute = checkBox.getAttribute(attributeName);
            if (checkBoxAttribute.equalsIgnoreCase(language)) {
                checkBox.click();
            }
        }
    }

    public void uncheckCheckboxifSelected(By locator) {

        WebElement checkBox = findElement(locator);
        if (checkBox.isSelected()) {
            checkBox.click();
        }
    }


    //    Navigate to Landing Page if not on landing page
//    public void goToLandingPage() {
//
//        navigateToUrl(landingPageUrl);
//
//    }


    public void readUnreadEmails() {
        List<WebElement> unreadEmails = getCurrentDriver().findElements(By.cssSelector(".zF"));

        String MyMailer = "tech";

        for (WebElement mail : unreadEmails) {
            if (mail.isDisplayed() && mail.getText().equalsIgnoreCase(MyMailer)) {
                mail.click();
            }
        }
    }

    public void switchTabsinBrowser() throws InterruptedException {
        String oldTab = getCurrentDriver().getWindowHandle();
        ArrayList<String> newTab = new ArrayList<String>(getCurrentDriver().getWindowHandles());
//        newTab.remove(oldTab);
//        getCurrentDriver().switchTo().window(oldTab).close();
        Thread.sleep(5000);
        // change focus to new tab
        getCurrentDriver().switchTo().window(newTab.get(1));


    }

    public void dragAndDrop(By locator, By locator1) {

        WebElement from = findElement(locator);
        WebElement to = findElement(locator1);
        (new Actions(getCurrentDriver()).dragAndDrop(from, to)).perform();
    }

    public void jsErrors() {

    }

    public void closeBrowser() {
        getCurrentDriver().close();
    }

}



