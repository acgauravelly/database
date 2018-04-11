package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import static Utils.WebConnector.getCurrentDriver;


public class LoginPage extends BasePage {

    private By email = By.id("email");
    private By password = By.id("password");
    private By signInButton = By.xpath("//input[@name='sign']");
    private By iframePopUp = By.cssSelector("#fancybox-content");
    private By forgotYourPasswordLink = By.cssSelector("#link-forgotten-password");
    private By forgottenPasswordButton = By.cssSelector("input[value='Forgotten Password']");
    private By confirmationMessage = By.cssSelector(".info");
    private By passwordResendConfirmation = By.cssSelector("header[class='box-header']");
    final String passwordResendConfirmationMessage = "Your Password is on it's way...";
    private By closeButton = By.cssSelector("input[name='close']");
    final String gmailUrl = "https://gmail.com";
    private By gmailId = By.cssSelector("#identifierId");
    private By nextButton = By.cssSelector(".RveJvd.snByac");
    private By gmailPassword = By.cssSelector("input[name='password']");
    //    private By gmailSignInButton = By.cssSelector("#signIn");
    private By resetPasswordLinkinGmail = By.linkText("Reset Password");
    //            By.cssSelector(".adn.ads>div:nth-child(2)>div:nth-child(7)>div>div>div>div:nth-child(2)>div>div:nth-child(3)>a");
    private By confirmPassword = By.cssSelector("input[id='confirmPassword']");
    private By resetPasswordButton = By.cssSelector("input[value='Reset Password']");


    //Navigates to Login page
    public void navigateToLoginPage() throws InterruptedException {

        if (isLoggedIn()) {
            logOff();
            getCurrentDriver().get("http://http://cn.manage.flix360.com");
            Thread.sleep(3000);
        } else {
            getCurrentDriver().get("http://cn.manage.flix360.com");
            Thread.sleep(3000);
        }
        Assert.assertEquals("Login", getPageTitle());


    }

    //Does a Login with default credentials
    public void defaultLogin() throws InterruptedException {

        getCurrentDriver().get("http://cn.manage.flix360.com");
        Thread.sleep(5000);
        writetoField(email, "tech@flixmedia.tv");
        writetoField(password, "testtest");
        click(signInButton);
        Thread.sleep(5000);


    }

    //    !isLoggedIn()&&
    public void verifyLoggedin() throws InterruptedException {
        if (isElementPresent(iframePopUp)) {
            goToLandingPage();
            isElementPresent(LandingPage.addNewProduct);
        } else {
            if (!isLoggedIn()) {
                defaultLogin();
                isElementPresent(LandingPage.addNewProduct);
            }
        }


    }

    public void clickForgotPassword() throws InterruptedException {
        click(forgotYourPasswordLink);
        Thread.sleep(3000);
    }

    public void requestNewPassword() throws InterruptedException {

        writetoField(email, "ajay@flixmedia.tv");
        click(forgottenPasswordButton);
        isElementPresent(confirmationMessage);
        verifyTextofaField(passwordResendConfirmation, passwordResendConfirmationMessage);
        click(closeButton);
        Thread.sleep(5000);

    }

    public void resetPasswordFromGmail() throws InterruptedException {
        navigateToUrl(gmailUrl);
        writetoField(gmailId, "ajay@flixmedia.tv");
        click(nextButton);
        writetoField(gmailPassword, "shalinimay27");
        click(nextButton);
        readUnreadEmails();
        click(resetPasswordLinkinGmail);
        switchTabsinBrowser();
        writetoField(password, "Pass123");
        writetoField(confirmPassword, "Pass123");
        click(resetPasswordButton);
//        closeBrowser();


    }

    public void verifyNewPassword() throws InterruptedException {
        navigateToUrl("http://dev-manage.flix360.com");
        defaultLogin();
        verifyLoggedin();
    }


}
