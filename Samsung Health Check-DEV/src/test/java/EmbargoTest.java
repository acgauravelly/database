import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class EmbargoTest {
    WebConnector selenium = WebConnector.getInstance();

    @And("^Iam on the Embargo page$")
    public void iamOnTheEmbargoPage() throws Throwable {

        selenium.navigate("EmbargoProduct");
    }

    @Then("^I should see the embargo content$")
    public void iShouldSeeTheEmbargoContent() throws Throwable {

//      Clicks on promotions link
        selenium.click("PromotionsLink");
//      clicks on a promotion
        selenium.click("PromotionsNamelist");
        selenium.assertElementhasText("Assetname", "Testimage");
        selenium.click("Logoff");
    }

    @Given("^Iam logged in as a standard user$")
    public void iamLoggedInAsAStandardUser() throws Throwable {

        if (selenium.isElementpresent("Logoff")) {
            selenium.click("Logoff");
        }
        selenium.doTestLogin();
    }

    @Then("^I should not see the emabrgo content$")
    public void iShouldNotSeeTheEmabrgoContent() throws Throwable {

        selenium.navigate("EmbargoProduct");
        selenium.click("PromotionsLink");
        selenium.assertElementhasText("promotionsInfo","No downloads found");
        selenium.click("Logoff");


    }
}
