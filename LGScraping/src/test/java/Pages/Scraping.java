package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

/**
 * Created by ajay on 23/05/2017.
 */
public class Scraping extends BasePage {

    private String LGsite = "http://www.lg.com/us/business/commercial-display/it-products/desktop-monitors";
    private By categoryContainer = By.cssSelector(".module.m08.with-carousel.lists.dot-line.i_1>div>div>div");
    //            By.xpath("//*[@id='content']/div/section[3]/div");
    private By modelNums = By.cssSelector(".model-num>a");
    private By titles = By.cssSelector(".model-name>a");
    private String ipsMonitorPage = "http://www.lg.com/us/business/commercial-display/it-products/desktop-monitors/ips-monitor";
    private String zeroClientPage = "http://www.lg.com/us/business/commercial-display/it-products/desktop-monitors/zero-client";
    private String medicalMonPage = "http://www.lg.com/us/business/commercial-display/it-products/medical-monitors";
    private String fourKmonitorPage = "http://www.lg.com/us/business/commercial-display/it-products/desktop-monitors/4k-uhd-monitor";
    private String ledMonitorPage = "http://www.lg.com/us/business/commercial-display/it-products/desktop-monitors/led-monitor";

    private String hospitalPatientRoom = "http://www.lg.com/us/business/commercial-display/displays-tvs/healthcare/hospital-patient-room";
    private String proCentricSmartDisplays = "http://www.lg.com/us/business/commercial-display/displays-tvs/hospitality/procentric-smart-displays";
    private String proCentricValueDisplays = "http://www.lg.com/us/business/commercial-display/displays-tvs/hospitality/procentric-value-displays";
    private String commercialLiteDisplays = "http://www.lg.com/us/business/commercial-display/displays-tvs/commercial-lite-displays";
    private String hospitalityOledDisplays = "http://www.lg.com/us/business/commercial-display/displays-tvs/hospitality/hospitality-oled-displays";
    private String headEndSystems = "http://www.lg.com/us/business/commercial-display/displays-tvs/hospitality/head-end-systems";
    private String interfaceComtrols = "http://www.lg.com/us/business/commercial-display/displays-tvs/hospitality/interface-controls";
    private String commercialLed = "http://www.lg.com/us/business/commercial-display/displays-tvs/commercial/led-tvs";
    private String superSignTvs = "http://www.lg.com/us/business/commercial-display/displays-tvs/commercial/lg-supersign-tvs";
    private String flatOled="http://www.lg.com/us/business/commercial-display/displays-tvs/lg-oled-displays/flat";
    private String curvedOled="http://www.lg.com/us/business/commercial-display/displays-tvs/lg-oled-displays/curved";

    private By products = By.className("img-link");
    private By viewAllLink = By.linkText("View All");
    private By productTitle = By.cssSelector(".text-block>h1");
    private By mpn = By.cssSelector(".specs>li>h2");

    public void visit_lgSite() {
        goToUrl(LGsite);
    }

    public void visitIpsMonitors() {
        goToUrl(ipsMonitorPage);

    }


    public void visitMedicalMonitor() {
        goToUrl(medicalMonPage);

    }

    public void visitFourKMonitor() {
        goToUrl(fourKmonitorPage);

    }

    public void visitLedMonitors() {
        goToUrl(ledMonitorPage);

    }

    public void visitZeroClient() {
        goToUrl(zeroClientPage);
    }

    public void hospitalPatientRoom() {
        goToUrl(hospitalPatientRoom);
    }

    public void procentricSmart() {
        goToUrl(proCentricSmartDisplays);
    }

    public void procentricValue() {
        goToUrl(proCentricValueDisplays);
    }

    public void commerciallite() {
        goToUrl(commercialLiteDisplays);
    }

    public void hospitalityOled() {
        goToUrl(hospitalityOledDisplays);
    }

    public void headEndSytems() {
        goToUrl(headEndSystems);
    }

    public void interfaceControls() {
        goToUrl(interfaceComtrols);
    }

    public void commercialLed() {
        goToUrl(commercialLed);
    }

    public void supersign() {
        goToUrl(superSignTvs);
    }


    public void categories() throws InterruptedException {
        if (isElementPresent(viewAllLink)) {
            Thread.sleep(5000);
            click(viewAllLink);
            Thread.sleep(5000);
        }
        List<WebElement> cats = findElements(modelNums);
        Thread.sleep(5000);
        List<WebElement> prod_titles = findElements(titles);
        List<WebElement> urls = findElements(products);
        for (int i = 0; i < cats.size(); i++) {
            System.out.println("-----------------------------------------");
            System.out.println(cats.get(i).getText());
            System.out.println(prod_titles.get(i).getText());
            System.out.println(urls.get(i).getAttribute("href"));

        }


    }
}
