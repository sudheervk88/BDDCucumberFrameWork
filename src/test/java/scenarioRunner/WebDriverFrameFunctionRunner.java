package scenarioRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/main/java/webDriverFrameFunction",
        glue  = {"genericHook", "webDriverFrameFunction"},
        dryRun = false,
        monochrome = true,
       // tags = "@Window"
        plugin = {"pretty","html:target/HTMLReport","json:target/JsonReport/BugCreation.json",
                "junit:target/JunitReport/BugCreation.xml"}
)
public class WebDriverFrameFunctionRunner extends AbstractTestNGCucumberTests {

}
