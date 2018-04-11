import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by ajay on 29/02/2016.
 */
public class PromotionAssociationTest
{
    WebConnector selenium=WebConnector.getInstance();

    @Then("^I should be able to associate promotions on a product & category level$")
    public void Association() throws InterruptedException {

        selenium.delete_Promotion_ifpresent("Testproduct");

        selenium.delete_Promotion_ifpresent("Mobcategory");

        selenium.click("PromotionsTab");

        selenium.input("SSearchField","Test la");

        Thread.sleep(5000);

        selenium.waittillelementstoBeClickable("edit");

        selenium.click("edit");

        selenium.switch_to_popup();

        selenium.input("SkuSearch", "Gaurav");
//        Thread.sleep(3000);

        selenium.waittillelementstoBeClickable("Autosuggest1");


//        choosing the sku
        selenium.ChooseFromList("Autosuggest1", "a", "Selenium (nl) ( FlixId: 340385 - MPN: Gauravellys )");

//      choosing the Category
        selenium.input("catfield", "Mobiel");

//        Thread.sleep(5000);

        selenium.waittillelementstoBeClickable("autoSuggest");

        selenium.isElementDisplayed("autoSuggest");

        selenium.ChooseFromList("autoSuggest", "a", "Mobiel -- main -- ( nl ) ( FlixId: 384629)");

        selenium.waittillElementPresent("Save&Update");

        selenium.isElementpresent("Save&Update");

        selenium.click("Save&Update");


        selenium.switch_to_default();

        selenium.waittillElementPresent("EditAlertStatus");

        selenium.assertElementhasText("EditAlertStatus","Promotion details saved successfully");

        //   Verify if the assets are associated


        selenium.navigate("Testproduct");

        selenium.click("PromotionsLink");

        selenium.click("PromotionsNamelist");

        selenium.assertElementhasText("Assetname", "Test language");



        selenium.LandingPage();

        selenium.navigate("Mobcategory");

        selenium.click("PromotionsLink");

        selenium.click("PromotionsNamelist");

        selenium.assertElementhasText("Assetname", "Test language");



        selenium.click("PromotionsTab");

        selenium.input("SSearchField","Test la");

        Thread.sleep(5000);

        selenium.waittillelementstoBeClickable("edit");

        selenium.click("edit");

        selenium.switch_to_popup();

//        removes all associations

        List<WebElement>  cloebuttons=selenium.driver.findElements(By.xpath(selenium.OR.getProperty("close")));

        System.out.println("close buttons present "+""+cloebuttons.size());

        for(WebElement closebutton:cloebuttons)

        {
            closebutton.click();
            Thread.sleep(1000);
        }
        List<WebElement> skuandcatselected=selenium.driver.findElements(By.xpath(selenium.OR.getProperty("skuorcat_confirmation")));

        int a=skuandcatselected.size();

        System.out.println("size of associations"+""+a);

        Assert.assertTrue("Associations still present",a==0);


        selenium.click("Save&Update");

//Verifies if association changes are reflected on product and category level
        selenium.navigate("Testproduct");

        selenium.click("PromotionsLink");

        Assert.assertFalse(selenium.isElementpresent("PromotionsNamelist"));

        selenium.navigate("Mobcategory");

        selenium.click("PromotionsLink");

        Thread.sleep(5000);


        Assert.assertFalse(selenium.isElementpresent("PromotionsNamelist"));

        selenium.LandingPage();

    }
}
