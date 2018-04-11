package Pages;

import Util.WebConnector;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ajay on 06/07/2017.
 */
public class ProductPage extends BasePage {
    LoginPage loginPage = new LoginPage();

    private By buildProductContentLink = By.className("icon-build-card");
    private By buildProductContentButton = By.id("template-submit-btn");
    private By basicInformationLink = By.className("icon-info");
    private By featuresLink = By.className("icon-features");
    private By featureTextField = By.cssSelector(".left>div:nth-child(3)");
    private By inpageFeatureTextField = By.className("product-list_ebp");
    private By productInfoContentBox = By.id("box-content");
    private By productFields = By.className("detail-list-content-full");
    private By mcSuccessMessage = By.cssSelector("#box-content>p");
    private By inpageLink = By.className("icon-inpage");
    private By englishInpage = By.xpath("//*[@id='/product/inpageinfo/id/1203384/lang_id/1/']/td[1]");
    private By detailsContainer = By.className("details-container");
    private By preview = By.cssSelector("a[title='Preview']");


    private String testProduct = "https://manage.flix360.com/product/info/id/1203384/lang_id/1";


    public void navigateToTestProductPage() {
        if (!getCurrentUrl().equals(testProduct)) {
            navigateToUrl(testProduct);
        }
    }

    public void buildProductContent() throws InterruptedException {
        click(buildProductContentLink);
        click(buildProductContentButton);
//        confirmAlert();
        Thread.sleep(30000);
    }

    public void switchToEcbBuilder() throws InterruptedException {
        switchTab(1);

    }


    public String getProductName() {

        return getFirstFieldText(productInfoContentBox, productFields);
    }

    public void confirmProductName() {
        String actprodName = getProductName();
        Assert.assertTrue(actprodName.contains(todaysDate()) && actprodName.startsWith("AutoTest"));
    }

    public void confirmECBChangesToProduct() throws InterruptedException {
        waitForTextTobepresent(mcSuccessMessage, "Processing completed successfully");
        Thread.sleep(5000);
        click("Logoff");
        Thread.sleep(1000);
        loginPage.confirmOnLoginPage();
        loginPage.defaultLogin();
        navigateToTestProductPage();
        click(basicInformationLink);
        click(featuresLink);
        click(inpageLink);
        click(englishInpage);
        waitForElementtoBeDisplayed(detailsContainer);
        click(preview);
        switchTab(3);
        String currUrl = getCurrentUrl();
        Random random = new Random();
        int cache = random.nextInt(5000);
        navigateToUrl(currUrl + cache);

        Thread.sleep(2000);
        refreshPage();
        System.out.println("Cache code url is **" + currUrl);
        for (int i = 0; i < 40; i++) {
            int timetaken = i;
            if (getText(inpageFeatureTextField).equals(todaysDate())) {
                System.out.println("Time taken is " + i + "secs");
                break;

            } else {
                refreshPage();
                Thread.sleep(3000);
                System.out.println("Waiting time is   " + timetaken);
                if (timetaken >= 40) {
                    Assert.fail("Text has not changed to todays date in **" + i + "** secs");
                }
            }
        }
        switchTab(2);
        click(featuresLink);
        Assert.assertEquals(todaysDate(), getText(featureTextField));


    }
}
