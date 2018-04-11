package Tests;

import Pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by ajay on 08/06/2017.
 */
public class LoginTests {
    LoginPage loginPage = new LoginPage();


    @Given("^I navigate to loginUrl$")
    public void iNavigateToLoginUrl() throws Throwable {

        loginPage.navigateToLoginPage();


    }

    @And("^I do a default Login$")
    public void iDoADefaultLogin() throws Throwable {
        loginPage.defaultLogin();

    }

    @Then("^I should be logged in$")
    public void iShouldBeLoggedIn() throws Throwable {

        loginPage.verifyLoggedin();
    }
}
