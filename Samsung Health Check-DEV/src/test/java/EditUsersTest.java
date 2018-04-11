import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by ajay on 23/10/2015.
 */
public class EditUsersTest {

    WebConnector selenium=WebConnector.getInstance();


    @Then("^I should be able to edit the existing user details  in the system$")
    public void editUsers() throws InterruptedException {
//        selenium.LandingPage();
        selenium.click("AdminArea");
        selenium.waittillElementPresent("SearchBy");
//        selenium.click("ViewUsers");
        selenium.select("SearchBy","Lastname");
        selenium.input("SSearchField","Automation");
        selenium.Wait();
        selenium.waittillelementstoBeClickable("UserEditbutton");
        selenium.click("UserEditbutton");
        selenium.switch_to_popup();
        selenium.select("Groups","None");
        selenium.click("changepassword");
        selenium.input("Userpassword","1234567");
        selenium.click("Save&Update");
        selenium.switch_to_default();
        selenium.waittillElementPresent("EditAlertStatus");
        selenium.assertElementhasText("EditAlertStatus","User has been successfully created and an automated notification has been delivered to the user's e-mail address");
        Thread.sleep(3000);

    }

    @And("^verify the changed details$")
    public void verify_changed_details() throws InterruptedException {
        selenium.click("UserEditbutton");

        selenium.switch_to_popup();
        selenium.input("FirstName","TESTAUTO123");
        selenium.input("LastName","Automation123");
        selenium.select("Groups","None");
        selenium.click("Save&Update");
        selenium.switch_to_default();
        selenium.Wait();

//Verifying the edits are present firstname and last name
        selenium.waittillElementPresent("firstNameColumn");
        selenium.assertElementhasText("firstNameColumn","Testauto123");
        selenium.assertElementhasText("LastNameColumn","Automation123");

//Changing back to original from edits
        selenium.click("UserEditbutton");
        selenium.switch_to_popup();
        selenium.input("FirstName","TESTAUTO");
        selenium.input("LastName","Automation");
        selenium.select("Groups","None");
        selenium.click("Save&Update");
        selenium.switch_to_default();

//Reverting to initial text
        selenium.waittillElementPresent("SearchBy");
        selenium.select("SearchBy","FirstName");
        selenium.input("SSearchField","TESTAUTO");
        selenium.Wait();
        selenium.assertElementhasText("firstNameColumn","Testauto");
        selenium.assertElementhasText("LastNameColumn","Automation");
        selenium.LandingPage();



    }
}
