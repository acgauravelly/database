import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.fail;


public class Commonutil {

	WebConnector selenium = WebConnector.getInstance();




	@Given("^I am logged in$")
	public void i_am_logged_in() throws Throwable
	{
		selenium.openBrowser("Mozilla");
		if(!selenium.isLoggedin()){
			selenium.log("checking if user is logged in and if not logging in user with default details");
			selenium.doDefLogin();
			Thread.sleep(4000);
		}
	}
	
	@Given("^I am logged out of ManageContent$")
	public void I_am_logged_out_of_ManageContent()
	{
		selenium.click("logoff");
	}

	@And("^I search for a product$")
	public void search_for_a_product_and_select_it() throws Throwable 
	{
		selenium.LandingPage();
		selenium.input("searchfield","Ajays");
		selenium.click("searchButton");
		selenium.click("Ajaystestproduct");

	}

	@Given("^I am on the product page$")
	public void iam_on_the_product_page() throws Throwable{

		selenium.verifyifonProduct_Page();
		Thread.sleep(3000);
	}
	
	@Given("^I am on Landing Page$")
	public void iam_on_landing_page()
	{
		selenium.LandingPage();	
	}


	@Given("^I am on Login Page$")
	public void I_am_on_Login_Page()
	{
		selenium.openBrowser("Mozilla");
		
		selenium.Homepage();
	}


	/**@After()
	public void tearDown(Scenario scenario) throws InterruptedException {
		if (scenario.isFailed()) {
			scenario.write("Failed Scenario: " + scenario.getName());
			//             Take a screenshot
			final byte[] screenshot = ((TakesScreenshot) selenium.driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		//        selenium.logOut();
		}
**/
	@After()
	public void tearDown(Scenario scenario) throws InterruptedException {
		if (scenario.isFailed()) {
			scenario.write("Failed Scenario: " + scenario.getName());
			//             Take a screenshot
			final byte[] screenshot = ((TakesScreenshot) selenium.driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		else if(!scenario.isFailed()){
			scenario.write("Passed Scenario: " + scenario.getName());
			//             Take a screenshot
			final byte[] screenshot = ((TakesScreenshot) selenium.driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		//        selenium.logOut();
	}



    public static void assertForCondition(boolean condition) {
        try {
            assertTrue(condition);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Error occurred " + e.getMessage());
        }
    }


}
