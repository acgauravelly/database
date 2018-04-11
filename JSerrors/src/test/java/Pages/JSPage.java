package Pages;

import Utils.WebConnector;
import org.junit.Assert;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.net.MalformedURLException;

public class JSPage extends BasePage {

    public void flixUrl(String url) {
        goToUrl(url);
    }

    public void getJSErrors() throws MalformedURLException {

        LogEntries logEntries = WebConnector.getCurrentDriver().manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(entry);
            if (entry.getMessage().contains("flix")) {
                String entryLevel = entry.getLevel().toString();
                if (entryLevel.contains("SEVERE") && entry.getMessage().contains(".js")) {
                    System.out.println(entry.getTimestamp() + "" + entry.getLevel() + "" + entry.getMessage());
                    Assert.fail("Contains js errors");
                }
            }
        }
//        Assert.assertTrue(logEntries.getAll().isEmpty());

    }

    public void performanceLog() throws MalformedURLException {


        LogEntries logEntries = WebConnector.getCurrentDriver().manage().logs().get(LogType.PERFORMANCE);
        for (LogEntry entry : logEntries) {
            System.out.println(entry.getMessage());
        }
    }

}
