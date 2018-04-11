package Pages;
import java.net.MalformedURLException;

import static Utils.WebConnector.getCurrentDriver;
public class BasePage {

    public void openUrl(String url) throws MalformedURLException {
        getCurrentDriver().get(url);
    }

}
