package Pages;


import com.gargoylesoftware.htmlunit.WebClient;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

import static Utils.WebConnector.getCurrentDriver;

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

}
