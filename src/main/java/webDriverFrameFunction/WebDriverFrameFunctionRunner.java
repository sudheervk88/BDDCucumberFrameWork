package webDriverFrameFunction;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/main/java/webDriverFrameFunction",
        glue  = {"genericHook", "webDriverFrameFunction"},
        dryRun = false,
        monochrome = true
       // tags = "@Window"
)
public class WebDriverFrameFunctionRunner extends AbstractTestNGCucumberTests {

}
