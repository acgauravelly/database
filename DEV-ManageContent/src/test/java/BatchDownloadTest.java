



import cucumber.api.java.en.Then;

public class BatchDownloadTest {

	WebConnector selenium= WebConnector.getInstance();

	@Then("^I should be able to do a Batch Download of Assets$")
	public void i_should_be_able_to_do_a_Batch_Download_of_Assets() throws Throwable
	{
		selenium.click("EditButton");
		selenium.switch_to_popup();
		selenium.UncheckCheckboxifSelected("TurnoffDownloads");
		selenium.click("Save&Update");
		selenium.switch_to_default();
		selenium.click("Download");
		selenium.click("DownloadWholeProduct");
		selenium.click("DownloadButton");
//		selenium.isElementDisplayed("MyDownloadsCart");
		selenium.assertElementhasText("ProcessingStatus", "Processing completed");
		selenium.click("CloseButton");
		selenium.LandingPage();

	}

}
