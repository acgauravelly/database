import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


public class CopyAssetsTest {

    WebConnector selenium = WebConnector.getInstance();

    @And("^I click on BatchAssociation$")
    public void iClickOnBatchAssociation() throws Throwable {
        selenium.click("BatchUpload");
        selenium.click("Batch_Association");

    }

    @And("^select a from product and to product$")
    public void selectAFromProductAndToProduct() throws Throwable {

        selenium.input("from_productField", "seleniumcop");
        Thread.sleep(3000);
        selenium.ChooseFromList("fromsuggestlist","a","Selenium from (nl) ( FlixId: 789903 - MPN: seleniumCopyTest1 )");
        Thread.sleep(3000);
        selenium.input("toProductField", "seleniumCopy");
        selenium.ChooseFromList("tosuggestlist","a","SeleniumCopyTest ( FlixId: 790818 - MPN: SeleniumCopyTest )");
        selenium.click("dutchCheckbox");

    }

    @And("^I click Save and Update$")
    public void iClickSaveAndUpdate() throws Throwable {

        selenium.click("save");
    }

    @Then("^assets should be copied over$")
    public void assetsShouldBeCopiedOver() throws Throwable {

        selenium.navigate("toProduct");
        selenium.click("Images");
        selenium.assertElementhasText("Asset_nameField", "from");
        selenium.deleteAsset();
        Thread.sleep(3000);
        selenium.click("videos");
        selenium.assertElementhasText("Asset_nameField", "From_Video");
        selenium.deleteAsset();
        Thread.sleep(3000);
        selenium.click("Documents");
        selenium.click("PromotionsNamelist");
        selenium.deleteAsset();
        selenium.LandingPage();
    }
}
