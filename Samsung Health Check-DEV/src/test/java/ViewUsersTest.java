import cucumber.api.java.en.Then;

/**
 * Created by ajay on 23/10/2015.
 */
public class ViewUsersTest {

    WebConnector selenium=WebConnector.getInstance();

@Then("^I should be able to view the users in the system and make changes$")
    public void ViewUsers() throws InterruptedException {

    selenium.click("AdminArea");
//    selenium.click("ViewUsers");
    selenium.select("SearchBy","FirstName");
    selenium.input("SSearchField","TESTAUTO");
    selenium.Wait();
    selenium.verifyFieldsContainsText("searchList", "firstNameColumn", "Testauto");
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
