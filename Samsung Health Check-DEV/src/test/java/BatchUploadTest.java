import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;


public class BatchUploadTest

{

    WebConnector selenium = WebConnector.getInstance();

    @Then("^I should be able to assign an asset by sku and category$")
    public void I_should_be_able_to_assign_an_asset_by_sku() throws InterruptedException, IOException

    {
        selenium.checkAllCheckboxes();
        Thread.sleep(3000);
//      Uploading Assets and filling in the info
        selenium.select("SelectFile", "C:\\Assets\\Test1.jpg");
        selenium.select("SelectFile", "C:\\Assets\\Wildlife.wmv");

//        selenium.updateassetsinPink();
        selenium.input("SkuSearch", "Gaurav");
//        Thread.sleep(3000);
        selenium.waittillelementstoBeClickable("Autosuggest");

//      choosing the sku
        selenium.ChooseFromList("Autosuggest", "a", "Selenium (nl) ( FlixId: 340385 - MPN: Gauravellys )");

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

//     Verify on product level if images are uploaded and deletes image
        selenium.verifyifonProduct_Page();
        selenium.click("Images");
        Thread.sleep(5000);
        selenium.assetCarouselSize(1);
        selenium.click("deleteButton");
        selenium.switch_to_popup();
        selenium.click("DELETE");
        selenium.assertElementhasText("ImagesInfo", "No images found");

//      Checks video is present and deletes video
        selenium.click("VideosLink");
//        selenium.assertElementhasText("UpdatedTitle", "Wildlife");
        Thread.sleep(5000);
        selenium.assetCarouselSize(1);
        selenium.click("deleteButton");
        selenium.switch_to_popup();
        selenium.click("DELETE");
        selenium.assertElementhasText("VideoInfo", "No videos found");
        selenium.LandingPage();

//        Verify for mobile category
        selenium.navigate("Mobcategory");
        selenium.click("Images");
//        selenium.assertElementhasText("UpdatedTitle", "Testimage");
        selenium.assetCarouselSize(1);
        selenium.click("deleteButton");
        selenium.switch_to_popup();
        selenium.click("DELETE");
        selenium.assertElementhasText("ImagesInfo", "No images found");


//      Checks video is present and deletes video
        selenium.click("VideosLink");
//        selenium.assertElementhasText("UpdatedTitle", "TestVideo");
        selenium.assetCarouselSize(1);
        selenium.click("deleteButton");
        selenium.switch_to_popup();
        selenium.click("DELETE");
        selenium.assertElementhasText("VideoInfo", "No videos found");
        selenium.LandingPage();


    }

}
