



import cucumber.api.java.en.Then;

public class EANSearchTest {
	
	WebConnector selenium= WebConnector.getInstance();
	
	@Then("^I should be able to search by using EAN from Advanced search$")
	public void I_should_be_able_to_search_by_using_EAN_from_Advanced_search() throws InterruptedException
	{
		selenium.click("AdvSearch");
		selenium.input("EAN", "0854448003723");
		selenium.click("AdvSearchButton");
		selenium.verifyFieldsContainsText("searchList", "MPNField", "S3000BWGB");
		selenium.LandingPage();
	}

}
