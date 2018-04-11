package Tests;

import Pages.UnileverPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by ajay on 02/01/2018.
 */
public class UnileverTest {
    UnileverPage upage = new UnileverPage();

    @Given("^I visit  \"([^\"]*)\"$")
    public void iVisit(String arg0) throws Throwable {
        upage.webCollage(arg0);
    }

    @Then("^I get the text from the page$")
    public void iGetTheTextFromThePage() throws Throwable {
        upage.wcText();
    }

    @Then("^I get the text from the \"([^\"]*)\" page$")
    public void iGetTheTextFromThePage(String arg0) throws Throwable {
        upage.flixText();
    }

    @Then("^I should be able to compare$")
    public void iShouldBeAbleToCompare() throws Throwable {
        upage.compare();
    }
}
