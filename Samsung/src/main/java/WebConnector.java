import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
public class WebConnector {
    WebDriver driver = null;
    static WebConnector w = null;
    public By save_and_Update = By.cssSelector(".button-blue.button-right-flush");
    public By downloadButton=By.cssSelector("bt.btright.tooltip-trigger-s");






    public void openBrowser(String browser) {

        if (browser.equalsIgnoreCase("Mozilla")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Chrome\\chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Chrome\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void navigate(String url) {

        driver.get(url);

    }

    public WebElement findElement(By locator) {
        waitForElement(locator);
        WebElement element = driver.findElement(locator);
        return element;
    }

    public int findElements(By locator) {

        return driver.findElements(locator).size();

    }

    public void click(By locator) {

//        driver.findElement(locator).click();
        findElement(locator).click();
    }

    public void writeToaField(By locator, String text) {

//        driver.findElement(locator).sendKeys(text);
        waitForElement(locator);
        findElement(locator).sendKeys(text);
    }

    public void select(WebElement element, String value) {

        Select select = new Select(element);
        select.selectByValue(value);
    }

    public boolean isElementPresent(By locator) {

        int count = findElements(locator);
        if (count == 0) {
            return false;
        } else
            return true;
    }

    public boolean isElementDisplayed(By locator) {
        if (findElement(locator).isDisplayed()) {
            return true;
        } else
            return false;
    }

    public boolean assertTrueCondition(String message, boolean condition) {
        Assert.assertTrue(message, condition);
        return true;

    }

    public void waitForElement(By locator) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public static WebConnector getInstance() {
        if (w == null)
            w = new WebConnector();
        return w;

    }

    public void verifyTextofaField(By locator, String text) {

        Assert.assertTrue(findElement(locator).getText().equalsIgnoreCase(text));
        System.out.println(findElement(locator).getText());
    }

    public String currentUrl() {

        return driver.getCurrentUrl();
    }

    public void switchToiFrame() {
        driver.switchTo().frame(0);
    }

    public void saveAndUpdate() {
        waitForElement(save_and_Update);
        click(save_and_Update);

    }

    public void uncheckCheckboxifSelected(By locator){

        WebElement checkBox=findElement(locator);
        if(checkBox.isSelected()){
            checkBox.click();
        }
    }
}
