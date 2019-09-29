package javaScriptExecutorPackage;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/main/java/javascriptExecutorPackage",
        glue  = {"genericHook","javaScriptExecutorPackage"},
        dryRun = false,
        monochrome = true
        // tags = "@Smoke-dropdown"
)

public class JsFunctionRunner extends AbstractTestNGCucumberTests {
}
