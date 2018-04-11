package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Utils.WebConnector.currentDriver;


public class BasePage {

    //Navigates to a url
    public void goToUrl(String url) {
        try {
            currentDriver().get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Returns current url
    public String getCurrUrl() {
        return currentDriver().getCurrentUrl();
    }

//Find an element

    public WebElement findElement(By locator) {
        return currentDriver().findElement(locator);
    }


    //    Find all elements

    public List findElements(By locator) {
        return currentDriver().findElements(locator);
    }

    //clear a field

    public void clearField(By locator) {
        findElement(locator).clear();
    }

    //Type to a field
    public void type(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    //Click on an element
    public void click(By locator) {
        findElement(locator).click();
    }

    //checks if an element is present
    public boolean isElementPresent(By locator) {
        return findElements(locator).size() > 0;
    }

    //Check if an element is displayed
    public boolean isElementDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }

}
