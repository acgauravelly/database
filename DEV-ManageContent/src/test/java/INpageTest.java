




import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class INpageTest {
	
WebConnector selenium = WebConnector.getInstance();
	
	@And("^I add an INpage in German$")
	public void i_add_Feature() throws Throwable 
	{
	   
		selenium.click("INpage");
		selenium.click("AddButton");
		selenium.switch_to_popup();
		selenium.select("pageLanguage", "German");
		selenium.click("Save&Update");
		selenium.switch_to_default();
		selenium.assertElementhasText("ActiveColumn", "No");
		selenium.click("German");
		
		
		
		
	}

	@Then("^I should see the INpage JavaScript  and be able to edit information and delete the INpage$")
	public void i_should_see_the_added_feature_and_be_able_to_edit_and_delete_it() throws Throwable 
	{
		
		Assert.assertTrue("Object not found", selenium.isElementpresent("JavaScript"));
		selenium.click("deleteButton");
		selenium.switch_to_popup();
		selenium.click("DELETE");
		selenium.assertElementhasText("pageDescription", "No Inpage found");
		selenium.click("BasicInformation");
		
	}


}
