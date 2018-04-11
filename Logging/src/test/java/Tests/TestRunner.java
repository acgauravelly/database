package Tests;

import Utils.Util;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.IOException;


@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"},
        features = "src/test/resources",
        tags = {"@AW"}
)

public class TestRunner {
    /**
     * @BeforeClass public static void setUp() throws MalformedURLException {
     * WebConnector.getInstance().openBrowser();
     * }
     **/

    @AfterClass
//    @After
    public static void quitBrowser() throws IOException {
//        WebConnector.proxy.stop();
        Util.quit();

    }


}