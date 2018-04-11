


import cucumber.api.java.en.Then;

public class RequestAccessTest {
	
	WebConnector selenium= WebConnector.getInstance();
	
	@Then("^I should be able to request access to manage content$")
	public void Then_I_should_be_able_to_request_access_to_manage_content() throws Throwable
	
	{
	
		selenium.click("RequestAccesslink");
		selenium.input("FirstName", "TEST");
		selenium.input("LastName", "Test Lastname");
		selenium.input("Email", "qa.automation@flixmedia.tv");
		selenium.input("Company", "TEST");
		selenium.select("Country", "United Kingdom");
		selenium.input("jobTitle", "TESTING QA ");
		selenium.input("Source", "TEST");
		selenium.select("Agency", "TEST");
		selenium.input("AgencyTitle", "TEST");
		selenium.click("English");
		selenium.click("RequestAccessButton");
		selenium.isElementDisplayed("emailConfirmation");
		selenium.assertElementhasText("emailConfirmation","Please verify your Email address");
		
		
		
		
	}

}
