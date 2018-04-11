package Pages;

import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;
import java.util.Timer;


@SuppressWarnings("ALL")
public class ProductPage extends BasePage {

    private By inpageLink = By.cssSelector(".last>a");
    private By inpageStatus = By.cssSelector(".padd-rl");

    private By turnOffDownloadsCheckbox = By.cssSelector("input[name='download']");
    By editButton = By.cssSelector(".bt.btedit.tooltip-trigger-s.overlay-trigger-form>img");
    //    private By downloadButton = By.cssSelector(".bt.btright.tooltip-trigger-s");
    private By addtomyDownloads = By.cssSelector("#add_to_cart");
    private By downloadStatus = By.cssSelector(".alert.success_1");
    private By basicInfoLink = By.cssSelector(".padd>ul>li>a:nth-of-type(1)");
    private By productNameField = By.cssSelector(".detail-list-content-full");
    private By title = By.cssSelector("input[name='titleList[]']");
    public String updatedProductName;

    private By imagesLink = By.cssSelector("span[class='icon-images']");
    private By videosLink = By.cssSelector("span[class='icon-video']");
    private By assetInfo = By.cssSelector(".padd-rl");
    private By assetCarousel = By.cssSelector("div[id='carousel-container']");
    private By imgTag = By.tagName("img");
    private By trTag = By.tagName("tr");
    private By deleteButton = By.cssSelector("img[src='/def/images/delete.png']");
    private By DELETE = By.cssSelector("a[class='button-blue button-right-flush']");
    private By documentsLink = By.cssSelector("span.icon-documents");
    private By addButton = By.cssSelector(".bt.btleft.overlay-trigger-form.tooltip-trigger-s");
    private By addFileButton = By.cssSelector("input[name='asset_file']");
    private By codeField = By.cssSelector("input[name='code']");
    private By featureCodeField = By.cssSelector("input[name='feature_code[]']");
    private By statusDropDown = By.cssSelector("select[id='status']");
    private By typeDropdown = By.cssSelector("select[id='status']");


    private By documentsSection = By.cssSelector("#gbox_jqGrid");
    private By documentNameFromList = By.cssSelector("td[aria-describedby='jqGrid_name']");
    private By assetInfoContainer = By.cssSelector("div[class='details-container']");

    private By featuresLink = By.cssSelector("span[class='icon-features']");
    private By featureTitleField = By.cssSelector("input[name='featuretitleList[]']");
    private By featureContainer = By.cssSelector("section[id='box-content']");
    private String productPage = "http://cn.manage.flix360.com/product/image/id/2402/lang_id/28";

    private By placeHolderImage = By.cssSelector("img[src='/def/images/preview_image_placeholder.jpg']");
    private By imageTitle = By.cssSelector(".media-cycle>div>div.box-column-right>ul>li:nth-child(1)>div>div.detail-list-content");
    private By downloadButton = By.cssSelector("img[src='/def/images/download.png']");
    //            By.className("download_image");
    private By downloadonCart = By.cssSelector("span[class='ui-button-text']");
    private By processStatus = By.xpath("//*[@id='progress']/section/header/h6");
    private By myDownloadsCart = By.xpath("//div[@id='dialog']/h1");
    private By wholeProduct = By.id("download_product");
    private By imagesMenu = By.cssSelector("span[class='icon-images']");
    private By print = By.cssSelector("a[href='/asset/download/id/483/type/image/size/print']");
    private By assetDownloadButton = By.xpath("//*[@id='media-cycle']/div[1]/div[1]/div[2]/a[2]");
    private By downloadUrl = By.id("download_url");
    private By emailWhenProcessed = By.id("closeme");

    public String text = "";
    public int timeSpent = 0;
    public static long startTime;


    //    Verify if the user is on the above product page
    public void verifyOnProductPage() {

        if (!getCurrentUrl().equals(productPage)) {
            navigateToUrl(productPage);
        }
    }

    public void clickImagesMenu() {
        click(imagesMenu);
    }

