package Pages;


import edu.umass.cs.benchlab.har.*;
import edu.umass.cs.benchlab.har.tools.HarFileReader;
import edu.umass.cs.benchlab.har.tools.HarFileWriter;
import org.codehaus.jackson.JsonParseException;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PostLiveQAPage extends BasePage {

    public void navigateTopostLiveUrl(String url) {

        navigateToUrl(url);
    }

    public void readHarFile() {

        String filename = new String("C:\\CaptureNetworkTraffic\\test.har");
        File f = new File(filename);
        HarFileReader r = new HarFileReader();
        HarFileWriter w = new HarFileWriter();

        try

        {
            System.out.println("Reading " + filename);
            HarLog log = r.readHarFile(f);

// Access all elements as objects
            HarBrowser browser = log.getBrowser();
            HarEntries entries = log.getEntries();

// Used for loops
            List<HarPage> pages = log.getPages().getPages();
            List<HarEntry> hentry = entries.getEntries();

            for (HarEntry entry : hentry) {
// for (HarEntry entry : hentry) {{

//                System.out.println("request code: " + entry.getRequest().getMethod()); //Output request type
                System.out.println(" response code: " + entry.getRequest().getUrl()); //Output url of request
                System.out.println(" response code: " + entry.getRequest().getPostData());
                System.out.println("Http version is ****************************************" + entry.getRequest().getHttpVersion());
                System.out.println("Size of the content is ******************************************" + entry.getResponse().getContent().getSize());
                String url = entry.getRequest().getUrl();

                if (url.contains("dev-")||(url.startsWith("https"))) {
                    System.out.println("********************************************Post live urls contain dev urls ********************************************************" + url);
                    Assert.fail();
                }

            }

        } catch (JsonParseException e) {
            e.printStackTrace();
//fail("Parsing error during test");
        } catch (IOException e) {
            e.printStackTrace();
//fail("IO exception during test");
        }
    }

    //**************************** Delete contents of folder************************************************************
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


    //    ************************************************ Rename HAR File************************************************************************************************************************
    public void renameHarfile(String fileName) {
        File dir = new File("C:\\CaptureNetworkTraffic");

        if (dir.isDirectory()) { // make sure it's a directory


            for (final File f : dir.listFiles()) {

                try {

                    File harFile = new File("C:\\CaptureNetworkTraffic\\test.har");
                    if (f.getName().startsWith(fileName)) {
                        f.renameTo(harFile);
                        System.out.println("Renamed to new file");
                    }

                } catch (Exception e) {

                    e.printStackTrace();
                }

            }
        }
    }

}
