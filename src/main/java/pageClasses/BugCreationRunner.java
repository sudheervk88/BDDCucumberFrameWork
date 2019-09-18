package pageClasses;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/main/java/pageClasses/BugCreation.feature",
        glue  = {"pageClasses", "genericHook"},
    //  dryRun = true,
        monochrome = true,
        plugin = {"pretty","html:target/HTMLReport","json:target/JsonReport/BugCreation.json",
                "junit:target/JunitReport/BugCreation.xml"}

  //    tags = "@Window"
)
public class BugCreationRunner extends AbstractTestNGCucumberTests {
}
