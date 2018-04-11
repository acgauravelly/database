package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by ajay on 30/05/2017.
 */
public class LG extends BasePage {
    private By viewAllLink = By.linkText("View All");
    private By modelNums = By.cssSelector(".model-num>a");
    private By titles = By.cssSelector(".model-name>a");
    private By products = By.className("img-link");

    /**
     * | http://www.lg.com/us/business/commercial-display/displays-tvs/commercial      |
     * | http://www.lg.com/us/business/commercial-display/displays-tvs/digital-signage |
     * | http://www.lg.com/us/business/commercial-display/displays-tvs/video-walls     |
     * | http://www.lg.com/us/business/commercial-display/displays-tvs/outdoor         |
     * | http://www.lg.com/us/business/commercial-display/displays-tvs/accessories     |
     * | http://www.lg.com/us/business/commercial-display/it-products/desktop-monitors |
     * | http://www.lg.com/us/business/commercial-display/it-products/digital-storage  |
     */

    private By learnMoreButton = By.className("btn");
//            By.className("btn");

    public void visitUrl(String url) {
        switch (url) {

            case "commericial":
                goToUrl("http://www.lg.com/us/business/commercial-display/displays-tvs/commercial");
                break;
            case "digital-signage":
                goToUrl("http://www.lg.com/us/business/commercial-display/displays-tvs/digital-signage");
                break;
            case "video-walls":
                goToUrl("http://www.lg.com/us/business/commercial-display/displays-tvs/video-walls");
                break;
            case "outdoor":
                goToUrl("http://www.lg.com/us/business/commercial-display/displays-tvs/outdoor");
                break;
            case "accessories":
                goToUrl("http://www.lg.com/us/business/commercial-display/displays-tvs/accessories");
                break;
            case "desktop-monitors":
                goToUrl("http://www.lg.com/us/business/commercial-display/it-products/desktop-monitors");
                break;
            case "digital-storage":
                goToUrl("http://www.lg.com/us/business/commercial-display/it-products/digital-storage");
                break;
            default:
                System.out.println("No matching category");

        }
    }

    public void getInfo() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> buttons = findElements(learnMoreButton);
        System.out.println(buttons.size());
        if (buttons.size() > 0) {
            for (int i = 0; i < buttons.size(); i++) {
                Thread.sleep(5000);
                buttons = findElements(learnMoreButton);
                moveToElement(buttons.get(i));
                waitForElement(buttons.get(i));
                buttons.get(i).click();
                Thread.sleep(5000);
                System.out.println(getCurrentUrl());
                if (isElementPresent(viewAllLink)) {
                    Thread.sleep(2000);
                    click(viewAllLink);
                    Thread.sleep(2000);
                }
                List<WebElement> cats = findElements(modelNums);
                if (cats.size() > 0) {
                    for (WebElement eachcat : cats) {
                        System.out.println(eachcat.getText());
                    }
                    Thread.sleep(2000);
                    List<WebElement> prod_titles = findElements(titles);
                    for (WebElement prod : prod_titles) {
                        System.out.println(prod.getText());
                    }
                    List<WebElement> urls = findElements(products);
                    for (WebElement eachUrl : urls) {
                        System.out.println(eachUrl.getAttribute("href"));
                    }
                } else {
                    System.out.println("No products available");
//                    back();
                }
                back();
                Thread.sleep(15000);

            }

        } else {
            System.out.println("No learn more buttons");
        }
    }
}
