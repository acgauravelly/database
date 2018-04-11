import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class CommonUtil {
    public String landinPageUrl = "http://dev-manage.flix360.com/samsung/search";
    WebConnector selenium = WebConnector.getInstance();

    @Given("^Iam logged in as an Admin user$")
    public void Iam_an_Admin_user() throws InterruptedException {
        selenium.openBrowser("Mozilla");
        if (!selenium.isLoggedin()) {
            selenium.log("checking if user is logged in and if not logging in user with default details");
            selenium.doDefLogin();
            Thread.sleep(4000);
            Assert.assertTrue("User is not an Admin user", selenium.isElementpresent("AdminArea"));
        }
    }

    @And("^Iam on the xml created product$")
    public void xml_created_product_ML2525()

    {

        selenium.xml_created_product();
    }

    @Then("^I should be able to delete a manually uploaded asset$")
    public void delete_manually_uploaded_asset() throws InterruptedException {
        selenium.click("VideosLink");
        selenium.click("AddButton");
        selenium.switch_to_popup();
        selenium.input("Name", "TestVideo");
        selenium.input("File", "C:\\Assets\\Wildlife.wmv");
        selenium.click("save&update");
        selenium.switch_to_default();
        Thread.sleep(3000);
//        selenium.LandingPage();
        selenium.delete_manual_Asset();
//        selenium.LandingPage();


    }

    @Then("^I should be able to delete a asset manually uploaded$")
    public void deleteasset_manually_uploaded() throws InterruptedException {
        selenium.click("VideosLink");
        selenium.click("AddButton");
        selenium.switch_to_popup();
        selenium.input("Name", "TestVideo");
        selenium.input("File", "C:\\Assets\\Wildlife.wmv");
        selenium.click("save&update");
        selenium.switch_to_default();
        Thread.sleep(3000);
        selenium.deleteAsset();
        Assert.assertFalse(selenium.isElementpresent("AssetCarousel"));

        /** selenium.click("deleteButton");
         selenium.switch_to_popup();
         selenium.click("DELETE");

         selenium.switch_to_default();
         Thread.sleep(3000);
         );**/

    }

    @Given("^Iam on Landing Page as an Admin user$")
    public void iam_on_landing_page() throws InterruptedException {
        selenium.openBrowser("Mozilla");
//        selenium.driver.navigate().to(landinPageUrl);

        if (!selenium.isLoggedin()) {

            selenium.doDefLogin();
        }
/**
 if (selenium.isElementpresent("fancyBox")) {
 selenium.driver.navigate().to(landinPageUrl);
 Thread.sleep(5000);
 }
 if (selenium.isLoggedin()) {
 selenium.click("ManageContent");
 } else {
 selenium.doDefLogin();
 }
 **/

        Thread.sleep(5000);

    }

    @And("^Iam on the Admin menu$")
    public void Admin_menu() {
        if (!selenium.isElementpresent("AdminHeader"))
            selenium.click("ManageContent");
        selenium.click("AdminArea");
    }

    @Given("^Iam on Batch Upload menu$")

    public void Iam_on_Batch_Upload_menu() throws InterruptedException {

        selenium.navigate("Testproduct");
        selenium.click("Images");
        selenium.delete_Asset_ifpresent();
        selenium.click("VideosLink");
        selenium.delete_Asset_ifpresent();

        selenium.navigate("Mobcategory");
        selenium.click("Images");
        selenium.delete_Asset_ifpresent();
        selenium.click("VideosLink");
        selenium.delete_Asset_ifpresent();
        selenium.click("BatchUpload");
    }

    @And("^Iam on Batch promotions menu$")
    public void Batch_Promotions() throws InterruptedException {

        selenium.delete_Promotion_ifpresent("Testproduct");
        selenium.delete_Promotion_ifpresent("Mobcategory");
        selenium.LandingPage();
        selenium.click("BatchUpload");
        selenium.click("BatchPromotions");
    }


    @After()
    public void tearDown(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()) {
            scenario.write("Failed Scenario: " + scenario.getName());
            //             Take a screenshot
            final byte[] screenshot = ((TakesScreenshot) selenium.driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
            Thread.sleep(5000);
            selenium.driver.navigate().to(landinPageUrl);
        }

    }

    @Given("^Iam logged in as Embargo User$")
    public void iamLoggedInAsEmbargoUser() throws Throwable {
        selenium.openBrowser("Mozilla");
//        selenium.navigate("http://dev-manage.flix360.com/samsung");
        if (selenium.isLoggedin()) {
            selenium.click("Logoff");
        }
        selenium.embargoLogin();
//        selenium.LandingPage();

    }
/**
 @And("Iam on Landing Page")
 public void landingPage() {
 //        String landinPageUrl="https://dev-manage.flix360.com/samsung/search";
 if (!selenium.driver.getCurrentUrl().equalsIgnoreCase(landinPageUrl)) {
 selenium.driver.navigate().to(landinPageUrl);
 }

 }

 **/
}
