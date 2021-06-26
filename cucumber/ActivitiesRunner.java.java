package cucumberTest;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinition"},
    tags = "@activity2_5",
    plugin = {"pretty"},
    monochrome = true
)

public class ActivitiesRunner {
    //empty
}
