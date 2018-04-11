package Tests;

import Pages.BasePage;
import Pages.BatchDownloadPage;
import Util.WebConnector;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

/**
 * Created by ajay on 16/02/2016.
 */
public class Commonutil extends BasePage {


    @After()
    public void tearDown(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()) {
            long failedatTime = currentSystemTime();
            long failureTime = failedatTime - BatchDownloadPage.startTime;

            scenario.write("Failed Scenario: " + scenario.getName() + "--" + failureTime + "  Seconds");
            //             Take a screenshot
            final byte[] screenshot = ((TakesScreenshot) WebConnector.getCurrentDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");

        }

    }


}
