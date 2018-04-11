import cucumber.api.java.en.Then;
import org.junit.Assert;

public class XmlRestrictionOnProductTest {

    WebConnector selenium=WebConnector.getInstance();

    @Then("^I should  not be able to delete the product$")
    public void I_should_not_be_able_to_delete_the_product()
    {
        Assert.assertFalse(selenium.isElementpresent("deleteButton"));
    }

    @Then("^I should not be able delete the assets of an xml created product$")
    public void I_should_not_be_able_delete_the_assets_of_an_xml_created_product() throws InterruptedException {
        selenium.click("Images");
        Thread.sleep(5000);
        selenium.Assert_deleteButton_not_present_forAllAssets();
        selenium.click("VideosLink");
        Thread.sleep(5000);
        selenium.Assert_deleteButton_not_present_forAllAssets();
        selenium.xml_created_product();

    }

}
