package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

import static Utils.WebConnector.currentDriver;
@SuppressWarnings("All")
public class BasePage {



//    Open the url

    public void openUrl(String url) {
        Random random= new Random();
     int cache=   random.nextInt(10000);

        currentDriver().navigate().to(url+"?force_cache="+cache);

    }

    //    find element
    public WebElement findElement(By locator) {
        return currentDriver().findElement(locator);
    }

    //    find all elements
    public List findElements(By locator) {
        return currentDriver().findElements(locator);
    }

    //    find if element exists
    public boolean isElementPresent(By locator) {
        return findElements(locator).size() > 0;
    }
//    Mismatches

    public void compareValues(String dev,String prod) {

        List<String> devValues = Arrays.asList(dev);
        List<String> liveValues = Arrays.asList(prod);
        String message = "";
        LinkedHashMap<String, String> fieldMismatches = new LinkedHashMap<>();
        for (int i = 0; i < devValues.size(); i++) {
            if (!liveValues.get(i).equals(devValues.get(i))) {
                fieldMismatches.put(devValues.get(i), liveValues.get(i));
                System.out.println("Expected value is " + liveValues.get(i) + " BUT found " + devValues.get(i));
            } else {
                System.out.println("** Expected value is: " + liveValues.get(i) + " AND found: " + devValues.get(i));
                Assert.assertTrue(devValues.get(i).equalsIgnoreCase(liveValues.get(i)));
            }
        }
        if (!fieldMismatches.isEmpty()) {
            for (Map.Entry<String, String> entry : fieldMismatches.entrySet()) {
                message = message + "\n" + " " + "** Expected value is: " + entry.getValue() + " but found: " + entry.getKey();
            }
            Assert.assertTrue(message, fieldMismatches.isEmpty());
        }
    }

    public String getPageSource(){
        return currentDriver().getPageSource();
    }

    public String getCurrUrl(){
        return currentDriver().getCurrentUrl();
    }

}
