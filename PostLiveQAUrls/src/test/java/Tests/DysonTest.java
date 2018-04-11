package Tests;

import Pages.DysonPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class DysonTest {

    DysonPage dysonPage = new DysonPage();

    @Given("^I navigate to dartyUrl$")
    public void iNavigateToDartyUrl() throws Throwable {


    }

    @Then("^I should see our dyson content$")
    public void iShouldSeeOurDysonContent() throws Throwable {

        dysonPage.InpageisLoaded();
        dysonPage.featuresButtonIsPresent();
    }

    @Given("^I navigate to \"([^\"]*)\"$")
    public void iNavigateTo(String arg0) throws Throwable {
        dysonPage.navigateToDysonUrl(arg0);
    }
}
