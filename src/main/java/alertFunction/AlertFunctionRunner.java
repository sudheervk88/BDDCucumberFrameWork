package alertFunction;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/main/java/AlertFunction",
        glue  = {"alertFunction", "genericHook"},
        dryRun = false,
        monochrome = true,
        tags = "@Boot_strap_popUp"
)
public class AlertFunctionRunner extends AbstractTestNGCucumberTests {
}
