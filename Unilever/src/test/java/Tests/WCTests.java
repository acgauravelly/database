package Tests;

import Pages.WCPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by ajay on 02/01/2018.
 */
public class WCTests {

    WCPage page = new WCPage();

    @Given("^I visit the \"([^\"]*)\"$")
    public void iVisitThe(String arg0) throws Throwable {
        page.visitUrl(arg0);
    }

    @And("^I get the \"([^\"]*)\" content$")
    public void iGetTheContent(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("wc")) {
            page.getWcContentText();
        } else if (arg0.equalsIgnoreCase("flix")) {
            page.getFlixText();
        }
    }

    @Then("^the content should match$")
    public void theContentShouldMatch() throws Throwable {
        page.compareText();
    }
}
