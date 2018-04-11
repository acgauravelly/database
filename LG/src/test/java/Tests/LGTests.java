package Tests;

import Pages.LG;
import Utils.WebConnector;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by ajay on 30/05/2017.
 */
public class LGTests {
    LG lg=new LG();

    @Given("^I visit the \"([^\"]*)\" url$")
    public void iVisitThe(String arg0) throws Throwable {
        lg.visitUrl(arg0);
    }


    @And("^I get the product details$")
    public void iGetTheProductDetails() throws Throwable {
       lg.getInfo();
    }

    @Then("^I should be able to write to a csv$")
    public void iShouldBeAbleToWriteToACsv() throws Throwable {
        System.out.println("Success");
        WebConnector.quit();
    }
}
