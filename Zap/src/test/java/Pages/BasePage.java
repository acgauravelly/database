package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static Utils.WebConnector.getCurrentDriver;

@SuppressWarnings("ALL")
public class BasePage {


    private By logOff = By.cssSelector("a[href='/login/logout']");
    private By autoSuggest = By.cssSelector(".ui-autocomplete.ui-menu.ui-widget.ui-widget-content.ui-corner-all");
    private By anchorTag = By.tagName("a");
    private String landingPageUrl = "https://dev-manage.flix360.com/search";
    public String productPage = "https://dev-manage.flix360.com/product/info/id/792871/lang_id/1";
    private By searchList = By.cssSelector("#gbox_list47");
    private By saveAndUpdate = By.cssSelector(".button-blue.button-right-flush");


    public void goToUrl(String url) {

        getCurrentDriver().get(url);
    }

    public void navigateToUrl(String url) {

        getCurrentDriver().navigate().to(url);
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


    public void writetoField(By locator, String text) {
//
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

    public LoginPage logOff() {
        if (isElementPresent(logOff)) {
            click(logOff);
        }
        Assert.assertEquals("Login", getCurrentDriver().getTitle());
        return new LoginPage();
    }

    //    Verifying user is Logged in
    public boolean isLoggedIn() throws InterruptedException {

        if (isElementPresent(logOff)) {
            return true;
        } else {
            return false;
        }

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

    public void swithcToDefaultPage() {
        getCurrentDriver().switchTo().defaultContent();
    }


    public void select(By locator, String text) {
        WebElement dropdown = findElement(locator);
        Select element = new Select(dropdown);
        element.selectByValue(text);
    }

    public void waitForElement(By locator) {

        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void chooseFromAutoSuggest(String text) {
        WebElement suggest = findElement(autoSuggest);
        for (WebElement sku : suggest.findElements(anchorTag)) {
            if (sku.getText().equalsIgnoreCase(text)) {
                sku.click();
            }
        }

    }


    public void saveAndUpdate() {
        click(saveAndUpdate);
    }

    public void clickCheckboxifNotSelected(By locator) {

        WebElement checkBox = findElement(locator);
        if (!checkBox.isSelected()) {
            checkBox.click();
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


    //	Search by brand in natural search and verify the search results are for the searched brand
    public void verifyFieldsContainsText(By locator, String text) throws InterruptedException {
        Thread.sleep(5000);
        WebElement Searchlist = findElement(searchList);
        List<WebElement> options = Searchlist.findElements(locator);
        System.out.println(options.size());
        if (options.size() != 0) {
            for (WebElement option : options) {
                System.out.println(option.getText());
                Assert.assertEquals(text, option.getText());
            }
        } else {
            Assert.fail("Zero results returned");
        }

    }

    public void verifyFieldsContainsPartText(By locator, String text) throws InterruptedException {
        Thread.sleep(5000);
        WebElement Searchlist = findElement(searchList);
        List<WebElement> options = Searchlist.findElements(locator);
        System.out.println(options.size());
        if (options.size() != 0) {
            for (WebElement option : options) {
                System.out.println(option.getText());
                Assert.assertTrue(option.getText().contains(text));
            }
        } else {
            Assert.fail("Zero results returned");
        }
    }

    public void goToLandingPage() {

        if (!getCurrentUrl().equals(landingPageUrl)) {
            navigateToUrl(landingPageUrl);
        }
    }

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

    public void closeBrowser() {
        getCurrentDriver().close();
    }

}



