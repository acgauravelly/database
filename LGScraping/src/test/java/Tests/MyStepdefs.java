package Tests;

import Pages.Scraping;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by ajay on 23/05/2017.
 */
public class MyStepdefs {
    Scraping scraping = new Scraping();

    @Given("^I visit the LGsite$")
    public void iVisitTheLGsite() throws Throwable {
        scraping.visit_lgSite();
    }

    @And("^I get the categories$")
    public void iGetTheCategories() throws Throwable {
        scraping.categories();
    }

    @Then("^I retrieve mpns from each category$")
    public void iRetrieveMpnsFromEachCategory() throws Throwable {
//        System.out.println("** End of a Sub Category****************");
    }

    @Given("^I visit the \"([^\"]*)\" page$")
    public void iVisitThePage(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("ipsMonitors")) {
            scraping.visitIpsMonitors();
        } else if (arg0.equalsIgnoreCase("medicalMonPage")) {
            scraping.visitMedicalMonitor();
        } else if (arg0.equalsIgnoreCase("fourKmonitorPage")) {
            scraping.visitFourKMonitor();
        } else if (arg0.equalsIgnoreCase("ledMonitorPage")) {
            scraping.visitLedMonitors();
        } else if (arg0.equalsIgnoreCase("zeroClientPage")) {
            scraping.visitZeroClient();
        } else if (arg0.equalsIgnoreCase("hospitalPatientRoom")) {
            scraping.hospitalPatientRoom();
        } else if (arg0.equalsIgnoreCase("proCentricSmartDsiplays")) {
            scraping.procentricSmart();
        } else if (arg0.equalsIgnoreCase("proCentricValueDsiplays")) {
            scraping.procentricValue();
        } else if (arg0.equalsIgnoreCase("commercialLiteDisplays")) {
            scraping.commerciallite();
        } else if (arg0.equalsIgnoreCase("hospitalityOledDisplays")) {
            scraping.hospitalityOled();
        } else if (arg0.equalsIgnoreCase("headEndSystems")) {
            scraping.headEndSytems();
        } else if (arg0.equalsIgnoreCase("interfaceControls")) {
            scraping.interfaceControls();
        } else if (arg0.equalsIgnoreCase("commercialLed")) {
            scraping.commercialLed();
        } else if (arg0.equalsIgnoreCase("superSignTvs")) {
            scraping.supersign();
        }
    }
}
