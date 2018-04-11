package Pages;

import Util.WebConnector;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

/**
 * Created by ajay on 07/07/2017.
 */
public class EBuilderPage extends BasePage {


    private String ebuilderPage = "https://whirlpool.crafter.demo-synthrone.com/app/builder/open/923?app-token=3XjYw865u2aLj32JfaN9q33P25WSWGelf6-5fcaFsliXa5a07dN4e8ev3w==";
    private By headerButton = By.id("header");
    private By endTourButton = By.cssSelector("button[data-role='end']");
    private By componentsHolder = By.id("elements");
    private By components = By.className("componentPreview");
    private By lockscreen = By.id("lockscreen");
    private By lockScreeninfo = By.id("lockscreen_info");
    private By takeCntrlButton = By.id("lockscreen__info__btn-take-controll");
    private By iconsBlock = By.id("blocks");
    private By logoLeft = By.xpath("//*[@id='elements']/li[1]/div[2]");
    private By galleryLeftDescription = By.cssSelector("#mw_ebp>div>div>#product-info-gallery-left_ebp>.row_ebp>div:nth-child(2)>div:nth-child(2)>p");
    //            By.cssSelector("div[data-translation_ebp='product-info-gallery-left-description-1']>p:nth-child(2)");
    private By saveButton = By.className("mdi-content-save");
    private By savingInProgressMessage = By.className("mdi-action-cached rotate");
    public static By textField = By.cssSelector(".product-list_ebp");
    private By previewButton = By.id("generatePreview");


    //By.id("product-info-gallery-left_ebp");
    public void ebuilderPageNavigation() {
        if (!getCurrentUrl().equals(ebuilderPage)) {
            goToUrl(ebuilderPage);
        }
        confirmTitle("Crafter :: Builder");
    }

    public void clickEndTour() throws InterruptedException {
        click(endTourButton);
        takeControl();
        Thread.sleep(10000);
    }

    public void waitforEndTourButton() {
        waitForElementTobePresent(endTourButton);
    }

    public void confirmOnCrafterPage() {
        confirmTitle("Crafter :: Builder");
    }

    public void takeControl() {

        if (isElementDisplayed(lockscreen)) {
            WebElement tcb = findElement(lockscreen).findElement(takeCntrlButton);
            tcb.click();
//            click(takeCntrlButton);
        }

    }

    public void clickHeader() throws InterruptedException {
        List<WebElement> icons = findElement(iconsBlock).findElements(By.tagName("a"));
        System.out.println(icons.size() + " *** is the total number of icons on the left**");
        Thread.sleep(3000);
        for (WebElement eachicon : icons) {
            if (eachicon.getAttribute("id").equalsIgnoreCase("header")) {
                eachicon.click();
            }
        }
    }

    public void clickRandomComponent() {

        Actions action = new Actions(WebConnector.getCurrentDriver());
        action.doubleClick(findElement(logoLeft)).perform();
    }


    public void editProductContent() throws InterruptedException {
        switchToiFrame("ui-id-2");
        moveToElement(textField);
        Thread.sleep(5000);
        clearField(textField);
        writetoField(textField, todaysDate());
        Thread.sleep(2000);
        switchToParentFrame();
        Thread.sleep(2000);
        click(saveButton);
        Thread.sleep(15000);
//        waitForTextTodissappear(savingInProgressMessage);
        click(previewButton);
        switchTab(2);

//        confirmTitle("Reader");
//        switchToiFrame("iframe");
//        System.out.println(getText(textField));
//        Assert.assertTrue(getText(textField).equals(todaysDate()));


    }

}
