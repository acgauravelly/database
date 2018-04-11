package Tests;

import Pages.EBuilderPage;
import Pages.LandingPage;
import Pages.ProductPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by ajay on 06/07/2017.
 */
public class AddNewProductTests {
    LandingPage landingPage = new LandingPage();
    ProductPage productPage = new ProductPage();


    @Given("^Iam on the \"([^\"]*)\"$")
    public void iamOnThe(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("addproductpage")) {
            landingPage.addProductPage();
        } else if (arg0.equalsIgnoreCase("productpage")) {
            productPage.navigateToTestProductPage();
        }
    }

    @And("^I add a product with todays date$")
    public void iAddAProductWithTodaysDate(DataTable table) throws Throwable {
        landingPage.addProduct(table);
    }

    @Then("^I should be able to verify the added product$")
    public void iShouldBeAbleToVerifyTheAddedProduct() throws Throwable {
        productPage.getProductName();
        productPage.confirmProductName();
        productPage.buildProductContent();
        productPage.switchToEcbBuilder();

    }
}
