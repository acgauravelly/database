import org.openqa.selenium.By;

public class CommonUtil {

    WebConnector selenium = WebConnector.getInstance();

    public void landingPage() {


        By manageContent = By.cssSelector(".blue.selected.leave");
        By naturalSearchField = By.cssSelector("#search_term");
        if (!selenium.isElementPresent(naturalSearchField)) {
            selenium.click(manageContent);
        }


    }




}
