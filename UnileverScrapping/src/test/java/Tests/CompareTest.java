package Tests;

import Pages.ComparePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by ajay on 02/01/2018.
 */
public class CompareTest {



        ComparePage wpage = new ComparePage();

        @Given("^I visit the \"([^\"]*)\"$")
        public void iVisitThe(String arg0) throws Throwable {
            wpage.visitUrl(arg0);
        }

        @And("^I get the \"([^\"]*)\" content$")
        public void iGetTheContent(String arg0) throws Throwable {
            if (arg0.equalsIgnoreCase("wc")) {
                wpage.WcContentText();
            } else if (arg0.equalsIgnoreCase("flix")) {
                wpage.FlixText();
            }
        }

        @Then("^the content should match$")
        public void theContentShouldMatch() throws Throwable {
            wpage.compare();
        }

        @When("^I  also visit the \"([^\"]*)\"$")
        public void iAlsoVisitThe(String arg0) throws Throwable {
            wpage.visitUrl(arg0);
        }
    }


