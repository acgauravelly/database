package Pages;

import com.gargoylesoftware.htmlunit.WebClient;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Util.Connector.getCurrentDriver;

/**
 * Created by ajay on 10/08/2017.
 */
public class BasePage {



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

    public List<WebElement> findElements(String tagname) {

        return getCurrentDriver().findElements(By.tagName(tagname));
    }

    public void click(By locator) {
        waitForElement(locator);
        findElement(locator).click();

    }


    public String getCurrUrl(){
        return getCurrentDriver().getCurrentUrl();
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

    public boolean isElementDisplayed(By locator) {

        return findElement(locator).isDisplayed();
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

    public void waitForElement(By locator) {

        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void wait2MinutesforDownload(By locator,String text){
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), 120);
        wait.until(ExpectedConditions.textToBe(locator,text));
    }

    public void waitForElementtoBeDisplayed(By locator) {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), 300);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void confirm200HttpCode() throws IOException

    {
        WebClient webClient = new WebClient();
        int code = webClient.getPage(getCurrentDriver().getCurrentUrl()).getWebResponse().getStatusCode();
        System.out.println(code);
        int expCode = 200;
        Assert.assertEquals(expCode, code);

    }



    public void closeBrowser() {
        getCurrentDriver().close();
    }

    // Switch back to original browser (first window)



    //	Switch to window
    public void switchWindowAndClose(By locator) throws InterruptedException {
        // Store the current window handle
        String winHandleBefore = getCurrentDriver().getWindowHandle();

// Perform the click operation that opens new window

// Switch to new window opened
        for (String winHandle : getCurrentDriver().getWindowHandles()) {
            getCurrentDriver().switchTo().window(winHandle);

        }

        isElementDisplayed(locator);
// Perform the actions on new window

// Close the new window, if that window no more required
        getCurrentDriver().close();

// Switch back to original browser (first window)
        getCurrentDriver().switchTo().window(winHandleBefore);

// Continue with original browser (first window)
    }

    public void moveToElement(By locator) {

        Actions actions = new Actions(getCurrentDriver());
        actions.moveToElement(findElement(locator)).build().perform();
    }



    public int sizeOfList(By locator) {

        return findElements(locator).size();

    }

    public int sizeOfList(String tagname) {

        return findElements(tagname).size();
    }


    public void switchToiFrame(int frame) {
        getCurrentDriver().switchTo().frame(frame);

    }

    public void uncheckCheckboxifSelected(By locator) {

        WebElement checkBox = findElement(locator);
        if (checkBox.isSelected()) {
            checkBox.click();
        }
    }

    public long currentSystemTime(String event) {
        long currTime = System.currentTimeMillis();
        long currTimeInSecs = TimeUnit.MILLISECONDS.toSeconds(currTime);
        System.out.println(event+ "time now is   ******   " + currTimeInSecs + "  Seconds ");
        return currTimeInSecs;
    }

}

