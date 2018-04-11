package Pages;


import org.junit.Assert;
import org.openqa.selenium.By;

public class AllServicesPage extends BasePage {

    private By adminFlix360LoginForm = By.cssSelector("#login_form>form");
    private By AWButton = By.id("flix-attach-off16");
    private By comparisionTable = By.className("flix-mscomp-container");

    public void navigateToServicesUrl(String urlName) {

        switch (urlName) {

            case "darty":
                navigateToUrl("http://www.darty.com/nav/achat/informatique/ordinateur_portable/portable_hybride/microsoft_sp4_i5_128go.html");
                break;

            case "aw":
                navigateToUrl("http://www.lazada.co.id/apple-macbook-air-mmgf2-core-i5-27-31ghz-8gb-128gb-133-14123026.html?ff=1");
                break;

            case "inlineSIS":
                navigateToUrl("http://www.ebuyer.com/seagate-product-selector/");
                break;
            case "samsungHub":
                navigateToUrl("http://manage.flix360.com/samsung");
                break;
            case "flix360":
                navigateToUrl("http://www.flix360.com/");
                break;

            case "flixWebsite":
                navigateToUrl("http://www.flixmedia.eu");
                break;
            case "signUpPortal":
                navigateToUrl("http://signup.flixsyndication.net");
                break;
            case "hpEnrolment":
                navigateToUrl("http://hpsis.flixsyndication.net");
                break;
            case "adminFlix360":
                navigateToUrl("http://admin.flix360.com");
                break;
            case "csWebsite":
                navigateToUrl("http://www.flixmedia.tv/cs/services");
                break;
            case "csPortal":
                navigateToUrl("http://creative.flixmedia.tv");
                break;
            case "feedUrls":
                navigateToUrl("http://feed.flixsyndication.net/api/feed/?distributor_id=370&language=us&format=xml");
                break;
            case "sandbox":
                navigateToUrl("http://sandbox.flixsyndication.net");
                break;
            case "flixfacts":
                navigateToUrl("http://flixfacts.co.uk");
                break;
            case "sis":
                navigateToUrl("http://alliancetechpartners.com/hp-new-products/workstation-family/");
                break;
            case "microsoftFlix360Portal":
                navigateToUrl("http://manage.flix360.com/microsoft");
                break;
            default:
                Assert.fail("Url doesnt match any of the url in switch");

        }


    }

    public void adminFlix360Check() {
        isElementDisplayed(adminFlix360LoginForm);

    }

    public void isAWDisplayed() {
        isElementDisplayed(AWButton);
    }

    public void isComparisionTableisDisplayed() {
        isElementDisplayed(comparisionTable);
    }
}
