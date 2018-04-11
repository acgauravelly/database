






import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class FeatureTest {
	
	
	

	WebConnector selenium = WebConnector.getInstance();
	


	@Given("^I add Feature$")
	public void i_add_Feature() throws Throwable {
	   
		selenium.click("Features");
		selenium.click("AddButton");
		selenium.switch_to_popup();
		selenium.input("Title", "TestTitle");
		selenium.input("FeatureTitle", "TestDesc");
		selenium.input("File", "C:\\Assets\\Penguins.jpg");
		selenium.input("Code", "features");
		selenium.click("Save&Update");
		selenium.switch_to_default();
		
	}

	@Then("^I should see the added feature and be able to edit information and delete it.$")
	public void i_should_see_the_added_feature_and_be_able_to_edit_and_delete_it() throws Throwable {
		Assert.assertTrue("Object not found", selenium.isElementpresent("FeatureBox"));
		selenium.click("deleteButton");
		selenium.switch_to_popup();
		selenium.click("DELETE");
		selenium.assertElementhasText("FeaturesCount", "No features found");
		selenium.click("BasicInformation");
		
	}



}
