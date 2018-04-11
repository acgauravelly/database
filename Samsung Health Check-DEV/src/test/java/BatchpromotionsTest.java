import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

/**
 * Created by ajay on 29/02/2016.
 */
public class BatchpromotionsTest {
    WebConnector selenium = WebConnector.getInstance();

    @Then("^I should be able to upload promotions to sku and category$")
    public void I_should_be_able_to_upload_promotions_to_sku_and_category() throws InterruptedException, IOException

    {


//      Uploading Assets and filling in the info
        selenium.select("SelectFile", "C:\\Assets\\Test1.jpg");
        selenium.select("SelectFile", "C:\\Assets\\Wildlife.wmv");
        selenium.updateassetsinPink();
        selenium.input("SkuSearch", "Gaurav");

        Thread.sleep(5000);
        selenium.waittillelementstoBeClickable("Autosuggest1");
//      choosing the sku
        selenium.ChooseFromList("Autosuggest1", "a", "Selenium (nl) ( FlixId: 340385 - MPN: Gauravellys )");

//      choosing the Category

        selenium.input("catfield", "Mobiel");
        selenium.waittillelementstoBeClickable("autoSuggest");
        selenium.isElementDisplayed("autoSuggest");
        selenium.ChooseFromList("autoSuggest", "a", "Mobiel -- main -- ( nl ) ( FlixId: 384629)");
        selenium.isElementpresent("Save&Update");

//      Confirming the right products choosen from auto suggest are selected

        List<WebElement> confirmations = selenium.driver.findElements(By.xpath(selenium.OR.getProperty("skuorcat_confirmation")));
        selenium.printsize(confirmations.size());
        Assert.assertTrue("product is not same", confirmations.get(0).getText().contains("Selenium (nl) ( FlixId: 340385 - MPN: Gauravellys )"));
        Assert.assertTrue("Category is not same", confirmations.get(1).getText().contains("Mobiel -- main -- ( nl ) ( FlixId: 384629)"));
        selenium.click("Save&Update");
        selenium.waittillElementPresent("AlertStatus");
        selenium.assertElementhasText("AlertStatus", "Files have been successfully uploaded!");


//   Verify if the assets are associated

        selenium.click("ManageContent");

        selenium.navigate("Testproduct");

        selenium.click("PromotionsLink");

        selenium.Promotionslist("ListofPromos", "PromotionsNamelist", "Test");

        selenium.assertElementhasText("promotionsInfo", "No downloads found");

        selenium.LandingPage();

        selenium.navigate("Mobcategory");

        selenium.click("PromotionsLink");

        selenium.Promotionslist("ListofPromos", "PromotionsNamelist", "Test");

        selenium.assertElementhasText("promotionsInfo", "No downloads found");

        selenium.LandingPage();


    }

}
