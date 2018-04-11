package Pages;

import Util.WebConnector;
import cucumber.runtime.StopWatch;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;


public class BatchDownloadPage extends BasePage {
    final String PRODUCTPAGE = "https://manage.flix360.com/product/info/id/1181251/lang_id/1";
    private By downloadButton = By.className("download_image");
    private By wholeProduct = By.id("download_product");
    private By editButton = By.cssSelector("a[original-title='Edit']");
    private By turnOffDownloadsCheckBox = By.cssSelector("input[name='download']");
    private By saveAndUpdate = By.className("button-blue.button-right-flush");
    private By myDownloadsCart = By.xpath("//div[@id='dialog']/h1");
    private By downloadonCart = By.cssSelector("span[class='ui-button-text']");
    private By processStatus = By.xpath("//*[@id='progress']/section/header/h6");
    private By downloadUrl = By.id("download_url");
    private By emailWhenProcessed = By.id("closeme");

    public static long startTime;
    public static long startSeconds;

    public void login() {
        navigateToUrl("https://manage.flix360.com");
        userLogin("qa.automation@flixmedia.tv", "Pass123");

    }

    public void productPage() throws InterruptedException {
        if (!WebConnector.getCurrentDriver().getCurrentUrl().equals(PRODUCTPAGE)) {
            Thread.sleep(2000);
            navigateToUrl(PRODUCTPAGE);
        }
    }

    public void downloadProduct() throws InterruptedException {

        click(downloadButton);
        click(wholeProduct);
        Thread.sleep(5000);
        click(downloadonCart);

    }

    public void turnOffDownloads() throws InterruptedException {
        if (!isElementDisplayed(downloadButton)) {
            click(editButton);
            switchToiFrame(0);
            Thread.sleep(5000);
            uncheckCheckboxifSelected(turnOffDownloadsCheckBox);
            click(saveAndUpdate);
        }
    }

    public void verifyDownloadisReady() throws InterruptedException {

        isElementDisplayed(myDownloadsCart);
        startTime = currentSystemTime();
        System.out.println("Start time now is   ******   " + startTime + "  Seconds ");
        for (int i = 0; i < 502; i++) {
            if (isElementPresent(downloadUrl)) {
                long currentTime = currentSystemTime();
                int processedTime = (int) (currentTime - startTime);
                System.out.println("Processed in **** " + processedTime);
                if (processedTime > 200 && processedTime < 500) {
                    Assert.fail("Didnt process in 2 mins but took ***** " + processedTime);
                }
                break;
            } else {
                Thread.sleep(1000);
                int waitedTime = (int) (currentSystemTime() - startTime);
                System.out.println("Waited  " + waitedTime + "** for the processing ");
                if (waitedTime > 500) {
                    click(emailWhenProcessed);
                    Assert.fail("Clicked email me after ****" + waitedTime);
                }

            }
        }
    }


}


