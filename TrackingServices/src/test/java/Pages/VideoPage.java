package Pages;

import Utils.Connector;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Created by ajay on 23/06/2017.
 */
public class VideoPage extends BasePage {
    private By JWThumb = By.className("flix_jw_videoid");

    private JavascriptExecutor js = (JavascriptExecutor) Connector.getCurrentDriver();

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
        click(JWThumb);
        Thread.sleep(3000);
//        switchToiFrame("flix-iframe1");
        switchToiFrame(0);

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

    public void inpageVideoTracking() {
        Tracking("et=mediaload", "U0fdjXhI", "mediaload", "fr", "325717", "6");
        Tracking("et=mediatime", "U0fdjXhI", "mediatime", "fr", "325717", "6");
    }

    public void minisiteVideoTracking(){
        Tracking("et=mediaload", "1EOvqjNU", "mediaload", "fr", "888761", "6");
        Tracking("et=mediatime", "1EOvqjNU", "mediatime", "fr", "888761", "6");
    }

}