    public void verifyDownloadisReady() throws InterruptedException {
        isElementDisplayed(myDownloadsCart);
        startTime = currentSystemTime();
        System.out.println("Start time now is   ******   " + startTime + "  Seconds ");
        for (int i = 0; i < 502; i++) {
            if (isElementPresent(downloadUrl)) {
                long currentTime = currentSystemTime();
                int processedTime = (int) (currentTime - startTime);
                System.out.println("Processed in **** " + processedTime);
                if (processedTime > 200 && processedTime < 500) {
                    Assert.fail("Didnt process in 2 mins but took ***** " + processedTime);
                }
                break;
            } else {
                Thread.sleep(1000);
                int waitedTime = (int) (currentSystemTime() - startTime);
                System.out.println("Waited  " + waitedTime + "** for the processing ");
                if (waitedTime > 500) {
                    click(emailWhenProcessed);
                    Assert.fail("Clicked email me after ****" + waitedTime);
                }

            }
        }
    }




//        waitForElementtoBeDisplayed(downloadUrl);
//        if (!isElementPresent(downloadUrl)) {
//            click(emailWhenProcessed);
//        }
//
//        long finishTime = currentSystemTime();
//        int roundedTime = (int) (finishTime - startTime);
//        System.out.println("Time  taken for processing is   --   " + roundedTime + "  Seconds");
//        if (roundedTime > 120 && roundedTime <= 300) {
//            Assert.fail("Did not download in two minutes but took ****  " + roundedTime + "  Seconds");
//        } else if (roundedTime < 120) {
//            System.out.println("Processed in   " + roundedTime + "  Seconds ");
//        }





    //Verifying the newly added product
    public ProductPage verifyAddedProduct() {

        click(inpageLink);
        verifyTextofaField(inpageStatus, "No Inpage found");
        return new ProductPage();
    }


    public void deleteAnyAssetsOnProduct() throws InterruptedException {


//        Deletes if any assets are already present on the product
        verifyOnProductPage();
        clickImagesLink();
        deleteAssetIfPresent(assetCarousel, imgTag);
        clickVideosLink();
        deleteAssetIfPresent(assetCarousel, imgTag);


    }

    public void uncheckturnOffDownloadsOnProductCheckBox() {

        click(editButton);
        switchToIframe();
        uncheckCheckboxifSelected(turnOffDownloadsCheckbox);
        saveAndUpdate();
    }

    public void addToCart() {
        click(downloadButton);
        click(addtomyDownloads);
        verifyFieldContainsText(downloadStatus, "successfully added to downloads cart!");
        goToLandingPage();

    }

    public void downloadProduct() throws InterruptedException {

        click(downloadButton);
        click(wholeProduct);
        Thread.sleep(5000);
        click(downloadonCart);

    }

    public void downloadAsset() throws InterruptedException {
        click(assetDownloadButton);
        click(print);
        Thread.sleep(5000);
    }

