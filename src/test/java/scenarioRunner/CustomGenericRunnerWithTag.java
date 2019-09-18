package scenarioRunner;

import cucumber.api.CucumberOptions;
import customRunner.CustomAbstractTestNGCucumberTestsWithTag;

@CucumberOptions(
        features = "src/main/java/scenarioRunner",
        glue  = {"genericHook","scenarioRunner"},
        monochrome = true,
        plugin = {"pretty","html:target/HTMLReport","json:target/JsonReport/BugCreation.json",
                "junit:target/JunitReport/BugCreation.xml"}
  )


public class CustomGenericRunnerWithTag extends CustomAbstractTestNGCucumberTestsWithTag {
}
