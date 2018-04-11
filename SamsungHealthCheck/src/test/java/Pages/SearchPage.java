package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage {

    private By natSearchField = By.cssSelector("#search_term");
    private By natSearchButton = By.cssSelector(".go");
    private By mpnColumn = By.xpath("//td[@aria-describedby='list47_mpn']");
    private String searchHomePage = "https://dev-manage.flix360.com/samsung/search/";
    private By advSearchButton = By.cssSelector("#click-advanced-search");
    private By searchButtonAdv = By.cssSelector("#searchButton");
    private By mpnField = By.cssSelector("#search-mpn-field");
    private By mpnAutoSuggest = By.xpath("html/body/ul[1]");
    private By eanField = By.cssSelector("#search-ean-field");
    private By eanAutoSuggest = By.xpath("html/body/ul[2]");
    private By keyWordField = By.cssSelector("#search-keyword-field");
    private By keywordAutoSuggest = By.xpath("html/body/ul[3]");
    private By categoryColumn = By.xpath("//td[@aria-describedby='list47_category']");


    public void naturalSearch(String searchString) {
        writetoField(natSearchField, searchString);
        click(natSearchButton);

    }

    public void verifyOnNaturalSearchPage() {
        if (!isElementPresent(natSearchField)) {
            navigateToUrl(searchHomePage);
        }
    }

    public void verifyMpnSearchResults(String searchTerm) throws InterruptedException {
        verifyFieldsContainsText(mpnColumn, searchTerm);
    }

    public void clickAdvSearchButton() {
        if (getCurrentUrl().equalsIgnoreCase(searchHomePage)) {
            click(advSearchButton);
        } else {
            navigateToUrl(searchHomePage);
            click(advSearchButton);
        }
    }


    public void mpnAdvSearch(String mpn) {
        clickAdvSearchButton();
        writetoField(mpnField, mpn);
        chooseFromAutoSuggest(mpnAutoSuggest, mpn);
        click(searchButtonAdv);


    }

    public void eanAdvSearch(String ean) {
        clickAdvSearchButton();
        writetoField(eanField, ean);
        chooseFromAutoSuggest(eanAutoSuggest, ean);
        click(searchButtonAdv);


    }

    public void keyWordAdvSearch(String keyword) {
        clickAdvSearchButton();
        writetoField(keyWordField, keyword);
        chooseFromAutoSuggest(keywordAutoSuggest, keyword);
        click(searchButtonAdv);

    }

    public void firstDisplayedCategory(String expCategory) throws InterruptedException {
        Thread.sleep(3000);
        WebElement results = findElement(AdminPage.searchResultsList);
        List<WebElement> categories = results.findElements(categoryColumn);
        for (WebElement cat : categories) {
            System.out.println("The categories listed are *************" + cat.getText());
        }
        Assert.assertEquals(expCategory, categories.get(0).getText());

    }
}
