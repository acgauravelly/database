import cucumber.api.java.en.And;
import org.junit.Assert;

/**
 * Created by ajay on 27/10/2016.
 */
public class AssetUploadImprovementTest {
    WebConnector selenium = WebConnector.getInstance();

    @And("^I navigate to the test product$")
    public void iNavigateToTheTestProduct() throws Throwable {

        selenium.navigate("Testproduct");
        String expUrl = "http://dev-manage.flix360.com/samsung/product/info/id/340385/lang_id/4";
        String actUrl = selenium.getCurrentUrl();
        Assert.assertTrue(expUrl.equals(actUrl));


    }
//Uploading the asset
    @And("^I should be able to upload assets of 1Gb$")
    public void iShouldBeAbleToUploadAssetsOfGb() throws Throwable {
        selenium.click("PromotionsLink");
        selenium.click("AddButton");
        selenium.switch_to_popup();
        selenium.input("Title", "oneGB");
        selenium.input("File","C:\\Assets\\Test Asset-1GB.zip");
        selenium.click("save&update");
        selenium.WaittillElementIsInvisible();
        selenium.switch_to_default();

//Verification
        selenium.click("PromotionsNamelist");
        selenium.assertElementhasText("Assetname", "oneGB");
        selenium.deleteAsset();
        selenium.assertElementhasText("promotionsInfo", "No downloads found");
        selenium.LandingPage();

    }
}
