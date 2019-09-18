package webElementFunction;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
     features = "src/main/java/WebElementFunction",
        glue  = {"webElementFunction", "genericHook"},
        dryRun = false,
        monochrome = true
       // tags = "@Smoke-dropdown"
        )
public class WebElementFunctionRunner extends AbstractTestNGCucumberTests {
}
