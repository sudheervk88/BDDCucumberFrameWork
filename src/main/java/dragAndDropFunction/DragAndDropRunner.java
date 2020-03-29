package dragAndDropFunction;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/main/java/dragAndDropFunction/DragAndDrop.feature",
        glue  = {"dragAndDropFunction"},
        dryRun = false,
        monochrome = true
 )

public class DragAndDropRunner extends AbstractTestNGCucumberTests {
}
