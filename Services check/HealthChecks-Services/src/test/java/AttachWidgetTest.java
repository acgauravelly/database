import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by ajay on 16/02/2016.
 */
public class AttachWidgetTest {
    WebConnector selenium =WebConnector.getInstance();

    @Given("^Iam on a retailers page$")
    public void Retailer_Page()
    {
        selenium.navigate("AWUrl");
    }

    @Then("^I should be able to see the attachwidget$")
    public void See_Attachwidget() throws InterruptedException
    {
        selenium.isElementDisplayed("Attachwidget is not displayed","Attachwidget");
        System.out.println(selenium.getText("Attachwidget"));

    }
}
