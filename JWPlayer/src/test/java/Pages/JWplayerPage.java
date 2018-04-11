package Pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Random;

import static Util.WebConnector.getCurrentDriver;

public class JWplayerPage extends BasePage {

    private JavascriptExecutor js = (JavascriptExecutor) getCurrentDriver();
    private String minisite = "http://dev-delivery.flix360.com/minisite/show/6/fr/325717";
    //
    private String inpage = "http://dev-delivery.flix360.com/inpage/show/6/en/804586?r=603636&force_cache=";


    public void visitUrl(String url) throws InterruptedException {

        goToUrl(url);
        Thread.sleep(5000);

    }

    public void goToMinisite() {
        goToUrl(minisite);
    }

    public void goTOInpage() {
        goToUrl(inpage);
    }

    public boolean isPlayerLoaded() {


        if (returnState() != null) {
            return true;
        } else
            return false;
    }

    public void switchToJWIframe() throws InterruptedException {
        Thread.sleep(5000);
        switchToiFrame("flix-iframe1");
    }

    public void play() throws InterruptedException {
        js.executeScript("jwplayer().play();");
        Thread.sleep(3000);

    }

    public void pause() {
        js.executeScript("jwplayer().pause();");
    }

    public void stop() {
        js.executeScript("jwplayer().stop();");
    }

    public void assertStateIdle() {
        String currentStatus = returnState();
        Assert.assertEquals(("idle"), currentStatus);
    }

    public void assertPlaying() {
        String currentStatus = returnState();
        Assert.assertEquals("playing", currentStatus);
    }

    public void assertpaused() {
        String currentStatus = returnState();
        Assert.assertEquals("paused", currentStatus);
    }

    public String returnState() {
        System.out.println("The status of the  of the jw player is  ****   " + (String) js.executeScript("return jwplayer().getState()"));
        return (String) js.executeScript("return jwplayer().getState()");


    }
}
