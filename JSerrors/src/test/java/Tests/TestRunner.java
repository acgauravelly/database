package Tests;

import Utils.WebConnector;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;


@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"},
        features = "src/test/resources",
        tags = {"@jserror"}
)


public class TestRunner {

/**  @BeforeClass public static void setUp() throws MalformedURLException {
WebConnector.getInstance().openBrowser("Mozilla");
}

} **/

 @AfterClass
 public static void quitBrowser() throws MalformedURLException {
 WebConnector.quit();
 }

}