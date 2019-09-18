package browserFunction;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
     features = "src/main/java/browserFunction",
       // glue  = "browserFunction
        dryRun = false,
        monochrome = true
        )
public class BrowserFunctionRunner extends AbstractTestNGCucumberTests {
}
