import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by ajay on 30/10/2015.
 */
public class KeywordnaturalTest {

    WebConnector selenium = WebConnector.getInstance();

    @And("I search for products using keyword using natural search")
    public void nat_search() throws InterruptedException {
        selenium.input("searchfield", "Association test");
        selenium.click("searchButton");
//        selenium.waittillelementstoBeClickable("AutoSuggest");
      /**  Thread.sleep(5000);
        try {
            selenium.ChooseFromList("AutoSuggest", "span", "COPYTEST");
        } catch (Exception e) {
            System.out.println("AutoSuggest list not present");
        }**/
        selenium.isElementpresent("searchList");


            WebElement Searchlist = selenium.driver.findElement(By.xpath("//*[@id='gbox_list47']"));
            List<WebElement> options = Searchlist.findElements(By.xpath("//td[@aria-describedby='list47_mpn']"));
            System.out.println(options.size());
            for (int i = 0; i < options.size(); i++) {
                System.out.println(options.get(i).getText());
                Assert.assertTrue("Text is not present", options.get(i).getText().equalsIgnoreCase("COPYTEST"));
            }
            selenium.LandingPage();



    }
}
