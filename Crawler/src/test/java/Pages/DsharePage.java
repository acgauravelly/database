package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by ajay on 21/08/2017.
 */
public class DsharePage extends BasePage {

    private By username = By.id("Username");
    private By password = By.id("Password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By loggedinUser = By.id("dLabel");
    private By brandsLink = By.cssSelector(".caption.bg-primary>h2");
    private String brandsPage = "http://www.digishare.net/RBECOMMDAM/ClientCategory/ClientCategoryIndex?parentId=MQ%3D%3D&langMapID=MQ%3D%3D";
    //    Products clicks
    private By productList = By.className("product-list");
    private By productDescription = By.className("description");


    public void navigateToRetailer(String url) {
        goToUrl(url);
        Assert.assertTrue(getCurrentUrl().equals(url));
    }

    public void login() {
        writetoField(username, "luc@flixmedia.tv");
        writetoField(password, "Testing$12");
        click(loginButton);
        Assert.assertTrue(getText(loggedinUser).equalsIgnoreCase("Luc"));

    }

    public void brandPage() {
        if (!getCurrentUrl().equals(brandsPage)) {
            navigateToUrl(brandsPage);
            Assert.assertTrue(getCurrentUrl().equals(brandsPage));
        }
    }


    public void scrape() throws InterruptedException {
        List<WebElement> brands = findElement(productList).findElements(By.tagName("a"));
        System.out.println("Total brands   are " + brands.size());
        for (int b = 0; b < brands.size(); b++) {
            System.out.println("The BRAND NAME is *****" + brands.get(b).getText());
            brands.get(b).click();

            List<WebElement> categories = findElement(productList).findElements(By.tagName("a"));
            System.out.println("Total categories   are " + brands.size());
            for (int c = 0; c < categories.size(); c++) {
                System.out.println("The CATEGORY NAME is *****" + categories.get(c).getText());
                categories.get(c).click();
                if (!isElementPresent(productDescription)) {
                    List<WebElement> subcategories = findElement(productList).findElements(By.tagName("a"));
                    System.out.println("Total subcategories   are " + subcategories.size());
                    for (int d = 0; d < subcategories.size(); d++) {
                        System.out.println("The SUBCATEGORY NAME is *****" + subcategories.get(d).getText());
                        subcategories.get(d).click();
                        if (!isElementPresent(productDescription)) {
                            List<WebElement> subcats = findElement(productList).findElements(By.tagName("a"));
                            System.out.println("Total subcats   are " + subcategories.size());
                            for (int e = 0; e < subcats.size(); e++) {
                                System.out.println("The SUBCATS NAME is *****" + subcats.get(e).getText());
                                subcats.get(e).click();
                                if (isElementPresent(productDescription)) {

                                    List<WebElement> decp = findElement(productDescription).findElements(By.tagName("dd"));
                                    for (WebElement eachdescp : decp) {
                                        System.out.println(eachdescp.getText());

                                    }


                                }

                                goBack();
                                subcats = findElement(productList).findElements(By.tagName("a"));

                            }

                        }
                        else{
                            List<WebElement> decp = findElement(productDescription).findElements(By.tagName("dd"));
                            for (WebElement eachdescp : decp) {
                                System.out.println(eachdescp.getText());

                            }
                        }
                        goBack();
                        subcategories = findElement(productList).findElements(By.tagName("a"));
                    }

                }else{
                    List<WebElement> decp = findElement(productDescription).findElements(By.tagName("dd"));
                    for (WebElement eachdescp : decp) {
                        System.out.println(eachdescp.getText());

                    }
                }
                goBack();
                categories = findElement(productList).findElements(By.tagName("a"));
            }
            goBack();
            brands = findElement(productList).findElements(By.tagName("a"));
        }
    }
}