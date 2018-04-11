package Tests;

import Pages.ProductPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BatchDownloadTest {
    ProductPage productPage = new ProductPage();

    @And("^I am on the product page$")
    public void iAmOnTheProductPage() throws Throwable {
        productPage.verifyOnProductPage();
        Thread.sleep(4000);
    }

    @When("^I click the download buttton$")
    public void iClickTheDownloadButtton() throws Throwable {
        productPage.downloadProduct();
    }

    @Then("^the product should be downloaded with in (\\d+) minutes$")
    public void theProductShouldBeDownloadedWithInMinutes(int arg0) throws Throwable {
        productPage.verifyDownloadisReady();
//        productPage.isDownloaded(".zip");
    }
}
