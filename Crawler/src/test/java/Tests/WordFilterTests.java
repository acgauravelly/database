package Tests;

import Pages.WordFilterPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by ajay on 23/08/2017.
 */
public class WordFilterTests {
    WordFilterPage wpage = new WordFilterPage();

    @Given("^Iam on the mot \"([^\"]*)\"$")
    public void iamOnTheMot(String arg0) throws Throwable {

        wpage.navigatetoMOTpage(arg0);
    }


    @And("^I expand features$")
    public void iExpandFeatures() throws Throwable {
        wpage.expandFeatures();
    }

    @When("^I search for the word \"([^\"]*)\"$")
    public void iSearchForTheWord(String arg0) throws Throwable {
        wpage.searchForWord(arg0);
    }

    @Then("^I should not find the word$")
    public void iShouldNotFindTheWord() throws Throwable {
        wpage.testPrint();
    }
}
