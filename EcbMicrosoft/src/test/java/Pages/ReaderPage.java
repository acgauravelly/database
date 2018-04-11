package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import static Pages.EBuilderPage.textField;

/**
 * Created by ajay on 20/07/2017.
 */
public class ReaderPage extends BasePage {
    private By publishButton = By.className("mdi-editor-publish");
    private By publishButtonOnPopup = By.cssSelector(".modal-footer>button");

    public void confirmOnReaderPage() {
        confirmTitle("Reader");
    }


    public void publishProduct() {
        switchToiFrame("iframe");
        System.out.println(getText(textField));
        Assert.assertEquals(getText(textField), todaysDate());
        switchToParentFrame();
        click(publishButton);
    }

    public void confirmPublish() throws InterruptedException {
        Thread.sleep(2000);
        click(publishButtonOnPopup);
        Thread.sleep(2000);
        waitForUrlTochangeto("manage.flix360.com");
    }

}
