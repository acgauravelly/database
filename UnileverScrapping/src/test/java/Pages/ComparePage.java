package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * Created by ajay on 02/01/2018.
 */
public class ComparePage extends BasePage {

    private By wcContent = By.className("wc-fragment");
    private By flixContent = By.id("flix-Unilever-inpage");
    public String wcText =WcContentText();
    public String flixText = FlixText();





    public void visitUrl(String url) throws InterruptedException {
       navigateToUrl(url);
    }
    public String WcContentText(){
       return getTextofElement(wcContent);
    }
    public String FlixText() {
        return getTextofElement(flixContent);
    }
    public void compare(){
        Assert.assertEquals(wcText,flixText);
    }

}


