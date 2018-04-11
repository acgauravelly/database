





import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class VideoTest {

	WebConnector selenium= WebConnector.getInstance();
	
	@And("^I add Video$")
	public void i_add_Video() throws Throwable {
	   
		selenium.click("Videos");
		selenium.delete_Asset_ifpresent();
		selenium.click("AddButton");
		selenium.switch_to_popup();
		selenium.input("Title", "TestTitle");
		selenium.input("File", "U:\\Assets\\Wildlife.wmv");
		selenium.input("V-Code", "Videos");
		selenium.select("Type", "Other");
		selenium.click("Save&Update");
		selenium.switch_to_default();
		
		
	
	}

	@Then("^I should see the added Video and be able to edit information and delete it.$")
	public void i_should_see_the_added_Video_and_be_able_to_edit_information_and_delete_it() throws Throwable {
		Assert.assertTrue("Object not found", selenium.isElementpresent("uploadedVideo"));
		selenium.click("EditButton");
		selenium.switch_to_popup();
		selenium.input("Title", "TestTitle1");
		selenium.click("Save&Update");
		Thread.sleep(3000);
		selenium.switch_to_default();
		selenium.assertElementhasText("UpdatedTitle", "TestTitle1");
		selenium.click("deleteButton");
		selenium.switch_to_popup();
		selenium.click("DELETE");
		selenium.assertElementhasText("VideoInfo", "No videos found");
		selenium.LandingPage();
		selenium.close();

	}
}
