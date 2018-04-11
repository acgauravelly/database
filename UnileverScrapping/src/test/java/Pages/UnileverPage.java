package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * Created by ajay on 02/01/2018.
 */
public class UnileverPage extends BasePage {

    private By wcContent = By.id("wc-aplus");
    private By flixContent = By.id("flix-Unilever-inpage");
    private String wcCon;
    private String flixCn;
//            By.className("wc-fragment");

    public void webCollage(String url) {
        goToUrl(url);
    }

    public void wcText() {
        System.out.println(getTextofElement(wcContent));
        System.out.println("******************************************************");
        wcCon=getTextofElement(wcContent);
//        return (getTextofElement(wcContent));
    }

    public void flixText() {
        System.out.println(getTextofElement(flixContent));
        System.out.println("******************************************************");
        flixCn=getTextofElement(flixContent)
;//        return (getTextofElement(flixContent));
    }

    public void compare() {
        Assert.assertEquals(wcCon, flixCn);
    }
}
