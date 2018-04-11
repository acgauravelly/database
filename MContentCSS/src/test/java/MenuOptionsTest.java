



import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class MenuOptionsTest {
	
	WebConnector selenium= WebConnector.getInstance();
	
	@Then("^I should be able to change personal settings$")
	public void I_should_be_able_to_change_personal_settings() throws InterruptedException
	{
		selenium.click("settings");
		selenium.isElementpresent("detailBox");
		selenium.input("FirstName", "Ajay");
		selenium.input("LastName", "Gauravelly");
		selenium.input("jobTitle", "QA Engineer");
		selenium.click("Save");
		selenium.isElementpresent("SavedPopup");
		selenium.assertElementhasText("ConfirmationMessage", "Personal settings saved");
		selenium.click("Close");
	}
	@And("^change my password$")
	public void  change_my_password() throws Throwable
	{
		selenium.click("ChangePassword");
		selenium.input("password", "Pass123");
		selenium.input("Confirmpassword", "Pass123");
		selenium.click("Save");
		selenium.isElementpresent("SavedPopup");
		selenium.assertElementhasText("ConfirmationMessage", "Password saved");
		selenium.click("Close");
	}
	
	@And("^access help menu$")
	public void access_help_menu()
	{
		selenium.click("help");
		selenium.isElementpresent("helpInstructions");
		selenium.click("Tutorials");
		selenium.isElementpresent("helpInstructions");
		selenium.click("settings");
		
	}
	@And("^change interface settings$")
	public void change_interface_settings() throws Throwable
	{
		
		selenium.click("InterfaceSettings");
		selenium.select("InterfaceLanguage", "French");
		selenium.click("Save");
		Thread.sleep(3000);
		selenium.click("Close");
		selenium.click("logoff");
		if (!selenium.isElementpresent("email"))
			Thread.sleep(5000);
		else
		selenium.doDefLogin();
		selenium.assertElementhasText("settings", "Configuration");
		selenium.click("settings");
		selenium.click("InterfaceSettings");
		selenium.select("InterfaceLanguage", "Anglais");
		selenium.click("Save");
		selenium.click("Close");
		selenium.click("logoff");
		selenium.doDefLogin();
		selenium.assertElementhasText("settings", "Settings");
		
		
	}
		
		
	

}
