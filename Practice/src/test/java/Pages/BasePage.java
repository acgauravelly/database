package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static Utils.WebConnector.getCurrentDriver;

public class BasePage {

    public void goToUrl(String url) {

        getCurrentDriver().get(url);
    }

    public void click(By locator) {
        findElement(locator).click();
    }

    public WebElement findElement(By locator) {
        return getCurrentDriver().findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return getCurrentDriver().findElements(locator);
    }

    public boolean isElementPresent(By locator) {
        if (findElements(locator).size() == 0) {
            return false;
        } else
            return true;
    }

    public void explicitWaitForElementVisibility(long time, By locator) {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
