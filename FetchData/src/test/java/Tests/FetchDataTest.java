package Tests;

import Pages.FetchDataPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by ajay on 13/06/2017.
 */
public class FetchDataTest {
    FetchDataPage data = new FetchDataPage();

    @Given("^I visit \"([^\"]*)\"$")
    public void iVisit(String arg0) throws Throwable {
        data.visitUrl(arg0);
    }

    @And("^I get the \"([^\"]*)\"$")
    public void iGetThe(String arg0) throws Throwable {
        data.getSearchTerm();
    }



    @Then("^I should be able to get the data$")
    public void iShouldBeAbleToGetTheData() throws Throwable {
       data.searchResults();
    }

    @And("^make a api call at \"([^\"]*)\"$")
    public void makeAApiCallAt(String arg0) throws Throwable {
        data.storeData(arg0);
    }

    @When("^i search with searchterm$")
    public void iSearchWithSearchterm() throws Throwable {
     data.search();
    }
}
