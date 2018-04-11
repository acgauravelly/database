package Pages;


import Utils.WebConnector;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;


public class MobilePage extends BasePage {
    private String pagesource;
    private String JSCODE;
    private By tabs = By.cssSelector(".flix-mbl-catHeader.flix-toggle");
    private By inpageContainer =By.id("flix-mbl-page");
//            By.cssSelector("#inpage_container");
    private By featureContainer = By.cssSelector(".flix_selector_feature");
    private By imageGalleryImages = By.cssSelector(".flix-mbl-images.flix-toggle-div");
    private By videoContainer = By.cssSelector(" .flix-mbl-video.flix-toggle-div");
    private By specsContainer = By.cssSelector(".flix-mbl-specs.flix-toggle-div");
    private By docContainer = By.cssSelector(".flix-mbl-docs.flix-toggle-div");
    private By compTableContainer = By.cssSelector(".inpage_selector_comparison");
    private By dartyContent = By.id("content");
    private By dartyTabs = By.className("bloc-title");
    private By hotspotsContainer = By.id("flix_hotspots");
    static List<WebElement> inpageContainers;

    public void openDartyUrl(String brand, String url) throws InterruptedException {
        goToUrl(url);
        System.out.println(brand + "** url **" + url);
        Thread.sleep(5000);
    }

    public void clickLaMarqueVousParle() {
        WebElement element = findElement(dartyContent);
        List<WebElement> elements = element.findElements(dartyTabs);
        for (WebElement tab : elements) {
            System.out.println(tab.getText());
            if (tab.getText().equalsIgnoreCase("La marque vous parle")) {
                tab.click();
            }
        }
    }

    public String pageSource() {
        return WebConnector.getCurrentDriver().getPageSource();
    }


    public void assertPageSourceContains() {
        pagesource = pageSource();
        Assert.assertTrue("Our mobile code is not present", pagesource.contains(JSCODE));

    }

    public void hotspotsAbsent() {
        if (isElementPresent(hotspotsContainer)) {
            Assert.fail("Hotspots are displayed");
        }

//        Assert.assertTrue(isElementDisplayed(hotspotsContainer));
    }

    public void clickTabsOnInpage() throws InterruptedException {

        Thread.sleep(5000);
//        List<WebElement> inpageContainers = findElements(inpageContainer);
//        WebElement container = findElement(inpageContainer);
        inpageContainers = findElements(inpageContainer);
        if (inpageContainers.size() == 2) {
            List<WebElement> options = inpageContainers.get(0).findElements(tabs);
            System.out.println(options.size());
            if (options.size() > 0) {
                for (WebElement option : options) {
                    System.out.println(option.getText());
                }
                System.out.println(inpageContainers.get(1).findElements(tabs).size());
                Assert.assertTrue("Complimentary has Responsive template", inpageContainers.get(1).findElements(tabs).size() != 0);

            }
        } else if (inpageContainers.size() == 1) {
            List<WebElement> options1 = inpageContainers.get(0).findElements(tabs);
            System.out.println(options1.size());
            if (options1.size() > 0) {
                for (WebElement option : options1) {
                    System.out.println(option.getText());
                }

            }
        } else if (inpageContainers.size() == 3) {
//                    System.out.println(options.size());
            System.out.println(inpageContainers.get(0).findElements(tabs).size());
            Assert.assertTrue("Mot not delivered on inpage 1", inpageContainers.get(0).findElements(tabs).size() > 0);
            System.out.println(inpageContainers.get(1).findElements(tabs).size());
            Assert.assertTrue("Mot not delivered on inpage 2", inpageContainers.get(1).findElements(tabs).size() > 0);
            System.out.println(inpageContainers.get(2).findElements(tabs).size());
            Assert.assertTrue("Mot  delivered on inpage 3", inpageContainers.get(2).findElements(tabs).size() == 0);
        } else if(inpageContainers.size()==0) {
            Assert.fail("Inpage not present");
        }

        Thread.sleep(2000);


    }

    public void motWithOneManualInPage() {
        inpageContainers = findElements(inpageContainer);

        if (inpageContainers.size() == 2) {
            List<WebElement> options = inpageContainers.get(0).findElements(tabs);
            System.out.println(options.size());
            if (options.size() > 0) {
                for (WebElement option : options) {
                    System.out.println(option.getText());
                }
                System.out.println(inpageContainers.get(1).findElements(tabs).size());
                Assert.assertTrue("Complimentary has Responsive template", inpageContainers.get(1).findElements(tabs).size() == 0);

            }

        }else if (inpageContainers.size() == 0) {
            Assert.fail("Inpage not rendered");
        }
    }

    public void twoMotAndOneManualInpage() {
        inpageContainers = findElements(inpageContainer);
        if (inpageContainers.size() == 3) {
//                    System.out.println(options.size());
            System.out.println(inpageContainers.get(0).findElements(tabs).size());
            Assert.assertTrue("Mot not delivered on inpage 1", inpageContainers.get(0).findElements(tabs).size() > 0);
            System.out.println(inpageContainers.get(1).findElements(tabs).size());
            Assert.assertTrue("Mot not delivered on inpage 2", inpageContainers.get(1).findElements(tabs).size()  == 0);
            System.out.println(inpageContainers.get(2).findElements(tabs).size());
            Assert.assertTrue("Mot  delivered on inpage 3", inpageContainers.get(2).findElements(tabs).size()> 0);
        } else if (inpageContainers.size() == 0) {
            Assert.fail("Matchmiss on Inpage");
        }

    }


    public void jsErrors() {

        LogEntries logEntries = WebConnector.getCurrentDriver().manage().logs().get(LogType.BROWSER);
//        LogEntries Entries = WebConnector.getCurrentDriver().manage().logs().get(LogType.PERFORMANCE);
        for (LogEntry entry : logEntries) {
            if(entry.getMessage().contains("flix")) {
                System.out.println(entry.getTimestamp() + "" + entry.getLevel() + "" + entry.getMessage());
            }
        }

    }
}
