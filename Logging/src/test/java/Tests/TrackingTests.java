package Tests;

import Pages.TrackingPage;
import Utils.Util;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by ajay on 22/06/2017.
 */
public class TrackingTests {
    TrackingPage tp = new TrackingPage();

    @Given("^I visit the \"([^\"]*)\"$")
    public void iVisitTheClamp(String arg0) throws Throwable {
        tp.cleanFolder();
        tp.visitService(arg0);
        Thread.sleep(20000);
    }

    @And("^I export the harfile$")
    public void iExportTheHarfile() throws Throwable {
        Thread.sleep(5000);
        tp.isFileExists();
        tp.rename();
        Util.quit();
    }

    @Then("^I should be able to verify the impressions for \"([^\"]*)\"$")
    public void iShouldBeAbleToVerifyTheImpressionsFor(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("attach widget")) {
            tp.awTracking();
        } else if (arg0.equalsIgnoreCase("minisite videos")) {
            Thread.sleep(60000);
            tp.videoTracking();
        } else if (arg0.equalsIgnoreCase("inpage videos")) {
            Thread.sleep(60000);
            tp.videoTracking();
        }

//        tp.deleteFile();

    }

    @And("^I play the \"([^\"]*)\" Video$")
    public void iPlayTheVideo(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("minisite")) {
            tp.switchToJWIframe();
            tp.play();

        } else if (arg0.equalsIgnoreCase("inpage")) {
//            tp.switchToInpageIframe();
            tp.play();
        }
    }
}
