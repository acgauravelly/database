import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by ajay on 22/10/2015.
 */
public class BatchUsersTest {


    WebConnector selenium=WebConnector.getInstance();



    @And("^I upload a csv file in the required format$")
    public void i_upload_a_csv_file_in_the_required_format() throws Throwable
    {
        selenium.LandingPage();
        selenium.click("AdminArea");
        selenium.click("BatchUploadUsers");
        selenium.input("SelectFile","C:\\Assets\\samsung_sample_login.csv");
        selenium.areElementsPresent("firstNameColumn");
        selenium.areElementsPresent("LastNameColumn");
        selenium.areElementsPresent("EmailColumn");
        selenium.click("Save&Update");
        selenium.waittillElementPresent("AlertStatus");
        selenium.assertElementhasText("AlertStatus","Users saved successfully");

    }

    @Then("^I should be able to see the newly added users in the system$")
    public void i_should_be_able_to_see_the_newly_added_users_in_the_system() throws Throwable
    {

        selenium.click("ViewUsers");
        selenium.select("SearchBy","FirstName");
        selenium.input("SSearchField","TESTAUTO");
        selenium.Wait();
        selenium.verifyFieldsContainsText("searchList", "firstNameColumn", "Testauto");
        selenium.Wait();
        selenium.select("SearchBy","Lastname");
        selenium.input("SSearchField","Automation");
        selenium.Wait();
        selenium.verifyFieldsContainsText("searchList", "LastNameColumn", "Automation");
        selenium.select("SearchBy","Email");
        selenium.input("SSearchField","Autotest@flixmedia.tv");
        selenium.Wait();
        selenium.verifyFieldsContainsText("searchList", "EmailColumn", "Autotest@flixmedia.tv");
        selenium.LandingPage();

    }
    }



