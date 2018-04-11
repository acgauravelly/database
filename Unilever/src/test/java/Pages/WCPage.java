package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * Created by ajay on 02/01/2018.
 */
public class WCPage extends BasePage {

    private By wcContent = By.className("wc-fragment");
    private By flixContent = By.id("flix-Unilever-inpage");
    public String wcText = getWcContentText();
    public String fixText = getFlixText();


    public String getWcContentText() {

        return getTextofElement(wcContent);
    }

    public void visitUrl(String url) throws InterruptedException {

        goToUrl(url);
    }


    public String getFlixText() {
        return getTextofElement(flixContent);
    }

    public void compareText() {
        Assert.assertEquals(wcText, fixText);
    }

}
