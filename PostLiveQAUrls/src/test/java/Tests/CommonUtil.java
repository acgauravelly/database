package Tests;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Calendar;
import java.util.Date;

import static Utils.WebConnector.driver;

public class CommonUtil {

    @After()
    public void tearDown(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()) {
            scenario.write(GetTimeStamp()+"  Failed Scenario: " + scenario.getName());
            //             Take a screenshot
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } else if (!scenario.isFailed()) {
            scenario.write(GetTimeStamp()+"  Passed Scenario: " + scenario.getName());
            //             Take a screenshot
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES) ;
            scenario.embed(screenshot, "image/png" );
        }

    }

    public String GetTimeStamp() {
        Calendar cal = Calendar.getInstance();
        Date time = cal.getTime();
        String timestamp = time.toString();
        System.out.println(timestamp);
        String systime = timestamp.replace(":", "-");
        System.out.println(systime);
        return systime;
    }
}
