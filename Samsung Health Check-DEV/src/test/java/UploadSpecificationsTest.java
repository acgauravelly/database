import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;


/**
 * Created by ajay on 27/10/2015.
 */
public class UploadSpecificationsTest {

    WebConnector selenium=WebConnector.getInstance();

    @And("^Iam on the Test product page$")
    public void Product_Page()
    {
        selenium.verifyifonProduct_Page();


    }

   @Then("^I should be able to batch upload specifications for the product.$")
    public void Upload_Specifications() throws InterruptedException {

       selenium.click("Specifications");
       selenium.input("SelectFile","C:\\Assets\\Specification.csv");
       Thread.sleep(3000);
       Assert.assertTrue("Save&Update is not present", selenium.isElementpresent("Save&Update"));
       selenium.click("Save&Update");
       Thread.sleep(3000);
       selenium.Assert_number_of_Rows_ina_Table("SpecificationsUploaded");
       selenium.LandingPage();
   }

}
