import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

public class AddtoCartTest {

    WebConnector selenium = WebConnector.getInstance();
    CommonUtil util = new CommonUtil();

    public String productPage = "https://manage.flix360.com/product/info/id/947517/lang_id/1";
    public By editButton = By.cssSelector("bt.btedit.tooltip-trigger-s.overlay-trigger-form>img");
    private By turnOffDownloadsCheckbox = By.cssSelector("input[name='download']");
    private By addToMyDownloads = By.cssSelector("#add_to_cart");
    private By downloadStatus = By.cssSelector(".alert.success_1");


    @Given("^I am on the product page$")
    public void iAmOnTheProductPage() throws Throwable {
        if (!selenium.currentUrl().equals(productPage)) {
            selenium.navigate(productPage);
        }

    }

    @Then("^I should be able to add a product to the cart for download$")
    public void iShouldBeAbleToAddAProductToTheCartForDownload() throws Throwable {

        selenium.click(editButton);
        selenium.switchToiFrame();
        selenium.uncheckCheckboxifSelected(turnOffDownloadsCheckbox);
        selenium.saveAndUpdate();
        selenium.click(selenium.downloadButton);
        selenium.click(addToMyDownloads);
        selenium.verifyTextofaField(downloadStatus, "successfully added to downloads cart!");
        util.landingPage();
    }
}
