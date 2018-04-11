import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;


@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"},
        features = "src/test/resources",
        tags = {"@sis"}
)

public class TestRunner {

    /**  @BeforeClass
    public static void setUp() throws MalformedURLException {
    WebConnector.getInstance().openBrowser("Mozilla");
    }
     **/

/**	@AfterClass
public static void quitBrowser(){
WebConnector.getInstance().quit();
}**/
}