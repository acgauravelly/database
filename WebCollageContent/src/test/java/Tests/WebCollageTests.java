package Tests;

import Pages.CompetitorPage;
import Utils.WebConnector;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by ajay on 14/08/2017.
 */
public class WebCollageTests {
    CompetitorPage cpage = new CompetitorPage();

    @Given("^I visit a \"([^\"]*)\"$")
    public void iVisitA(String arg0) throws Throwable {
        cpage.visitRetUrl(arg0);

    }


    @And("^I export the harfile$")
    public void iExportTheHarfile() throws Throwable {
        cpage.exportHarFile();

    }

    @Then("^I should be able to search for webcollage content$")
    public void iShouldBeAbleToSearchForWebcollageContent() throws Throwable {
//        cpage.contentCheck("webcollage");
        cpage.domainCheck("true");
    }

    @Then("^the search for webcollage content should be \"([^\"]*)\"$")
    public void theSearchForWebcollageContentShouldBe(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("FALSE")) {
//            cpage.domainCheck("False");
            cpage.wcCheckinDOM(arg0);
        } else if (arg0.equalsIgnoreCase(
                "TRUE")) {
//            cpage.domainCheck("True");
            cpage.wcCheckinDOM(arg0);
        }
    }
}