    public boolean isDownloaded(String ext) {
        boolean flag = false;

        File dir = new File("C:\\Users\\Ajay\\Desktop\\McDownloads");
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            flag = false;
        }
        for (File eachfile : files) {
            if (eachfile.getName().contains(ext)) {
                flag = true;
            }
        }
        return flag;
    }

    public void cleanFolder() {
        File dir = new File("C:\\Users\\Ajay\\Desktop\\McDownloads");
        if (dir.exists()) {
            for (File file : dir.listFiles()) {
                file.delete();
            }
        }
    }


    public void edit() {
        click(editButton);
    }

    public void clickImagesLink() {
        click(imagesLink);
    }

    public void clickVideosLink() {
        click(videosLink);
    }

    //    Delete images from the images menu
    public void deleteImages() throws InterruptedException {

        click(imagesLink);
        deleteAssetIfPresent(assetCarousel, imgTag);
        verifyTextofaField(assetInfo, "No images found");
    }

    //    Delete videos from the Videos menu
    public void deleteVideos() throws InterruptedException {

        click(videosLink);
        deleteAssetIfPresent(assetCarousel, imgTag);
        verifyTextofaField(assetInfo, "No videos found");
    }

    public void deleteAsset() throws InterruptedException {
        click(deleteButton);
        switchToIframe();
        click(DELETE);
        swithcToDefaultPage();
        Thread.sleep(5000);
    }

    public void deleteDocuments() throws InterruptedException {
        click(documentsLink);
        deleteAssetIfPresent(documentsSection, documentNameFromList);


    }


    public void deleteAssetIfPresent(By locator, By locator1) throws InterruptedException {

        if (isElementPresent(locator)) {
            WebElement assets = findElement(locator);
            List<WebElement> lc = assets.findElements(locator1);
            int assetcount = lc.size();
            if (assetcount != 0) {
                for (int i = 0; i < assetcount; i++)
                    lc.get(i).click();
                deleteAsset();
                Thread.sleep(3000);
            }
        }


        /** while (isElementPresent(locator)) {

         WebElement assets = findElement(locator);
         for (WebElement asset : assets.findElements(locator1)) {
         asset.click();
         deleteAsset();

         }

         }
         **/

    }

    public void clickDeleteButton() {
        click(deleteButton);
    }


    public String editBasicInfo(String productName) throws InterruptedException {


        switchToIframe();
        clearField(title);
        writetoField(title, productName);
        clickCheckboxifNotSelected(turnOffDownloadsCheckbox);
        Thread.sleep(5000);
        saveAndUpdate();
        Thread.sleep(3000);
        swithcToDefaultPage();
        updatedProductName = productName;

        return updatedProductName;

    }

    public void verifyUpdatedProductName() throws InterruptedException {

        verifyFieldContainsText(productNameField, updatedProductName);
        Assert.assertFalse(isElementPresent(downloadButton));

//        Change the product name back as it is associated with other tests
        edit();
        editBasicInfo("Selenium Test");


    }

    public void uploadDocument(DataTable table) {

        List<List<String>> data = table.raw();
        click(documentsLink);
        click(addButton);
        switchToIframe();
        writetoField(title, data.get(1).get(1));
        writetoField(addFileButton, data.get(2).get(1));
        writetoField(codeField, data.get(3).get(1));
        writetoField(statusDropDown, data.get(4).get(1));
        writetoField(typeDropdown, data.get(5).get(1));
        saveAndUpdate();
        swithcToDefaultPage();


    }

    public void verifyUploadedDocument() throws InterruptedException {

        isElementPresent(documentsSection);
        verifyTextofaField(documentNameFromList, "TestDocument");
        click(documentNameFromList);
        isElementPresent(assetInfoContainer);
        deleteAsset();
        verifyTextofaField(assetInfo, "No documents found");
        verifyOnProductPage();

    }

    public void addFeature(DataTable table) {
        List<List<String>> data = table.raw();
        click(featuresLink);
        click(addButton);
        switchToIframe();
        writetoField(title, data.get(1).get(1));
        writetoField(featureTitleField, data.get(2).get(1));
        writetoField(addFileButton, data.get(3).get(1));
        writetoField(featureCodeField, data.get(4).get(1));
        saveAndUpdate();
        swithcToDefaultPage();
    }

    public void verifyAddedFeature() throws InterruptedException {

        isElementPresent(featureContainer);
        deleteAsset();
        verifyTextofaField(assetInfo, "No features found");
        verifyOnProductPage();

    }

    //Uploads an image to images on a product
    public void uploadImage(DataTable table) throws InterruptedException {

        List<List<String>> data = table.raw();
        click(imagesLink);
        deleteAssetIfPresent(assetCarousel, imgTag);
        click(addButton);
        switchToIframe();
        writetoField(title, data.get(1).get(1));
        writetoField(addFileButton, data.get(2).get(1));
        writetoField(codeField, data.get(3).get(1));
        writetoField(statusDropDown, data.get(4).get(1));
        writetoField(typeDropdown, data.get(5).get(1));
        saveAndUpdate();
        swithcToDefaultPage();


    }
//Verifying the above added image

    public void verifyUploadedImage() throws InterruptedException {

        isElementPresent(placeHolderImage);
        verifyTextofaField(imageTitle, "TestImage");
        deleteAsset();
        verifyTextofaField(assetInfo, "No images found");
        verifyOnProductPage();
    }


}
