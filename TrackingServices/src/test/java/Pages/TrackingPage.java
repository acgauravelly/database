package Pages;

import Utils.Connector;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;

/**
 * Created by ajay on 23/06/2017.
 */
public class TrackingPage extends BasePage {


    private String awURL = "http://demo.flixmedia.tv/integration-demo/microsoft/attach/demo_prod.php?dist_id=9156&display_type=extended&series=ms-pca&lang_id=da&debug=10";
    private String minisite ="http://media.flixcar.com/delivery/minisite/show/6/fr/888761" ;
//            "http://dev-delivery.flix360.com/minisite/show/6/fr/325717";
    private String inpage = "http://media.flixfacts.com/staging/darty/darty-new-dev.php?distributor=6&language=en&mpn=UCORIGIN";
    private By JWThumb = By.className("flix_jw_videoid");

    public void visitService(String service) {

        switch (service) {

            case "aw clamp":
                goToUrl(awURL);
                break;
            case "minisite":
                goToUrl(minisite);
                break;
            case "inpage":
                goToUrl(inpage);
                break;
            default:
                System.out.println("NOt the service listed");
        }
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




    public void deleteFile() {
        File dir = new File("C:\\CaptureNetworkTraffic");

        if (dir.isDirectory()) { // make sure it's a directory


            for (final File f : dir.listFiles()) {
                if (f.getName().startsWith("media") || (f.getName().startsWith("test"))) {
                    f.delete();
                    System.out.println("Renamed to test file");
                }
            }
        }
    }


}
