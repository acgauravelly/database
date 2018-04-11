



import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class SpecificationsTest {
	
	WebConnector selenium= WebConnector.getInstance();
	
	@And("^I add Specifications$")
	public void i_add_Specifications() throws Throwable {
	   
		selenium.click("Specifications");
		selenium.click("AddButton");
		selenium.switch_to_popup();
		selenium.input("GroupTitle", "Specifications");
		selenium.input("Value", "Test");
		selenium.select("Status", "Live");
		selenium.select("Type", "Key Specification");
		selenium.click("Save&Update");
		selenium.switch_to_default();
		
		
		
	
	}

	@Then("^I should see the added Specifications and be able to edit information and delete it\\.$")
	public void i_should_see_the_added_Video_and_be_able_to_edit_information_and_delete_it() throws Throwable {
		selenium.assertElementhasText("SpecTitle", "Specifications");
		selenium.assertElementhasText("ValueField", "Test");
		selenium.click("deleteButton");
		selenium.switch_to_popup();
		selenium.click("DELETE");
		selenium.assertElementhasText("SpecsInfo", "No specifications found");
		selenium.click("BasicInformation");

	}

}
