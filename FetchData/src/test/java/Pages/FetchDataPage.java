package Pages;

import org.openqa.selenium.By;


public class FetchDataPage extends BasePage {

    private String searchString;
    private String phNum;


    private By searchTerm = By.xpath("//*[@id='maia-main']/div[2]/div[2]/div[1]/p[1]");
    private By searchField = By.id("lst-ib");
    private By searchButton = By.id("_fZl");

    public void visitUrl(String url) {

        goToUrl(url);

    }

    public String getSearchTerm() {
        return getText(searchTerm);

    }

    public void search() throws InterruptedException {
        System.out.println("Search term is *****************" + getSearchTerm());
        Thread.sleep(3000);
        writetoField(searchField, getSearchTerm());
        Thread.sleep(5000);
        click(searchButton);

    }

    public String searchResults() {
//        I need to look at the website to see what fields to extract
        return getCurrentUrl();
    }

    public void storeData(String url) {
        goToUrl(url + searchResults());
    }

}
