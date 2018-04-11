





import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class DocumentsTest {
	
WebConnector selenium = WebConnector.getInstance();
	


	@And("^I add a Document$")
	public void i_add_Feature() throws Throwable {
	   
		selenium.click("Documents");
		selenium.click("AddButton");
		selenium.switch_to_popup();
		selenium.input("Title", "TestDoc");
		selenium.input("File", "C:\\Assets\\938081-DOCUMENT-FR-SAMSUNG.pdf");
		selenium.input("code", "document");
		selenium.select("Status", "Live");
		selenium.select("Type", "Other");
		selenium.click("Save&Update");
		selenium.switch_to_default();
		
	}

	@Then("^I should see the added Document and be able to edit information and delete it.$")
	public void i_should_see_the_added_feature_and_be_able_to_edit_and_delete_it() throws Throwable {
		Assert.assertTrue("Object not found", selenium.isElementpresent("DocumentInfo"));
		selenium.assertElementhasText("DocumentName", "TestDoc");
		selenium.click("DocumentName");
		Assert.assertTrue("Object not found", selenium.isElementpresent("DetailsBox"));
		selenium.click("deleteButton");
		selenium.switch_to_popup();
		selenium.click("DELETE");
		selenium.assertElementhasText("DocumentsInfo", "No documents found");
		selenium.verifyifonProduct_Page();
		
	}

}
