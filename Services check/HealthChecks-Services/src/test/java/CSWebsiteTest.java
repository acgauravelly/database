import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by ajay on 16/02/2016.
 */
public class CSWebsiteTest {
    WebConnector selenium=WebConnector.getInstance();

    @Given("^I Navigate to our  CSWebsite$")
    public void Navigate_to_CSWebsite()
    {
        selenium.navigate("CSWebsite");
    }

    @Then("I should be able to see the Logo and Footer")
    public void LogoAndFooter() throws InterruptedException {
        selenium.isElementDisplayed("Logo is not displayed","CSFlixLogo");
            System.out.println("Success");
        selenium.isElementDisplayed("Footer is not present","CSFooter");
        System.out.println("Success");
    }

}
