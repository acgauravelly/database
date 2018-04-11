



import cucumber.api.java.en.And;

public class ManualProductDeleteTest{

	WebConnector selenium = WebConnector.getInstance();

	@And("^I add a new Product$")
	public void I_add_a_new_Product() throws Throwable
	{
		selenium.click("AddProduct");
		selenium.input("Name", "TestQA");
//		selenium.input("Heading", "Test Product");
//		selenium.input("SubHeading", "Test Product1");
		selenium.input("Description", "This is a Test Product");
		selenium.select("LanguageField", "Dutch");
		selenium.select("Vendor", "Samsung");
		selenium.input("MPN", "TestMPN");
		selenium.input("Keyword", "TestAutomation");
		selenium.click("Add_new_product");


	}

	@And("^I should be able to delete the product$")
	public void delete_product() throws InterruptedException {
		selenium.click("BasicInformation");
//		selenium.verifyifonProduct_Page("http://dev-manage.flix360.com/samsung/product/info/id/336303/lang_id/4");
		selenium.click("deleteButton");
		selenium.switch_to_popup();
		selenium.click("DELETE");
		selenium.isElementpresent("searchfield");
		selenium.LandingPage();

	}

}
