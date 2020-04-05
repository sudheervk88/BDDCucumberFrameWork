package webDriverWaitFunction;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/main/java/WebDriverWaitFunction",
        // glue  = "browserFunction
        dryRun = false,
        monochrome = true
       // tags = "@ExplicitWait"
)

public class WebDriverWaitFunctionRunner extends AbstractTestNGCucumberTests {

}