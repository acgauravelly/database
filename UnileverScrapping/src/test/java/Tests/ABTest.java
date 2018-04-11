package Tests;

import Pages.ABPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by ajay on 02/01/2018.
 */
public class ABTest {
    ABPage apage = new ABPage();

    @Given("^I  \"([^\"]*)\"$")
    public void i(String arg0) throws Throwable {
        apage.pad(arg0);
    }

    @Then("^I should pass the test$")
    public void iShouldPassTheTest() throws Throwable {
        apage.pass();
    }
}
