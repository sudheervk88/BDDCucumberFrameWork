package scenarioRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/main/java/AlertFunction",
        glue  = {"alertFunction", "genericHook"},
        dryRun = false,
        monochrome = true,
        tags = "@Prompt_popUp",
        plugin = {"pretty","html:target/HTMLReport","json:target/JsonReport/BugCreation.json",
                "junit:target/JunitReport/BugCreation.xml"}
)
public class AlertFunctionRunner extends AbstractTestNGCucumberTests {
}
