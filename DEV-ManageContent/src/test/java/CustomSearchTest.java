

import cucumber.api.java.en.Then;


public class CustomSearchTest {
	
	WebConnector selenium= WebConnector.getInstance();
	
	@Then("^I should search for products using custom search using MPN column$")
	public void I_should_search_for_products_using_custom_search_using_MPN_column() throws Throwable
	{
		selenium.click("CustomProductSearch");
		selenium.input("SelectFile", "C:\\Assets\\Custom_product_search-Dev.xlsx");
		selenium.select("MPNColumn", "Column B");
		selenium.click("Search");
        Thread.sleep(5000);
        selenium.FieldsContainPartOftheText("MPNField", "MPNField", "Custom");
		selenium.LandingPage();


	}

   /** @And("^I should search for products using custom search using EAN column$")
    public void I_should_search_for_products_using_custom_search_using_EAN_column() throws Throwable
    {
        selenium.click("CustomProductSearch");
        selenium.input("SelectFile", "U:\\Assets\\Custom_product_search.xlsx");
        selenium.select("MPNColumn", "Column E");
        selenium.click("Search");
        selenium.FieldsContainPartOftheText("MPNField", "MPNField", "EDDIE0");
        selenium.LandingPage();

    }**/

}
