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

import static Utils.WebConnector.getCurrentDriver;


@SuppressWarnings("ALL")
public class BasePage {


    static String winHandleBefore;


    public void goToUrl(String url) {

        getCurrentDriver().get(url);
    }

    public void navigateToUrl(String url) throws InterruptedException {

        getCurrentDriver().navigate().to(url);
        Thread.sleep(5000);
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

    public String getTextofElement(By locator){
        return findElement(locator).getText();
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

        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void confirm200HttpCode() throws IOException

    {
        WebClient webClient = new WebClient();
        int code = webClient.getPage(getCurrentDriver().getCurrentUrl()).getWebResponse().getStatusCode();
        System.out.println(code);
        int expCode = 200;
        Assert.assertEquals(expCode, code);

    }

    public void switchToMinisiteWindow() {
        // Store the current window handle
        winHandleBefore = getCurrentDriver().getWindowHandle();

// Perform the click operation that opens new window

// Switch to new window opened
        for (String winHandle : getCurrentDriver().getWindowHandles()) {
            getCurrentDriver().switchTo().window(winHandle);

        }
    }

    public void closeBrowser() {
        getCurrentDriver().close();
    }

    // Switch back to original browser (first window)
    public void switcBackToMainWindow() {

        getCurrentDriver().switchTo().window(winHandleBefore);

    }


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

}
