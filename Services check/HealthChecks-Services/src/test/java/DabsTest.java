import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

/**
 * Created by ajay on 16/02/2016.
 */
public class DabsTest {

    WebConnector selenium = WebConnector.getInstance();

    @Given("^I am on Dabs product page$")
    public void DabsPage() {
//        selenium.openBrowser("Mozilla");
        selenium.navigate("BTShopUrl");
        selenium.driver.navigate().refresh();


    }

    @Then("^I should be able to see our Inpage and Minisite and HotSpots$")
    public void I_should_be_able_to_see_our_Inpage_and_Minisite_and_HotSpots() throws InterruptedException {
        Thread.sleep(5000);
//      checks if hotspots are displayed.

        selenium.isElementDisplayed("Specifications Hotspot is not displayed", "SpecsHS");

        selenium.isElementDisplayed("KeyFeaturesHS is not present", "KeyFeaturesHS");

//        Checks if Inpage is loaded
        selenium.isElementDisplayed("INpage is not displayed", "INpage");
        System.out.println(selenium.getText("INpage"));
        selenium.isElementDisplayed("Minisite button is not present", "MinisiteButton");
        selenium.click("MinisiteButton");
        Thread.sleep(5000);
        selenium.switchWindow("SamsungMinisite");
//        selenium.close();

    }

}
