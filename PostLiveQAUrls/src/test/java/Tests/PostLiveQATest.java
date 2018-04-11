package Tests;

import Pages.PostLiveQAPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PostLiveQATest {
    PostLiveQAPage postLiveQAPage = new PostLiveQAPage();

    @Given("^I navigate to the \"([^\"]*)\"$")
    public void iNavigateToThe(String url) throws Throwable {
        postLiveQAPage.cleanFolder();
        postLiveQAPage.navigateTopostLiveUrl(url);
    }

    @And("^I wait for logs to be exported$")
    public void iWaitForLogsToBeExported() throws Throwable {
        Thread.sleep(20000);
    }

    @Then("^there should be no dev urls present$")
    public void thereShouldBeNoDevUrlsPresent() throws Throwable {
        postLiveQAPage.renameHarfile("www");
        Thread.sleep(5000);
        postLiveQAPage.readHarFile();
        Thread.sleep(5000);
    }
}
