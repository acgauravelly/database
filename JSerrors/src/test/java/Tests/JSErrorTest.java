package Tests;

import Pages.JSPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by ajay on 23/04/2017.
 */
public class JSErrorTest {
    JSPage jsPage = new JSPage();

    @Given("^Iam on the \"([^\"]*)\"$")
    public void iamOnThe(String arg0) throws Throwable {
        jsPage.flixUrl(arg0);
        Thread.sleep(10000);
    }


    @Then("^I should not see any JS errors$")
    public void iShouldNotSeeAnyJSErrors() throws Throwable {
        jsPage.getJSErrors();
//        jsPage.performanceLog();
    }
}
