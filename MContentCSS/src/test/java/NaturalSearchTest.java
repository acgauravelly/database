





import cucumber.api.java.en.Then;

public class NaturalSearchTest {
	
	WebConnector selenium= WebConnector.getInstance();
	
	@Then("^I should search for products using natural search$")
	public void i_should_search_for_products_using_natural_search() throws InterruptedException
	{
		selenium.input("searchfield", "NEST");
		selenium.click("searchButton");
		selenium.verifyFieldsContainsText("searchList", "brandname", "NEST");
		selenium.isElementDisplayed("noOfProducts");
		selenium.select("NoofProductsDisplay", "200");
		selenium.click("NextPage");
		selenium.isElementpresent("PreviousPageArrows");
		selenium.click("FirstProduct");
		selenium.verify_Searchresults_Link_navigation();
//		selenium.click("Clearall");
//		selenium.click("VideosCheckbox");
//		Thread.sleep(3000);
//		selenium.click("ApplyFilters");
//		Thread.sleep(3000);
//		Assert.assertFalse(selenium.isElementpresent("nonVideoProduct"));
		selenium.LandingPage();
		
	}

}
