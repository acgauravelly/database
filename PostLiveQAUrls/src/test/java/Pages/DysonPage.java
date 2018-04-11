package Pages;

import Utils.WebConnector;
import org.junit.Assert;
import org.openqa.selenium.By;

public class DysonPage extends BasePage {

    private String dysonUrl = "http://www.darty.com/nav/achat/petit_electromenager/chauffage_ventilation/purificateur/dyson_hot_cool_hp02.html";
    private By flixInpage = By.cssSelector("#flix-dyson-inpage");
    private By featuresButton = By.cssSelector("a[href='#dyson_jump_features']");
    private By dysonHeader = By.cssSelector(".dyson_header_title");


    public void navigateToDysonUrl(String url)
    {
        navigateToUrl(url);
    }

    public void InpageisLoaded() {
        Assert.assertTrue(WebConnector.getCurrentDriver().findElement(flixInpage).isDisplayed());
        verifyTextofaField(dysonHeader, "Dyson Pure Hot + Cool Link Blanc/Argent");
    }


    public void featuresButtonIsPresent() {
        Assert.assertTrue(isElementPresent(featuresButton));
    }
}
