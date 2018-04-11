



import cucumber.api.java.en.Then;

public class BatchUploadTest {
	
	WebConnector selenium= WebConnector.getInstance();
	
	@Then("^I should be able to do a Batch Upload of Assets$")
	public void i_should_be_able_to_do_a_Batch_Upload_of_Assets() throws Throwable
	{
//		Deletes if any assets present on product page first
		selenium.verifyifonProduct_Page();
		selenium.click("Images");
		selenium.delete_Asset_ifpresent();
		selenium.click("Videos");
		selenium.delete_Asset_ifpresent();
		selenium.LandingPage();

	   selenium.click("BatchUploadTab");

		//  Clicks and uploads assets
		selenium.isElementpresent("DragandDropField");
		Thread.sleep(3000);
		selenium.click("DragandDropField");
		Runtime.getRuntime().exec("C:\\Users\\ajay\\Documents\\AutoIT\\Fileupload1.exe");
		Thread.sleep(3000);
		selenium.isElementpresent("Test1Image");
		selenium.isElementpresent("WildlifeVideo");
		selenium.click("DragandDropField");
		Runtime.getRuntime().exec("C:\\Users\\ajay\\Documents\\AutoIT\\Fileupload2.exe");
		Thread.sleep(3000);

//Clicks and edits Image added
		selenium.click("Test1Image");
		selenium.isElementpresent("AddLanguageTest1");
		selenium.click("AddLanguageTest1");
		selenium.select("BULanguageField", "English");
		selenium.input("AssetTitle", "testimage");
		selenium.click("AddLanguageonpopup");
		selenium.input("DescriptionArea1", "Test");
		Thread.sleep(3000);

//Clicks and edits video added
		selenium.click("WildlifeVideo");
		selenium.isElementpresent("AddLanguageVideo");
		selenium.click("AddLanguageVideo");
		selenium.select("BULanguageField", "English");
		selenium.input("AssetTitle", "TestVideo");
		selenium.click("AddLanguageonpopup");
		Thread.sleep(3000);
		selenium.input("DescriptionArea2", "TestVideo");
		Thread.sleep(3000);

//		Assign to a product
		selenium.input("BUSearch","AjT");
		selenium.ChooseFromList("-Test");
		selenium.click("BuS&UPD");
		selenium.assertElementhasText("UploadConfirmation","Files have been successfully uploaded!");

//		Verify on product level if assets are uploaded
		selenium.verifyifonProduct_Page();
		selenium.click("Images");
		selenium.assertElementhasText("UpdatedTitle", "testimage");
		selenium.click("deleteButton");
		selenium.switch_to_popup();
		selenium.click("DELETE");
		selenium.assertElementhasText("ImagesInfo", "No images found");

		selenium.click("Videos");
		selenium.assertElementhasText("UpdatedTitle", "TestVideo");
		selenium.click("deleteButton");
		selenium.switch_to_popup();
		selenium.click("DELETE");
		selenium.assertElementhasText("VideoInfo", "No videos found");
		selenium.LandingPage();
	   
	   
	   
	}

}
