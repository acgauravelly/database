import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.io.IOException;

/**
 * Created by ajay on 16/02/2016.
 */
public class SamsungHubTest
{

    WebConnector selenium = WebConnector.getInstance();


    @Given("^I Navigate to the \"([^\"]*)\"$")
    public void Navigate_to_Url (String URL)
    {
        selenium.navigate(URL);
    }
    @Then("^I should be able to get the status of \"([^\"]*)\"$")
    public void I_should_be_able_to_get_the_status(String URL)throws IOException
    {
//        selenium.getStatusCodeHub(URL);
      selenium.doDefLogin();
        selenium.isElementpresent("Logoff");
        selenium.click("Logoff");
    }



}
