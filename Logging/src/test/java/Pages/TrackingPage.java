package Pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static Utils.Util.getCurrentDriver;

public class TrackingPage extends BasePage {
    private JavascriptExecutor js = (JavascriptExecutor) getCurrentDriver();

    private String awURL = "http://media.flixfacts.com/staging/flixpreview/index.php?mpn=S7370/12&language=en&live=0&distributor_id=2830";
    private String minisite = "http://dev-delivery.flix360.com/minisite/show/6/fr/325717";
    private String inpage = "http://media.flixfacts.com/staging/darty/darty-new-dev.php?distributor=6&language=en&mpn=UCORIGIN";
    private By JWThumb = By.className("flix_jw_videoid");

    public void visitService(String service) throws InterruptedException {

        switch (service) {

            case "aw":
                goToUrl(awURL);
                Thread.sleep(10000);
                break;
            case "minisite":
                goToUrl(minisite);
                Thread.sleep(10000);
                break;
            case "inpage clamp":
                goToUrl(inpage);
                Thread.sleep(10000);
                break;
            default:
                System.out.println("NOt the service listed");
        }
    }

    public void awTracking() {
        additionalFeaturesTracking("/attach/log.gif", "impression", "en", "792005", "2830");
    }

    public boolean isPlayerLoaded() {


        if (returnState() != null) {
            return true;
        } else
            return false;
    }

    public void switchToJWIframe() throws InterruptedException {
        Thread.sleep(5000);
        switchToiFrame("flix-iframe0");
    }

    public void switchToInpageIframe() throws InterruptedException {
//        click(JWThumb);
        Thread.sleep(3000);
//        switchToiFrame("flix-iframe1");
        switchToiFrame(0);

    }


    public void play() throws InterruptedException {
        js.executeScript("jwplayer().play();");
        Thread.sleep(30000);

    }

    public void pause() {
        js.executeScript("jwplayer().pause();");
    }

    public void stop() {
        js.executeScript("jwplayer().stop();");
    }

    public void assertStateIdle() {
        String currentStatus = returnState();
        Assert.assertEquals(currentStatus, ("idle"));
    }

    public void assertPlaying() {
        String currentStatus = returnState();
        Assert.assertEquals(currentStatus, "playing");
    }

    public void assertpaused() {
        String currentStatus = returnState();
        Assert.assertEquals(currentStatus, "paused");
    }

    public String returnState() {
        System.out.println("The status of the  of the jw player is  ****   " + (String) js.executeScript("return jwplayer().getState()"));
        return (String) js.executeScript("return jwplayer().getState()");


    }

    public void videoTracking() {
        Tracking("et=mediaload", "U0fdjXhI", "mediaload", "fr", "325717", "6");
        Tracking("et=mediatime", "U0fdjXhI", "mediatime", "fr", "325717", "6");
    }

}
