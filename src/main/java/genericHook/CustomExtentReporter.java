package genericHook;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumber.api.Scenario;

import java.io.File;
import java.io.IOException;

import static gherkin.formatter.model.Result.FAILED;
import static gherkin.formatter.model.Result.PASSED;

public class CustomExtentReporter {

   private ExtentHtmlReporter extentHtmlReporter;
   private ExtentReports extentReports;

   public CustomExtentReporter(String reportLocation){
    extentHtmlReporter = new ExtentHtmlReporter(new File(reportLocation));
    extentReports = new ExtentReports();
    extentReports.attachReporter(extentHtmlReporter);
   }

   public void createTest(Scenario scenario,String screenShotFile) throws IOException {
     if(scenario != null){
         String testName = getScenarioTitle(scenario);
        switch (scenario.getStatus()){
            case PASSED:
                extentReports.createTest(testName).pass("Test Passed");
             break;
            case FAILED:
                extentReports.createTest(testName).fail("Test Failed").addScreenCaptureFromPath(getScreenShotLocation(screenShotFile));
             break;
            default:extentReports.createTest(testName).skip("Test Skipped");

        }

     }

   }

   public void writeToReport(){
     if(extentReports != null){
         extentReports.flush();
     }

   }
   private String getScreenShotLocation(String aLocation){
       return "file:///" + aLocation.replaceAll("'\\'" ,"//");
   }


  private String getScenarioTitle(Scenario scenario){
       return scenario.getName().replaceAll(" ","");
  }


 }
