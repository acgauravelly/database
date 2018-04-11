import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by ajay on 03/03/2016.
 */
public class GroupsTest {

    WebConnector selenium=WebConnector.getInstance();

    @Then("^I should be able to create a group$")

    public void create_Group() throws InterruptedException

    {
//        Create Groups
        selenium.click("AdminArea");

        selenium.click("ManageGroups");

        selenium.Wait();

        selenium.click("AddButton");

        selenium.switch_to_popup();

        selenium.input("CreateGroupTitle", "AutoGroup");

        selenium.Wait();

        if (selenium.isElementDisplayed("createButton")) {
            selenium.click("createButton");
        }

        selenium.switch_to_default();

        selenium.waittillElementPresent("EditAlertStatus");

        selenium.assertElementhasText("EditAlertStatus", "Group details saved successfully");

        WebElement list = selenium.driver.findElement(By.xpath(selenium.OR.getProperty("searchList")));

        List<WebElement> groups = list.findElements(By.xpath(selenium.OR.getProperty("elementsinlist")));

        System.out.println("No of Groups present are" + "" + groups.size());

        System.out.println(groups.get(0).getText());

        Assert.assertTrue("Group is not created", groups.get(0).getText().contains("AutoGroup"));

//Delete Group

        selenium.input("SSearchField","AutoGroup");

        selenium.click("GroupDelete");

        selenium.switch_to_popup();

        selenium.waittillElementPresent("DeleteGroupFormText1");

        selenium.assertElementhasText("DeleteGroupFormText1","Are you sure you want to delete this user group?");

        selenium.waittillElementPresent("DeleteGroupFormText2");

        selenium.assertElementhasText("DeleteGroupFormText2","There are total 0 users in this group!");

        selenium.click("Save&Update");

//        selenium.Wait();

        selenium.switch_to_default();


        selenium.assertElementhasText("EditAlertStatus","Group details saved successfully");



    }
    @And("^I should manage restrictions$")

    public void manage_restrictions() throws InterruptedException

    {
        selenium.input("SSearchField","abc");

        selenium.Wait();

        selenium.click("UserEditbutton");

        selenium.switch_to_popup();

//        Thread.sleep(5000);
        selenium.waittillElementPresent("SkuSearch");

        selenium.input("SkuSearch", "Gaurav");

//        Thread.sleep(3000);

        selenium.waittillelementstoBeClickable("autoSuggest");

//        choosing the sku
        selenium.ChooseFromList("autoSuggest", "a", "Selenium (nl) ( FlixId: 340385 - MPN: Gauravellys )");

        selenium.input("catfield", "Mobiel");

//        Thread.sleep(5000);

        selenium.waittillelementstoBeClickable("autoSuggest2");

        selenium.isElementDisplayed("autoSuggest2");

        selenium.ChooseFromList("autoSuggest2", "a", "Mobiel -- main -- ( nl ) ( FlixId: 384629)");

        selenium.isElementpresent("Save&Update");

        selenium.click("Save&Update");

//        Thread.sleep(13000);

        selenium.switch_to_default();

        selenium.waittillElementPresent("EditAlertStatus");

        selenium.waittillelementstoBeClickable("ManageContent");

        selenium.LandingPage();
//        selenium.waittillelementsPresent("ViewUsers");


    }


}

