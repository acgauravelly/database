






import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class BasicInformationTest {


	WebConnector selenium = WebConnector.getInstance();




	@Given("^Iam on Basic Information page$")
	public void iam_on_Basic_Information_page() throws Throwable 
	{
		selenium.click("BasicInformation");

	}
	

	@And("^edit the Basic Information$")
	public void edit_the_Basic_Information() throws Throwable
	{
		selenium.click("EditButton");
		selenium.switch_to_popup();
		selenium.input("Name", "-Test Product");
//		selenium.input("MPN", "Testmpn");
		selenium.clickCheckboxifNotSelected("TurnoffDownloads");
		selenium.click("Save&Update");
		Thread.sleep(3000);
		selenium.switch_to_default();
		

	}

	@Then("^I should see the updated Basic Information$")
	public void i_should_see_the_updated_Basic_Information() throws Throwable
	{
		selenium.Verify("ProductName", "-Test Product");
		Assert.assertFalse(selenium.isElementpresent("Downloadbutton"));
		selenium.click("BasicInformation");
		
	}



	
}
