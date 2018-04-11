import cucumber.api.java.en.Then;


public class RemoveUsersFromGroupTest {

    WebConnector selenium = WebConnector.getInstance();

    @Then("^I should be able to remove users form groups$")
    public void removeUsers() throws InterruptedException {

        selenium.select("SearchBy", "Lastname");

        selenium.input("SSearchField", "Selenium");

        Thread.sleep(3000);

        selenium.click("Userseditbutton");

        selenium.switch_to_popup();

        selenium.select("Groups", "abc");

        selenium.click("save&update");

        selenium.switch_to_default();

        selenium.waittillElementPresent("EditAlertStatus");

        selenium.click("Logoff");

        selenium.doTestLogin();

        selenium.verifyCategory_Restriction();

        selenium.click("Logoff");

        selenium.waittillElementPresent("email");

        selenium.doDefLogin();
        selenium.LandingPage();
    }


}
