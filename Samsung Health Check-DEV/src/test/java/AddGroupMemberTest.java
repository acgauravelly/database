import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

@SuppressWarnings("All")
public class AddGroupMemberTest {

    WebConnector selenium = WebConnector.getInstance();

    @And("^I add users to the group$")
    public void iAddUsersToTheGroup() throws Throwable {
        Thread.sleep(3000);
        selenium.click("ManageGroups");
        Thread.sleep(3000);
        selenium.input("SSearchField", "mark");
        Thread.sleep(3000);
        selenium.click("edit");
        selenium.switch_to_popup();
        selenium.input("userfield", "test@flixmedia.com");
        selenium.ChooseFromList("autoSuggest", "a", "test@flixmedia.com");
        selenium.click("save&update");
        Thread.sleep(5000);
        selenium.switch_to_default();


    }

    @Then("^I should see the group name assigned under edit user$")
    public void iShouldSeeTheGroupNameAssignedUnderEditUser() throws Throwable {


        selenium.click("ViewUsers");
        selenium.select("SearchBy", "Email");
        selenium.input("SSearchField", "test@flixmedia.com");
        Thread.sleep(4000);
        selenium.click("edit");
        selenium.switch_to_popup();

        String selectedGroup = selenium.isSelected("Groups");
        System.out.println(selectedGroup);
        String actGroup = "Marketing";
        Assert.assertTrue(selectedGroup.equalsIgnoreCase(actGroup));
        selenium.click("Save&Update");
        Thread.sleep(5000);
        selenium.switch_to_default();
        selenium.LandingPage();

    }
}
