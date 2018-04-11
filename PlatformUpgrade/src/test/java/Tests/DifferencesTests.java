package Tests;

import Pages.DifferencesPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DifferencesTests {
    DifferencesPage dp = new DifferencesPage();

    @Given("^I open the  \"([^\"]*)\"$")
    public void iOpenThe(String arg0) throws Throwable {

        dp.loadUrl(arg0);
    }

    @And("^I read the pagesource$")
    public void iReadThePagesource() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I read the \"([^\"]*)\" pagesource$")
    public void iReadThePagesource(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("dev")) {
            dp.devPageSource();
        } else if (arg0.equalsIgnoreCase("prod")) {
            dp.prodPageSource();
        }
    }

    @Then("^there should be no differences$")
    public void thereShouldBeNoDifferences() throws Throwable {

        dp.compareStrings();

//        dp.getChanges();

//        dp.compareHash();

//        dp.getAllDifferences();


    }


}
