package testDot.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/testDot/cucumber/resources/features",
        glue = "testDot.cucumber.stepDef",
        plugin = {"html:target/HTML_report.html"}
)

public class runLoginPSE {
}