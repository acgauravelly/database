



import cucumber.api.java.en.Then;

public class AddtoCartTest {
	
	WebConnector selenium = WebConnector.getInstance();
	
	@Then("^I should be able to add a product to the cart for download$")
	public void i_should_be_able_to_add_a_product_to_the_cart_for_download() throws Throwable {
	   
		selenium.click("EditButton");
		selenium.switch_to_popup();
		selenium.UncheckCheckboxifSelected("TurnoffDownloads");
		selenium.click("Save&Update");
		selenium.click("Download");
		selenium.click("AddtomyDownloads");
		selenium.assertElementhasText("DownloadStatus", "successfully added to downloads cart!");
		selenium.LandingPage();
	}

}
