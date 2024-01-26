package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/loginFeatures",
        glue = "stepDefLogin",
        tags = "@login_test",
        plugin = {"pretty","html:target/RegressionReport.html"}
)
public class RunLoginTest {
}
