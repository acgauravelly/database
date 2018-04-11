package Pages;


import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPage extends BasePage {

    private By addUser = By.cssSelector("a[href='/samsung/admin/add-user']");
    private By firstNameField = By.cssSelector("#FirstName");
    private By lastNameField = By.cssSelector("#LastName");
    private By emailField = By.cssSelector("#EmailAddress");
    private By checkBox = By.cssSelector(".checkboxinput");
    private By group = By.cssSelector("#GroupTitle");
    private By accountType = By.cssSelector("#AccountType");
    private By saveAndUpdate = By.cssSelector("#saveandupload");
    private By userSearchField = By.cssSelector("#partSearch");
    private By searchBy = By.cssSelector("#partSearchTarget");
    public static By searchResultsList = By.cssSelector("#gbox_list47");
    private By firstNameColumn = By.xpath("//*[@id='652532-1']/td[1]");
    private By viewUserfirstNameColumn = By.xpath("//*[@id='652532-1']/td[2]");
    private By lastNameColumn = By.xpath("//*[@id='652532-1']/td[2]");
    private By viewUserlastNameColumn = By.xpath("//*[@id='652532-1']/td[3]");
    private By emailColumn = By.xpath("//*[@id='652532-1']/td[3]");
    private By viewUserEmailColumn = By.xpath("//*[@id='652532-1']/td[2]");
    private By selectFileButton = By.cssSelector("#fileToUpload");
    private By successAlert = By.xpath("//div[@class='alert success_1 success_2']");
    private By groupOnPopUp = By.cssSelector("#group");
    private By editAlert = By.xpath("//div[@class='alert success_1']");
    //    category priority locators
    private By mobielCategory = By.xpath("//li[@id='category-384629']");
    private By geheugenCategory = By.xpath("//li[@id='category-761287']");
    private By categories = By.cssSelector(".categorytitle.ui-state-default");
    private By catHolder = By.cssSelector(".sortable.ui-sortable");

    //click locators
    private By viewUsersLink = By.cssSelector("a[href='/samsung/admin/view-users']");
    private By batchUsersLink = By.cssSelector("a[href='/samsung/admin/create-batch-users']");
    private By addUsersLink = By.cssSelector("a[href='/samsung/admin/add-user']");
    private By manageGroupsLink = By.cssSelector("a[href='/samsung/admin/view-groups']");
    private By setCategoryPriorityLink = By.cssSelector("a[href='/samsung/admin/set-category-priority']");
    private By userEditButton = By.cssSelector("#u210_img");

    public static String adminurl = "https://dev-manage.flix360.com/samsung/admin/view-users";

    //Add a new user with the fields
    public void adduser(DataTable table) throws InterruptedException {
        List<List<String>> data = table.raw();
        click(addUser);
        writetoField(firstNameField, data.get(1).get(1));
        writetoField(lastNameField, data.get(2).get(1));
        writetoField(emailField, data.get(3).get(1));
        clickCheckboxifNotSelected(checkBox, "value", "4");
        select(group, data.get(5).get(1));
        select(accountType, data.get(6).get(1));
        click(saveAndUpdate);

    }

    //Clicks on the view users link
    public void clickViewusers() {
        if (!getCurrentUrl().equalsIgnoreCase(adminurl))
            click(viewUsersLink);
        Assert.assertEquals("https://dev-manage.flix360.com/samsung/admin/view-users", getCurrentUrl());
    }

    //Clicks on the add users link
    public void clickAddUsers() {
        click(addUsersLink);
    }

    //Clicks on the batch users link
    public void clickBatchUsersLink() {
        click(batchUsersLink);
    }

    //Clicks on the manage groups link
    public void clickmanageGroupsLink() {
        click(manageGroupsLink);
    }

    //Clicks on the category priority link
    public void clickCategoryPriority() {
        click(setCategoryPriorityLink);
    }

    //    Search first name column
    public void searchUsersByFirstNAme(String text) throws InterruptedException {

        writetoField(userSearchField, text);
        select(searchBy, "FirstName");
        BasePage.sleep(3000);
        waitForElement(searchResultsList);
        confirmFieldsStartswith(searchResultsList, viewUserfirstNameColumn, text);


    }

    //Search last name column
    public void searchUsersByLastName(String text) throws InterruptedException {
        writetoField(userSearchField, text);
        BasePage.sleep(3000);
        select(searchBy, "Lastname");
        waitForElement(searchResultsList);
        confirmFieldsStartswith(searchResultsList, viewUserlastNameColumn, text);

    }

    //    Search user by email
    public void searchUsersByEmail(String email) throws InterruptedException {

        select(searchBy, "Email");
        BasePage.sleep(3000);
        writetoField(userSearchField, email);
        waitForElement(searchResultsList);
        confirmFieldsStartswith(searchResultsList, emailColumn, email);
    }

    //    Batch upload of users from csv file
    public void batchUserUpload(DataTable table) throws InterruptedException {
        List<List<String>> data = table.raw();
        writetoField(selectFileButton, data.get(1).get(1));
        Thread.sleep(3000);
        Assert.assertEquals(15, findElements(firstNameColumn).size());
        if (isElementPresent(saveAndUpdate)) {
            click(saveAndUpdate);
            verifyFieldContainsText(successAlert, "Users saved successfully");
        } else {
            System.out.println("Users list is blank");
            Assert.fail();
        }
    }

    //    Confirms user is found by first name
    public void confirmUsersFirstName(String firstName) throws InterruptedException {
        writetoField(userSearchField, firstName);
        select(searchBy, "FirstName");
        BasePage.sleep(3000);
        waitForElement(searchResultsList);
        verifyFieldsContainsText(viewUserfirstNameColumn, firstName);
    }


    //    Confirms user is found by last name
    public void confirmUsersLastName(String lastName) throws InterruptedException {
        writetoField(userSearchField, lastName);
        select(searchBy, "Lastname");
        BasePage.sleep(3000);
        waitForElement(searchResultsList);
        verifyFieldsContainsText(lastNameColumn, lastName);
    }

    //    Edit user details
    public void editUser(DataTable table) throws InterruptedException {
        List<List<String>> data = table.raw();

        click(userEditButton);
        Thread.sleep(2000);
        switchToIframe();
        writetoField(firstNameField, data.get(1).get(1));
        writetoField(lastNameField, data.get(2).get(1));
        select(groupOnPopUp, data.get(3).get(1));
        click(saveAndUpdate);
        switchToDefaultPage();
//        BasePage.sleep(3000);
        verifyFieldContainsText(editAlert, "User has been successfully created and an automated notification has been delivered to the user's e-mail address");
//
//        BasePage.sleep(3000);

    }

    //edit user details passing the parameters
    public void editUser(String fname, String lname, String groupname) throws InterruptedException {

        searchUsersByLastName("auto");
        click(userEditButton);
        switchToIframe();
        writetoField(firstNameField, fname);
        writetoField(lastNameField, lname);
        select(groupOnPopUp, groupname);
        click(saveAndUpdate);
        switchToDefaultPage();
//        waitForElement(editAlert);
        verifyFieldContainsText(editAlert, "User has been successfully created and an automated notification has been delivered to the user's e-mail address");
//        switchToDefaultPage();

    }

    //Asserts which group is selected
    public void selectedGroup() {
        String actGroup = "None";
        Assert.assertEquals(actGroup, isSelected(groupOnPopUp));

    }

    public void mobileToGeheugencategoryDrag() {
        dragAndDrop(mobielCategory, geheugenCategory);
    }

    public void geheugenToMobilecategoryDrag() {
        dragAndDrop(geheugenCategory, mobielCategory);
    }

    public void changeCatOrderforTest() throws InterruptedException {

        WebElement categoryHolder = findElement(catHolder);
        List<WebElement> cats = categoryHolder.findElements(categories);
        for (int i = 0; i < cats.size(); i++) {
            System.out.println(cats.get(i).getText());
        }
        if (cats.get(0).getText().equalsIgnoreCase("geheugen")) {
            mobileToGeheugencategoryDrag();
            click(saveAndUpdate);
            Thread.sleep(5000);
        }


    }

    public void setCategoryPriority() throws InterruptedException {
        geheugenToMobilecategoryDrag();
        Thread.sleep(5000);
        click(saveAndUpdate);
        verifyFieldContainsText(successAlert, "Category priorities saved successfully");
    }
}
