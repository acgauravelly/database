package Pages;


import edu.umass.cs.benchlab.har.*;
import edu.umass.cs.benchlab.har.tools.HarFileReader;
import edu.umass.cs.benchlab.har.tools.HarFileWriter;
import org.codehaus.jackson.JsonParseException;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("ALL")
public class TrackingPage extends BasePage {

    /**
     * Live urls
     * http://media.flixfacts.com/staging/flixpreview/index.php?mpn=725192-2140&language=en&live=1
     * <p>
     * Video url
     * <p>
     * http://media.flixfacts.com/staging/flixpreview/index.php?mpn=E7354LOK&language=fr&live=1
     * <p>
     * Comp
     * <p>
     * http://media.flixfacts.com/staging/flixpreview/index.php?mpn=000000000000061606&language=fr&live=1&distributor_id=2754
     */

    public String harViewerUrl = "http://toolbox.googleapps.com/apps/har_analyzer/";
    private By browseButton = By.id("fileSelector");
    private By filterBy = By.cssSelector("#searchInput");
    private By searchButton = By.cssSelector("#search");
    private By dataContainer = By.cssSelector("#dataDiv");
    private By paramsContainer = By.cssSelector("#infoTabContent>dl>dd:nth-child(6)");
    private By urlsContainer = By.cssSelector(".request_content");
    private String clampUrl = "http://media.flixfacts.com/staging/flixpreview/index.php?mpn=000000000000064038&language=nz&live=1&distributor_id=6565";
//            "http://media.flixfacts.com/staging/darty/darty-new-dev.php?distributor=6&mpn=725192-2140&language=en";

    private String VIDEOCLAMP = "http://media.flixfacts.com/staging/darty/darty-new-live.php?distributor=2754&mpn=E7354LOK&language=fr";
    private String COMPCLAMP ="http://media.flixfacts.com/staging/flixpreview/index.php?mpn=000000000000061606&language=fr&live=1&distributor_id=2754";
//            " http://media.flixfacts.com/staging/flixpreview/index.php?mpn=000000000000061606&language=fr&live=1&distributor_id=2754";

    private String MINISITEWITHVIDEO = "http://media.flixcar.com/delivery/minisite/show/11676/fr/888761?pn=http%3A//media.flixfacts.com/staging/flixpreview/index.php%3Fmpn%3DE7354LOK%26language%3Dfr%26live%3D1";
    private String MINISITE = "http://media.flixcar.com/delivery/minisite/show/6565/nz/875355?pn=http%3A//media.flixfacts.com/staging/flixpreview/index.php%3Fmpn%3D000000000000064038%26language%3Dnz%26live%3D1%26distributor_id%3D6565";
    private String MINISITEWITHCOMPURL = "http://media.flixcar.com/delivery/minisite/show/3976/us/860040?force_cache=123";
    private String AWURL = "http://media.flixfacts.com/staging/flixpreview/index.php?mpn=S7370/12&language=da&live=1&distributor_id=9157";
    private String hsUrl = "http://media.flixfacts.com/staging/flixpreview/index.php?mpn=E7354LOK&language=fr&live=1";
    private By boseTopReviews = By.xpath("//*[@id='inpage_container']/div[1]/div/h1/div/span[1]/span/span");
    private By page2 = By.xpath("//*[@id='bosegrid']/span/nav/ul[2]/li[4]/span");
    private By next = By.xpath("//*[@id='bosegrid']/span/nav/ul[2]/li[14]/span");
    private By previous = By.xpath("//*[@id='bosegrid']/span/nav/ul[2]/li[1]");
//    private String videoClamp = "http://media.flixfacts.com/staging/darty/darty-new-live.php?distributor=6&mpn=EEC2409BOX&language=fr";
    final String domain="http://media.flixcar.com";

    String paramValue;

    //
    public void visitClampUrl() {
//        cleanFolder();
        goToUrl(clampUrl);
    }

    public void videoClamp() {
        goToUrl(VIDEOCLAMP);
    }

    public void comparisionClamp() {
        goToUrl(COMPCLAMP);
    }

    public void reviewsClicks() throws InterruptedException {
        click(boseTopReviews);
        Thread.sleep(2000);
        click(page2);
        Thread.sleep(2000);
        click(next);
        Thread.sleep(2000);
        click(previous);
    }

    public void visitMinisite() {
        goToUrl(MINISITE);
    }

    public void minisiteWithCopmparisionTable() {
        goToUrl(MINISITEWITHCOMPURL);
    }

    public void visitMinisiteWithVideo() {
        goToUrl(MINISITEWITHVIDEO);
    }

    public void visitAWclamp() {
        goToUrl(AWURL);
    }

//    public void writeLogstoHarfile() {
//
//        writeHArFile();
//    }

    public void playJWPlayer(long time) throws InterruptedException {
        playJwPlayer(time);
    }



    public void visitHSUrl() {
        goToUrl(hsUrl);
    }







   }