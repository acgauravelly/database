package Pages;

import Util.WebConnector;
import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ajay on 06/07/2017.
 */
public class LandingPage extends BasePage {

    public static By manageLocalisationsButton = By.cssSelector("a[href='/ecb/localisation']");
    private String addProductPage = "https://manage.flix360.com/add/product";
    private By productName = By.cssSelector("input[name='titleList[]']");
    private By description = By.cssSelector("input[name='descriptionList[]']");
    private By shortDescription = By.cssSelector("input[name='shortdescriptionList[]']");
    private By languageDropdown = By.cssSelector("select[name='language[]']");
    private By vendorDropdown = By.id("manufacturer_id");
    private By mpnField = By.className("mpn-field");
    private By addNewProductButton = By.linkText("Add new product");




    public void isLoggedin() {

        isElementPresent(manageLocalisationsButton);
    }


    public void addProductPage() throws InterruptedException {

        if (!getCurrentUrl().equals(addProductPage)) {
            navigateToUrl(addProductPage);
        }
    }



    public void addProduct(DataTable table) {

        List<List<String>> data = table.raw();
        writetoField(productName, data.get(1).get(1) + todaysDate());
        writetoField(description, data.get(2).get(1) + todaysDate());
        writetoField(shortDescription, data.get(3).get(1) + todaysDate());
        writetoField(languageDropdown, data.get(4).get(1) + todaysDate());
        writetoField(vendorDropdown, data.get(5).get(1) + todaysDate());
        writetoField(mpnField, data.get(6).get(1) + todaysDate());
        click(addNewProductButton);

    }




}
