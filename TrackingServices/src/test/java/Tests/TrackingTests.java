package Tests;

import Pages.AttachWidgetPage;
import Pages.TrackingPage;
import Pages.VideoPage;
import Utils.Connector;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by ajay on 23/06/2017.
 */
public class TrackingTests {

    TrackingPage tp = new TrackingPage();
    AttachWidgetPage aw = new AttachWidgetPage();
    VideoPage videoPage = new VideoPage();

    @Given("^I visit the \"([^\"]*)\"$")
    public void iVisitThe(String arg0) throws Throwable {
        tp.cleanFolder();
        tp.visitService(arg0);
        Thread.sleep(10000);
    }

    @And("^I export the harfile$")
    public void iExportTheHarfile() throws Throwable {
        Thread.sleep(60000);
        tp.rename();
        tp.isFileExists();
        if (tp.isFileExists()) {
            Connector.quit();
        }
    }

    @Then("^I should be able to verify the impressions for \"([^\"]*)\"$")
    public void iShouldBeAbleToVerifyTheImpressionsFor(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("attach widget")) {
            aw.awTracking();
        } else if (arg0.equalsIgnoreCase("minisite videos")) {
            Thread.sleep(60000);
            videoPage.minisiteVideoTracking();
        } else if (arg0.equalsIgnoreCase("inpage videos")) {
            Thread.sleep(60000);
            videoPage.inpageVideoTracking();
        }

    }

    @And("^I play the \"([^\"]*)\" Video$")
    public void iPlayTheVideo(String arg0) throws Throwable {

        if (arg0.equalsIgnoreCase("minisite")) {
            videoPage.switchToJWIframe();
            videoPage.play();


        } else if (arg0.equalsIgnoreCase("inpage")) {

            videoPage.switchToJWIframe();
            videoPage.play();
        }
    }
}

