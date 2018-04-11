package Tests;

import Pages.MobilePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class MobileTest {
    MobilePage mobilePage = new MobilePage();

    @Given("^I visit darty \"([^\"]*)\"$")
    public void iVisitDarty(String arg0) throws Throwable {
        mobilePage.goToUrl(arg0);

//        mobilePage.clickLaMarqueVousParle();
//        mobilePage.jsErrors();
    }


    @And("^I view the page source$")
    public void iViewThePageSource() throws Throwable {
        mobilePage.pageSource();
    }

    @Then("^I should be able to see our code$")
    public void iShouldBeAbleToSeeOurCode() throws Throwable {
        mobilePage.assertPageSourceContains();
    }

    @Then("^I should be able to verify the content$")
    public void iShouldBeAbleToVerifyTheContent() throws Throwable {
        mobilePage.clickTabsOnInpage();
    }

    @And("^verify \"([^\"]*)\" are not displayed$")
    public void verifyAreNotDisplayed(String arg0) throws Throwable {
        mobilePage.hotspotsAbsent();
    }

    @Given("^I visit  \"([^\"]*)\" on darty \"([^\"]*)\"$")
    public void iVisitOnDarty(String arg0, String arg1) throws Throwable {
        mobilePage.openDartyUrl(arg0, arg1);
//        mobilePage.clickLaMarqueVousParle();
        mobilePage.jsErrors();
    }

    @Then("^I should be able to verify the \"([^\"]*)\" content$")
    public void iShouldBeAbleToVerifyTheContent(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("amd")) {
            mobilePage.twoMotAndOneManualInpage();
        } else if (arg0.equalsIgnoreCase("google")) {
            mobilePage.motWithOneManualInPage();
        }
    }
}
