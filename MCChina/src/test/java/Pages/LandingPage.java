package Pages;


import cucumber.api.DataTable;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.List;

public class LandingPage extends BasePage {


    public static By addNewProduct = By.linkText("Add new product");
    private By nameField = By.cssSelector("input[name='titleList[]']");
    private By heading = By.cssSelector("input[name='headingList[]']");
    private By subHeading = By.cssSelector("input[name='subheadingList[]']");
    private By description = By.cssSelector("input[name='descriptionList[]']");
    private By language = By.cssSelector("select[name='language[]']");
    private By vendor = By.cssSelector("select[name='manufacturer_id']");
    private By mpn = By.cssSelector("input[name='mpnList[]']");
    private By keyword = By.cssSelector("input[name='keywordList[]']");
    private By batchUploadButton = By.cssSelector("a[href='/batch/index']");
    private By DragandDropField = By.cssSelector("#batch-upload-draganddrop>.top-nav>div>form");
    private By testImage = By.cssSelector("#batch_update_element>section:nth-child(1)>a>div:nth-child(2)");
    private By videoAsset = By.cssSelector("#batch_update_element>section:nth-child(3)>a>div:nth-child(2)");
    private By addLanguageButtonFirstAsset = By.cssSelector("button[asset-code='Test1jpg']");
    private By getAddLanguageButtonSecondAsset = By.cssSelector("button[asset-code='Wildlifewmv']");
    private By languageDropDown = By.cssSelector("select[id='form_language_language']");
    private By assetTitle = By.cssSelector("input[id='form_language_title']");
    private By addLanguageButtonOnPopup = By.cssSelector(".ui-dialog-buttonset>button:nth-child(2)>span");
    private By imageDescription = By.cssSelector("#batch_update_element>section:nth-child(2)>form>fieldset>nav>div:nth-child(6)>textarea");
    private By videoDescription = By.cssSelector("#batch_update_element>section:nth-child(4)>form>fieldset>nav>div:nth-child(6)>textarea");
    private By productSearchField = By.cssSelector("#product_search2");
    private By uploadConfirmation = By.cssSelector(".alert.success_1.success_2");
    private By advancedSearch = By.cssSelector("#click-advanced-search");
    private By customProductSearch = By.cssSelector("a[id='click-custom-product-search']");

    private By saveAndUpload = By.cssSelector("#saveandupload");


    ProductPage productPage = new ProductPage();

    //    Verifying if user is on Landing page

    public void verifyOnLandingPage() {
        goToLandingPage();
    }


    //Add a new product method
    public ProductPage addNewProduct(DataTable table) {

        List<List<String>> data = table.raw();
        click(addNewProduct);
        writetoField(nameField, data.get(1).get(1));
        writetoField(heading, data.get(2).get(1));
        writetoField(subHeading, data.get(3).get(1));
        writetoField(description, data.get(4).get(1));
        writetoField(language, data.get(5).get(1));
        writetoField(vendor, data.get(6).get(1));
        writetoField(mpn, randomString());
        writetoField(keyword, data.get(8).get(1));
        click(addNewProduct);


        return new ProductPage();
    }

    public void clickBatchUploadButton() {

        click(batchUploadButton);
    }

    //Batch upload method
    public void batchUpload() throws InterruptedException, IOException {

//      Start of Batch Upload
        isElementPresent(DragandDropField);
        click(DragandDropField);
        Thread.sleep(5000);
        Runtime.getRuntime().exec("C:\\Assets\\AutoIT\\Fileupload1.exe");
        Thread.sleep(5000);
        click(DragandDropField);
        Runtime.getRuntime().exec("C:\\Assets\\AutoIT\\Fileupload2.exe");
        Thread.sleep(5000);
//      edit the asset 1 added
        click(testImage);
        isElementPresent(addLanguageButtonFirstAsset);
        click(addLanguageButtonFirstAsset);
        writetoField(languageDropDown, "English");
        writetoField(assetTitle, "testimage");
        click(addLanguageButtonOnPopup);
        writetoField(imageDescription, "Test");
        Thread.sleep(3000);

//      Edit the video asset

        click(videoAsset);
        isElementPresent(getAddLanguageButtonSecondAsset);
        click(getAddLanguageButtonSecondAsset);
        writetoField(languageDropDown, "English");
        writetoField(assetTitle, "Test Video");
        click(addLanguageButtonOnPopup);
        writetoField(videoDescription, "Test Video");
        Thread.sleep(3000);

//      Assign to a product
        writetoField(productSearchField, "selenium");
        chooseFromAutoSuggest("Selenium Test (en) ( FlixId: 792871 - MPN: selenium )");
        click(saveAndUpload);
        Thread.sleep(3000);
        System.out.println(findElement(uploadConfirmation).getText());
        verifyFieldContainsText(uploadConfirmation, "Files have been successfully uploaded!");

//      Verify is the uploaded assets exist on product
        productPage.verifyOnProductPage();
//        Verifies the assets uploaded and deletes them
        productPage.deleteImages();
        productPage.deleteVideos();


//      Return to landing page
        goToLandingPage();


    }

    public void clickAdvancedSearch() {

        click(advancedSearch);
    }

    public void clickCustomSearch() {
        click(customProductSearch);
    }



//    public void saveAndUpload() {
//        click(saveAndUpload);
//    }


}