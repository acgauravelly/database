package Tests;

import Pages.LandingPage;
import Pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class LoginTests {

    LoginPage lp = new LoginPage();
    LandingPage landpage = new LandingPage();

    @Given("^Iam on the loginpage$")
    public void iamOnTheLoginpage() throws Throwable {
        lp.navigateToLoginurl();
    }

    @Then("^I should be able to login$")
    public void iShouldBeAbleToLogin() throws Throwable {
        lp.login("ecb@flixmedia.tv", "testtest");
        landpage.isLoggedin();


    }

    @Given("^Iam logged in$")
    public void iamLoggedIn() throws Throwable {
        lp.isLoggedIn();
    }
}
