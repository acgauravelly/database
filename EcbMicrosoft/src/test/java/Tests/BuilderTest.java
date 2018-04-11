package Tests;

import Pages.EBuilderPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by ajay on 07/07/2017.
 */
public class BuilderTest {
    EBuilderPage epage = new EBuilderPage();

    @Given("^I navigate to the builder$")
    public void iNavigateToTheBuilder() throws Throwable {
        epage.ebuilderPageNavigation();
        Thread.sleep(5000);
    }


    @Then("^I should be able to click the end tour$")
    public void iShouldBeAbleToClickTheEndTour() throws Throwable {
        epage.clickEndTour();
    }


    @And("^I click the header$")
    public void iClickTheHeader() throws Throwable {
        epage.clickHeader();
    }

    @And("^Add a header$")
    public void addAHeader() throws Throwable {
        epage.clickRandomComponent();
    }
}
