package Pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingPage extends BasePage {

    private By adminButton = By.cssSelector("a[href='/samsung/admin/']");
    private String landingPageUrl = "https://dev-manage.flix360.com/samsung/search";
    public static By logoff = By.linkText("Logoff");
    private By tabsContainer = By.id("tab-nav");

    public void verifyOnLandingPage() {
        if (getCurrentUrl() != landingPageUrl) {
            navigateToUrl(landingPageUrl);
        }
    }

    //Verify admin button is present when logged in as admin user
    public void verifyLoggedInAsAdminUser() {
        Assert.assertTrue(isElementPresent(adminButton));
    }

    //    Click on Admin menu
    public void adminMenu() {
        if (isElementPresent(adminButton)) {
            click(adminButton);
            Assert.assertEquals("https://dev-manage.flix360.com/samsung/admin/view-users", getCurrentUrl());
        }
    }

    public List<WebElement> noOfTabs() {

        return findElement(tabsContainer).findElements(By.tagName("a"));

    }

    public void getTabName() {
        for (WebElement eachTab : noOfTabs()) {
            eachTab.getText();
        }
    }

    public void clickonTab(String name) {
        for (WebElement eachTab : noOfTabs()) {
            if (eachTab.getText().equalsIgnoreCase(name)) {
                eachTab.click();
            }
        }
    }

    public void verifyStandardUserTabs() {
        System.out.println(noOfTabs().size());
        assertForCondition(1, noOfTabs().size());
    }

    public void logout() {
        click(logoff);
    }

}
