


import cucumber.api.java.en.Then;

public class ForgotPasswordTest {
	
	WebConnector selenium= WebConnector.getInstance();
	
	@Then("^I should be able to request a new password$")
	public void I_should_be_able_to_request_a_new_password() throws Throwable
	{
		selenium.click("forgot_your_password");
		Thread.sleep(3000);
		selenium.input("email", "ajay@flixmedia.tv");
		selenium.click("ForgottenPassword");
		selenium.isElementpresent("ConfirmationMessage");
		String confMessage=selenium.getText("ResendConfirmationMessage");
	/**	if(confMessage.equalsIgnoreCase("Your Password is on it's way..."))

		{
			selenium.click("closeButtononConfirmation");
			selenium.navigate("loginUrl");
		}else
			selenium.close();
	}**/
	selenium.assertElementhasText("ResendConfirmationMessage", "Your Password is on it's way...");
}
}