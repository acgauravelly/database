package Tests;

import Pages.EBuilderPage;
import Pages.ProductPage;
import Pages.ReaderPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by ajay on 17/07/2017.
 */
public class EditProductTest {
    ProductPage ppage = new ProductPage();
    EBuilderPage epage = new EBuilderPage();
    ReaderPage rpage = new ReaderPage();

    @When("^I click the \"([^\"]*)\"$")
    public void iClickThe(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("Build product content")) {
            ppage.buildProductContent();
            ppage.switchToEcbBuilder();

        }
    }

    @And("^Iam taken to the crafter$")
    public void iamTakenToTheCrafter() throws Throwable {
        epage.waitforEndTourButton();
        epage.confirmOnCrafterPage();
        epage.clickEndTour();
        Thread.sleep(5000);
    }

    @Then("^I should be able to edit the product and confirm changes$")
    public void iShouldBeAbleToEditTheProduct() throws Throwable {
        Thread.sleep(5000);
        epage.editProductContent();
        rpage.confirmOnReaderPage();
        rpage.publishProduct();
        rpage.confirmPublish();
        ppage.confirmECBChangesToProduct();


    }
}
