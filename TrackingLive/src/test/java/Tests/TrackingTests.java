package Tests;

import Pages.TrackingPage;
import Utils.Connector;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class TrackingTests {

    TrackingPage trackingPage = new TrackingPage();

    @Given("^I visit the \"([^\"]*)\"$")
    public void iVisitThe(String arg0) throws Throwable {
        trackingPage.cleanFolder();
        if (arg0.equalsIgnoreCase("clamp url")) {
            trackingPage.visitClampUrl();
            Thread.sleep(10000);
//            trackingPage.reviewsClicks();
        } else if (arg0.equalsIgnoreCase("video clamp")) {
            trackingPage.videoClamp();
            Thread.sleep(30000);
        } else if (arg0.equalsIgnoreCase("comparision clamp")) {
            trackingPage.comparisionClamp();
            Thread.sleep(10000);

        } else if (arg0.equalsIgnoreCase("minisite comparision url")) {
            trackingPage.minisiteWithCopmparisionTable();
            Thread.sleep(10000);

        } else if (arg0.equalsIgnoreCase("Minisite reviews  url")) {
            trackingPage.visitMinisite();
            Thread.sleep(10000);

        } else if (arg0.equalsIgnoreCase("Minisite video  url")) {
            trackingPage.visitMinisiteWithVideo();
            Thread.sleep(10000);

        } else if (arg0.equalsIgnoreCase("attach widget Clamp")) {
            trackingPage.visitAWclamp();
            Thread.sleep(10000);

        }
        else if (arg0.equalsIgnoreCase("hotspot url")) {
            trackingPage.visitHSUrl();
            Thread.sleep(10000);

        }


        Thread.sleep(30000);
    }


    @And("^I export the harfile$")
    public void iExportTheHarfile() throws Throwable {
        Thread.sleep(20000);
        trackingPage.rename();
        trackingPage.isFileExists();
        if (trackingPage.isFileExists()) {
            Connector.quit();
        }

    }


    @Then("^I should be able to verify the impressions for \"([^\"]*)\"$")
    public void iShouldBeAbleToVerifyTheTrackingFor(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("reviews")) {
            trackingPage.Tracking("http://media.flixcar.com/review/log.gif","/review/log.gif", "review_1", "page", "nz", "875355", "6565");
        } else if (arg0.equalsIgnoreCase("hotspots")) {
            trackingPage.Tracking("http://media.flixcar.com/interactive/log.gif","/interactive/log.gif", "Hotspot_E7354LOK_", "page", "fr", "888761", "11676");
        } else if (arg0.equalsIgnoreCase("minisite")) {
            trackingPage.minisiteLogging("http://media.flixcar.com/minisite/log.gif");
        } else if (arg0.equalsIgnoreCase("inpage")) {
            trackingPage.inpageLogging("http://media.flixcar.com/inpage/log.gif");
        } else if (arg0.equalsIgnoreCase("comparision table")) {
            trackingPage.additionalFeaturesTracking("http://media.flixcar.com/compare/log.gif","/compare/log.gif", "impression", "fr", "790777", "2754");
        } else if (arg0.equalsIgnoreCase("inpage videos")) {
            trackingPage.Tracking("http://media.flixcar.com/inpage/log.gif","et=mediaload", "1EOvqjNU", "mediaload", "fr", "888761", "6");
        } else if (arg0.equalsIgnoreCase("minisite videos")) {
            trackingPage.Tracking("http://media.flixcar.com/minisite/log.gif","et=mediaload", "1EOvqjNU", "mediaload", "fr", "888761", "11676");
        } else if (arg0.equalsIgnoreCase("attach widget")) {
            trackingPage.additionalFeaturesTracking("http://media.flixcar.com/attach/log.gif","/attach/log.gif", "impression", "da", "915711", "9157");
        }
    }

    @And("^I visit the harviewer website$")
    public void iVisitTheHarviewerWebsite() throws Throwable {

    }


    @And("^I play the Video$")
    public void iPlayTheVideo() throws Throwable {
//        trackingPage.playJWPlayer(30000);
    }

    @And("^I close the browser$")
    public void iCloseTheBrowser() throws Throwable {

        Connector.quit();

    }
}
