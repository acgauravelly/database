package Tests;

import Pages.JWplayerPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by ajay on 21/06/2017.
 */
public class JWPlayerTest {
    JWplayerPage jw = new JWplayerPage();

    @Given("^I visit \"([^\"]*)\"$")
    public void iVisit(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("minisite")) {
            jw.goToMinisite();
        } else if (arg0.equalsIgnoreCase("inpage")) {
            jw.goTOInpage();
        }
    }

    @When("^I play the JW player$")
    public void iPlayTheJWPlayer() throws Throwable {
        jw.play();


    }
//
//    @Then("^I should be able to get the state$")
//    public void iShouldBeAbleToGetTheState() throws Throwable {
////        jw.returnState();
//        jw.assertStateIdle();
//    }

    @And("^I wait for  the JW player$")
    public void iWaitForTheJWPlayer() throws Throwable {
        jw.isPlayerLoaded();
    }

    @Then("^the state of JW player should be \"([^\"]*)\"$")
    public void theStateOfJWPlayerShouldBe(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("idle")) {
            jw.assertStateIdle();
        } else if (arg0.equalsIgnoreCase("playing")) {
            jw.assertPlaying();
        } else if (arg0.equalsIgnoreCase("paused")) {
            jw.assertpaused();
        }
    }

    @And("^I switch to the iframe for  the JW player$")
    public void iSwitchToTheIframeForTheJWPlayer() throws Throwable {
        jw.switchToJWIframe();
    }

    @When("^I pause the JW player$")
    public void iPauseTheJWPlayer() throws Throwable {
        jw.play();
        Thread.sleep(5000);
        jw.pause();
    }
}
