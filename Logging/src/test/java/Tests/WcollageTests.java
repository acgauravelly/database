package Tests;

import Pages.WcollageContentPage;
import Pages.TrackingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by ajay on 08/08/2017.
 */
public class WcollageTests {

    WcollageContentPage cpage = new WcollageContentPage();
    TrackingPage tp=new TrackingPage();

    @Given("^I visit a \"([^\"]*)\"$")
    public void iVisitA(String arg0) throws Throwable {
        tp.cleanFolder();
        cpage.visitRetUrl(arg0);
    }

    @Then("^I should be able to verify if \"([^\"]*)\" content exists$")
    public void iShouldBeAbleToVerifyIfContentExists(String arg0) throws Throwable {
        cpage.ContentExists();
    }
}
