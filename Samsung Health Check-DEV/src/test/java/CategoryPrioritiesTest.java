import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by ajay on 26/10/2015.
 */
public class CategoryPrioritiesTest {

    WebConnector selenium=WebConnector.getInstance();

    @And("^I set the priorities for categories$")
    public void Set_Category_Priority() throws InterruptedException {
        selenium.LandingPage();
        selenium.click("AdminArea");
        selenium.click("SetCategoryPriority");
        selenium.DragandDrop("Mobiel","Geheugen");
        selenium.click("Save&Update");
        selenium.waittillElementPresent("AlertStatus");
        selenium.assertElementhasText("AlertStatus","Category priorities saved successfully");
        selenium.FirstElementText("CategoriesMenu","Categories","Mobiel");

    }

    @Then("^the search results should reflect that priority of categories$")
    public void see_priority_order() throws InterruptedException
    {
        selenium.click("Search");
        selenium.click("AdvSearch");
        selenium.input("KeywordField","Samsung");
        selenium.click("SearchButton");
        selenium.waittillElementPresent("FirstDisplayed-Category");
        selenium.assertElementhasText("FirstDisplayed-Category","Laden");
        selenium.LandingPage();
    }
}
