package Tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"},
        features = "src/test/resources",
        tags = {"@All"}
)

public class TestRunner {
    /**
     * @BeforeClass public static void setUp() throws MalformedURLException {
     * WebConnector.getInstance().openBrowser();
     * }


    @AfterClass
    public static void quitBrowser() {
        WebConnector.quit();

    }

     **/
}