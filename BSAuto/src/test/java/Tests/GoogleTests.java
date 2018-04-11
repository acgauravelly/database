package Tests;

import Pages.LandingPage;
import Utils.WebConnector;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class GoogleTests {
    LandingPage lp = new LandingPage();

    @Given("^I use BS$")
    public void iUseBS() throws Throwable {
        System.out.println("Iam using BS");
    }

    @Then("^I should be able to open google$")
    public void iShouldBeAbleToOpenGoogle() throws Throwable {
        lp.openGoogle();
        WebConnector.quit();
    }
}
