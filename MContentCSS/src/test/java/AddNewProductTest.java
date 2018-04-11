



import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class AddNewProductTest {

	WebConnector selenium = WebConnector.getInstance();

	@And("^I add a new Product$")
	public void I_add_a_new_Product() throws Throwable {
		selenium.click("Addnewproduct");
		selenium.input("Name", "TestQA");
		selenium.input("Heading", "Test Product");
		selenium.input("SubHeading", "Test Product1");
		selenium.input("Description", "This is a Test Product");
		selenium.select("LanguageField", "English");
		selenium.select("Vendor", "Flixmedia");
		selenium.input("MPN", selenium.randomMPN());
		selenium.input("Keyword", "TestAutomation");
		selenium.click("Add_new_product");


	}

	@Then("^I should be able to see the new product added with the details$")
	public void i_should_be_able_to_see_the_new_product_added_with_the_details() throws Throwable {

		selenium.click("Inpage");
		selenium.Verify("pageDescription", "No Inpage found");
		selenium.LandingPage();
	}

}
