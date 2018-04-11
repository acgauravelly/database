package Pages;


import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Calendar;
import java.util.Date;

public class LoginPage extends BasePage {

    private String loginpage = "https://manage.flix360.com/";
    private By email = By.id("email");
    private By password = By.id("password");
    private By signInButton = By.cssSelector("input[name='sign']");

    public   void confirmOnLoginPage() {
        Assert.assertEquals(getCurrentUrl(), loginpage);
    }

    public void navigateToLoginurl() {
        goToUrl(loginpage);
       confirmOnLoginPage();
    }

    public void login(String emailadd, String pass) {
        findElement(email).sendKeys(emailadd);
        findElement(password).sendKeys(pass);
        click(signInButton);
    }

    public void defaultLogin() throws InterruptedException {
        navigateToLoginurl();
        login("ajay-ecb-whirlpool@flixmedia.tv", "Pass123");
        Thread.sleep(3000);
    }

    public void isLoggedIn() throws InterruptedException {
        if (!isElementPresent(LandingPage.manageLocalisationsButton)) {
            defaultLogin();

        }

    }


}
