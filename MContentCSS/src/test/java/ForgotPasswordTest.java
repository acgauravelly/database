


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ForgotPasswordTest {

    WebConnector selenium = WebConnector.getInstance();

    @Then("^I should be able to request a new password$")
    public void I_should_be_able_to_request_a_new_password() throws Throwable {
        selenium.click("forgot_your_password");
        Thread.sleep(3000);
        selenium.input("email", "ajay@flixmedia.tv");
        selenium.click("ForgottenPassword");
        selenium.isElementpresent("ConfirmationMessage");
        String confMessage = selenium.getText("ResendConfirmationMessage");

        selenium.assertElementhasText("ResendConfirmationMessage", "Your Password is on it's way...");
        if (confMessage.equalsIgnoreCase("Your Password is on it's way..."))

        {
            selenium.click("closeButtononConfirmation");

        }
//		selenium.click("closeButtononConfirmation");
    }

    @And("^check for email$")
    public void checkForEmail() throws Throwable {
        selenium.navigate("Gmail");
        selenium.input("email_Field", "ajay@flixmedia.tv");
        selenium.click("next_Button");
        selenium.input("password_Field", "shalinimay27");
        selenium.readUnreadEmails();

        selenium.click("Reset_PasswordLink");
        Thread.sleep(3000);
        selenium.switchTabsinBrowser();
        Thread.sleep(3000);
        selenium.input("password","Pass123");
        selenium.input("Confirmpassword","Pass123");
        selenium.click("ResetPassword_button");


        throw new PendingException();
    }
}