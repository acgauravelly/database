import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty","html:target/cucumber-reports","json:target/cucumber.json"},
        features="src/test/resources",
        tags={"@Batch-AddtoCart"}
)
public class TestRunner {


}
