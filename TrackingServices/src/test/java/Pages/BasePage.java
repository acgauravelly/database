package Pages;

import edu.umass.cs.benchlab.har.*;
import edu.umass.cs.benchlab.har.tools.HarFileReader;
import edu.umass.cs.benchlab.har.tools.HarFileWriter;
import org.codehaus.jackson.JsonParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Utils.Connector.getCurrentDriver;


import static junit.framework.TestCase.fail;


public class BasePage {

    String paramValue;

    public void goToUrl(String url) {
        getCurrentDriver().get(url);

    }

    public WebElement findElement(By locator) {
        return getCurrentDriver().findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return getCurrentDriver().findElements(locator);
    }

    public void click(By locator) {
        findElement(locator).click();

    }

    public void cleanFolder() {
        File file = new File("C:\\CaptureNetworkTraffic");
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }
    }

    public void rename() {
        File dir = new File("C:\\CaptureNetworkTraffic");

        if (dir.isDirectory()) { // make sure it's a directory


            for (final File f : dir.listFiles()) {

                try {

                    File newfile = new File("C:\\CaptureNetworkTraffic\\test.har");
                    if (f.getName().startsWith("media") || (f.getName().startsWith("dev")) || (f.getName().startsWith("demo"))) {
                        f.renameTo(newfile);
                        System.out.println("Renamed to test file");
                    }
                } catch (Exception e) {

                    e.printStackTrace();
                }

            }
        }

    }

    public boolean isFileExists() {
        File dir = new File("C:\\CaptureNetworkTraffic");

        return dir.listFiles() != null;
    }


    public void Tracking(String urlContains, String ed, String et, String lang, String pID, String dist) {

        if (fileByNameExists()) {
            String filename = new String("C:\\CaptureNetworkTraffic\\test.har");
            File f = new File(filename);
            HarFileReader r = new HarFileReader();
            HarFileWriter w = new HarFileWriter();

            try {
                // All violations of the specification generate warnings
                List<HarWarning> warnings = new ArrayList<HarWarning>();
                HarLog l = r.readHarFile(f, warnings);
                for (HarWarning wrn : warnings)
                    System.out.println("File:" + filename + " - Warning:" + wrn);
                System.out.println("Reading " + filename);
                HarLog log = r.readHarFile(f);


// Access all elements as objects
                HarBrowser browser = log.getBrowser();
                HarEntries entries = log.getEntries();

// Used for loops
                List<HarPage> pages = log.getPages().getPages();
                List<HarEntry> hentry = entries.getEntries();
                Boolean found = false;
                List<String> traUrls = new ArrayList<>();

                for (HarEntry entry : hentry) {

                    String url = entry.getRequest().getUrl();
//                System.out.println(entry.getRequest().getUrl());
                    if (url.contains(urlContains) && !url.contains("et=time")) {
                        traUrls.add(url);
                        found = true;
                        System.out.println("***" + url);
                        System.out.println(entry.getRequest().getHeaders());
                        for (String eachurl : traUrls) {
                            System.out.println("Url from the new ArrayList is " + eachurl);
                            if (eachurl.contains("mediaload")) {
                                List<HarQueryParam> params = entry.getRequest().getQueryString().getQueryParams();
                                for (HarQueryParam param : params) {
                                    System.out.println(param.getName());
                                    if (param.getName().equalsIgnoreCase("ed")) {
                                        paramValue = param.getValue();
                                        System.out.println("Value of the " + "**" + param.getName().toUpperCase() + "**" + "requested is **************  " + param.getValue());
                                        Assert.assertEquals(ed, paramValue);
                                        Assert.assertTrue("Value is blank for" + param.getName(), !paramValue.isEmpty());
                                    } else if (param.getName().equalsIgnoreCase("gvid")) {
                                        paramValue = param.getValue();
                                        System.out.println("Value of the" + "**" + param.getName().toUpperCase() + "**" + " requested is **************  " + param.getValue());
                                        Assert.assertTrue("Value is blank for" + param.getName(), !paramValue.isEmpty());
                                        Assert.assertTrue("Gvid is different", paramValue.contains("flix"));
                                    } else if (param.getName().equalsIgnoreCase("et")) {
                                        paramValue = param.getValue();
                                        System.out.println("Value of the " + "**" + param.getName().toUpperCase() + "**" + " requested is **************" + param.getValue());
                                        Assert.assertTrue("Value is blank for" + param.getName(), !paramValue.isEmpty());
                                        Assert.assertEquals(et, paramValue);
                                    } else if (param.getName().equalsIgnoreCase("l")) {
                                        paramValue = param.getValue();
                                        System.out.println("Value of the " + "**" + param.getName().toUpperCase() + "**" + " requested is **************  " + param.getValue());
                                        Assert.assertTrue("Value is blank for" + param.getName(), !paramValue.isEmpty());
                                        Assert.assertEquals(lang, paramValue);
                                    } else if (param.getName().equalsIgnoreCase("p")) {
                                        paramValue = param.getValue();
                                        System.out.println("Value of the " + "**" + param.getName().toUpperCase() + "**" + " requested is **************  " + param.getValue());
                                        Assert.assertTrue("Value is blank for" + param.getName(), !paramValue.isEmpty());
                                        Assert.assertEquals(pID, paramValue);
                                    } else if (param.getName().equalsIgnoreCase("d")) {
                                        paramValue = param.getValue();
                                        System.out.println("Value of the " + "**" + param.getName().toUpperCase() + "**" + " requested is **************" + param.getValue());
                                        Assert.assertTrue("Value is blank for" + param.getName(), !paramValue.isEmpty());
                                        Assert.assertEquals(dist, paramValue);
                                    }
                                }
                            } else if (eachurl.contains("mediatime")) {
                                List<HarQueryParam> params = entry.getRequest().getQueryString().getQueryParams();
                                for (HarQueryParam param : params) {
                                    System.out.println(param.getName());
                                    if (param.getName().equalsIgnoreCase("ed")) {
                                        paramValue = param.getValue();
                                        System.out.println("Value of the " + "**" + param.getName().toUpperCase() + "**" + "requested is **************  " + param.getValue());
                                        Assert.assertEquals(ed, paramValue);
                                        Assert.assertTrue("Value is blank for" + param.getName(), !paramValue.isEmpty());
                                    } else if (param.getName().equalsIgnoreCase("gvid")) {
                                        paramValue = param.getValue();
                                        System.out.println("Value of the" + "**" + param.getName().toUpperCase() + "**" + " requested is **************  " + param.getValue());
                                        Assert.assertTrue("Value is blank for" + param.getName(), !paramValue.isEmpty());
                                        Assert.assertTrue("Gvid is different", paramValue.contains("flix"));
                                    } else if (param.getName().equalsIgnoreCase("et")) {
                                        paramValue = param.getValue();
                                        System.out.println("Value of the " + "**" + param.getName().toUpperCase() + "**" + " requested is **************" + param.getValue());
                                        Assert.assertTrue("Value is blank for" + param.getName(), !paramValue.isEmpty());
                                        Assert.assertEquals(et, paramValue);
                                    } else if (param.getName().equalsIgnoreCase("l")) {
                                        paramValue = param.getValue();
                                        System.out.println("Value of the " + "**" + param.getName().toUpperCase() + "**" + " requested is **************  " + param.getValue());
                                        Assert.assertTrue("Value is blank for" + param.getName(), !paramValue.isEmpty());
                                        Assert.assertEquals(lang, paramValue);
                                    } else if (param.getName().equalsIgnoreCase("p")) {
                                        paramValue = param.getValue();
                                        System.out.println("Value of the " + "**" + param.getName().toUpperCase() + "**" + " requested is **************  " + param.getValue());
                                        Assert.assertTrue("Value is blank for" + param.getName(), !paramValue.isEmpty());
                                        Assert.assertEquals(pID, paramValue);
                                    } else if (param.getName().equalsIgnoreCase("d")) {
                                        paramValue = param.getValue();
                                        System.out.println("Value of the " + "**" + param.getName().toUpperCase() + "**" + " requested is **************" + param.getValue());
                                        Assert.assertTrue("Value is blank for" + param.getName(), !paramValue.isEmpty());
                                        Assert.assertEquals(dist, paramValue);
                                    } else if (param.getName().equalsIgnoreCase("vtime")) {
                                        paramValue = param.getValue();
                                        System.out.println("Value of the " + "**" + param.getName().toUpperCase() + "**" + " requested is **************" + param.getValue());
                                        Assert.assertTrue("Value is blank for" + param.getName(), !paramValue.isEmpty());
                                        Assert.assertEquals(dist, paramValue);
                                    }
                                }

                            }
                            break;
                        }

                    }

                }
                if (!found) {
                    Assert.fail(urlContains + ed + " *** Tracking is not present");
                }


            } catch (JsonParseException e) {
                e.printStackTrace();
                fail("Parsing error during test");
            } catch (IOException e) {
                e.printStackTrace();
                fail("IO exception during test");


            }
        } else {
            Assert.fail(" Test Har file does not exist");
        }
    }

    public boolean fileByNameExists() {
        File file = new File("C:\\CaptureNetworkTraffic\\test.har");
        if (file.exists()) {
            return true;
        } else
            return false;
    }

    public void additionalFeaturesTracking(String urlContains, String et, String lang, String pID, String dist) {


        if (fileByNameExists()) {
            String filename = new String("C:\\CaptureNetworkTraffic\\test.har");
            File f = new File(filename);
            HarFileReader r = new HarFileReader();
            HarFileWriter w = new HarFileWriter();

            try {
                // All violations of the specification generate warnings
                List<HarWarning> warnings = new ArrayList<HarWarning>();
                HarLog l = r.readHarFile(f, warnings);
                for (HarWarning wrn : warnings)
                    System.out.println("File:" + filename + " - Warning:" + wrn);
                System.out.println("Reading " + filename);
                HarLog log = r.readHarFile(f);


// Access all elements as objects
                HarBrowser browser = log.getBrowser();
                HarEntries entries = log.getEntries();

// Used for loops
                List<HarPage> pages = log.getPages().getPages();
                List<HarEntry> hentry = entries.getEntries();
                Boolean found = false;
                for (HarEntry entry : hentry) {

                    String url = entry.getRequest().getUrl();
//                System.out.println(entry.getRequest().getUrl());
                    if (url.contains(urlContains) && !url.contains("et=time")) {
                        found = true;
                        System.out.println("***" + url);
                        System.out.println(entry.getRequest().getHeaders());
                        List<HarQueryParam> params = entry.getRequest().getQueryString().getQueryParams();
                        for (HarQueryParam param : params) {
                            System.out.println(param.getName());

                            if (param.getName().equalsIgnoreCase("gvid")) {
                                paramValue = param.getValue();
                                System.out.println("Value of the" + param.getName() + " requested is **************  " + param.getValue());
                                Assert.assertTrue("Value is blank for" + param.getName(), !paramValue.isEmpty());
//                            Assert.assertTrue("Gvid is different", paramValue.contains("flix58"));
                            } else if (param.getName().equalsIgnoreCase("et")) {
                                paramValue = param.getValue();
                                System.out.println("Value of the " + param.getName() + " requested is **************" + param.getValue());
                                Assert.assertTrue("Value is blank for" + param.getName(), !paramValue.isEmpty());
                                Assert.assertEquals(et, paramValue);
                            } else if (param.getName().equalsIgnoreCase("l")) {
                                paramValue = param.getValue();
                                System.out.println("Value of the " + param.getName() + " requested is **************  " + param.getValue());
                                Assert.assertTrue("Value is blank for" + param.getName(), !paramValue.isEmpty());
//                            Assert.assertEquals(lang, paramValue);
                            } else if (param.getName().equalsIgnoreCase("p")) {
                                paramValue = param.getValue();
                                System.out.println("Value of the " + param.getName() + " requested is **************  " + param.getValue());
                                Assert.assertTrue("Value is blank for" + param.getName(), !paramValue.isEmpty());
//                            Assert.assertEquals(pID, paramValue);
                            } else if (param.getName().equalsIgnoreCase("d")) {
                                paramValue = param.getValue();
                                System.out.println("Value of the " + param.getName() + " requested is **************" + param.getValue());
                                Assert.assertTrue("Value is blank for" + param.getName(), !paramValue.isEmpty());
//                            Assert.assertEquals(dist, paramValue);
                            }

                        }
                        break;
                    }

                }
                if (!found) {
                    Assert.fail(urlContains + et + " *** Tracking is not present");
                }


            } catch (JsonParseException e) {
                e.printStackTrace();
//fail("Parsing error during test");
            } catch (IOException e) {
                e.printStackTrace();
//fail("IO exception during test");


            }

        } else {
            Assert.fail(" Test Har file does not exist");
        }
    }

    public void switchToiFrame(String frameId) {
        waitForIframe(frameId);
        getCurrentDriver().switchTo().frame(frameId);

    }

    public void waitForCondition(String title) {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), 120);
        wait.until(ExpectedConditions.titleIs(title));
    }

    public void waitForIframe(int frameId) {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), 120);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
    }

    public void waitForIframe(String frameId) {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), 120);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
    }

    public void switchToiFrame(int frameId) {
        waitForIframe(frameId);
        getCurrentDriver().switchTo().frame(frameId);

    }


}
