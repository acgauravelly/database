package Tests;

import Pages.ProductPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by ajay on 09/06/2017.
 */
public class AssetTest {
    ProductPage productPage = new ProductPage();

    @When("^I click the \"([^\"]*)\"$")
    public void iClickThe(String arg0) throws Throwable {
        productPage.clickImagesMenu();
    }

    @Then("^Asset should be downloadable$")
    public void assetShouldBeDownloadable() throws Throwable {
        productPage.cleanFolder();
        productPage.downloadAsset();
        Thread.sleep(5000);
        Assert.assertTrue(productPage.isDownloaded(".png"));
        productPage.cleanFolder();
    }
}
