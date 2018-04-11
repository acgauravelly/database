import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by ajay on 16/02/2016.
 */
public class SisTest {

    WebConnector selenium = WebConnector.getInstance();

    @Given("^I am on SIS page$")

    public void Sis_page() throws InterruptedException
    {

    selenium.navigate("SisUrl");
        Thread.sleep(5000);
    }
    @Then("^I should be able to see our SIS content appeared$")

     public void Sis_Content() throws InterruptedException

    {


        WebElement iframecontainer= selenium.driver.findElement(By.xpath(selenium.OR.getProperty("ShopinShopContent")));

        System.out.println("Found container");
//        No of iframes on the retailer page
        List<WebElement>iframes=iframecontainer.findElements(By.tagName("iframe"));
        int size=iframes.size();

        System.out.println("Total iframes"+size);

//        Switching to the iframe found

        selenium.driver.switchTo().frame(iframes.get(0));
        System.out.println("Frame is visible");
//      Listing number of iframes with in the above iframe
        List <WebElement> inlineiframe=selenium.driver.findElements(By.tagName("iframe"));
        System.out.println(inlineiframe.size());
//      Switching to the iframe found
        selenium.driver.switchTo().frame(inlineiframe.get(0));
        System.out.println("iframe switched");
        Thread.sleep(5000);
        List <WebElement> anchortags=selenium.driver.findElements(By.tagName("a"));
        System.out.println("N of anchor tags are "+""+anchortags.size());
        Assert.assertTrue("no of anchor tags do not match",anchortags.size()==40);
        for(int i=0;i<anchortags.size();i++)
        System.out.println(anchortags.get(i).getText());
    }





}