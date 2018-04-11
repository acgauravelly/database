


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ImagesTest {

	WebConnector selenium = WebConnector.getInstance();


	@And("^I should be able to upload an Image$")
	public void i_should_be_able_to_upload_an_Image() throws Throwable {

		selenium.click("Images");
		selenium.delete_Asset_ifpresent();
		selenium.click("AddButton");
		selenium.switch_to_popup();
		selenium.input("Title", "TestImage");
		selenium.input("File", "C:\\Assets\\Test1.jpg");
		selenium.input("code", "images");
		selenium.select("Status", "Live");
		selenium.select("Type", "Other");
		selenium.click("Save&Update");
		selenium.switch_to_default();

	}


	@Then("^be able to edit information and delete image\\.$")
	public void be_able_to_edit_information_and_delete_image() throws Throwable {

		selenium.isElementpresent("PlaceholderImage");
		selenium.assertElementhasText("ImageName", "TestImage");
		selenium.click("deleteButton");
		selenium.switch_to_popup();
		selenium.click("DELETE");
		selenium.assertElementhasText("ImagesInfo", "No images found");
		selenium.click("BasicInformation");
	}



}
