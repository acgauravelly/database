



import cucumber.api.java.en.Then;

public class AdvancedSearchTest {
	
	WebConnector selenium = WebConnector.getInstance();
	
	@Then("^I should be able search via advanced search$")
	public void i_should_be_able_search_via_advanced_search() throws Throwable 
	{
	    
		selenium.click("AdvSearch");
		selenium.input("MPNs", "VGP");
		selenium.ChooseFromList("VGPAC10V10.CEL");
		selenium.click("AdvSearchButton");
		selenium.verifyFieldsContainsText("searchList", "MPNField", "VGPAC10V10.CEL");
		selenium.LandingPage();
		
	}

}
