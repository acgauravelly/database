import cucumber.api.java.en.Then;

/**
 * Created by ajay on 04/03/2016.
 */
public class AssignUserstoGroupsTest {

    WebConnector selenium=WebConnector.getInstance();

    @Then("^I should be able to Assign users to groups$")
    public void AssignUsers() throws InterruptedException {


        selenium.AssignUsertoGroup("abc");


        selenium.click("Logoff");

//        Verifying if the category is disabled

        selenium.doTestLogin();

        selenium.verifyCategory_Restriction();

        selenium.verifyProduct_Restriction();


        selenium.click("Logoff");

        selenium.Wait();

        selenium.doDefLogin();

        selenium.click("AdminArea");

        selenium.RemoveUserfromGroup();

        selenium.LandingPage();

    }
}
