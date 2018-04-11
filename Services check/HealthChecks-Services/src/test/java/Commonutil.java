import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

/**
 * Created by ajay on 16/02/2016.
 */
public class Commonutil {
    WebConnector selenium = WebConnector.getInstance();


    @Given("^I Navigate to  \"([^\"]*)\"$")
    public void Navigate_to_Url (String URL)
    {
        selenium.navigate(URL);
    }

    @Then("^I should be able to get the status of the \"([^\"]*)\"$")
    public void I_should_be_able_to_get_the_status(String URL)throws IOException
    {
        selenium.getStatusCode(URL);
    }

    @Then("I should be able to see the \"([^\"]*)\" and \"([^\"]*)\"")
    public void LogoAndFooter(String Objectname1,String ObjectName2) throws InterruptedException {
        selenium.isElementDisplayed("Logo is not displayed",Objectname1);

        System.out.println("Success");

        selenium.isElementDisplayed("Footer is not present",ObjectName2);

        System.out.println("Success");
    }

    @After()
    public void tearDown(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()) {
            scenario.write("Failed Scenario: " + scenario.getName());
            //             Take a screenshot
            final byte[] screenshot = ((TakesScreenshot) selenium.driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        //        selenium.logOut();
    }




}
