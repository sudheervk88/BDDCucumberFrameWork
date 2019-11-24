package genericHook;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumber.api.Scenario;
import gherkin.formatter.model.Result;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

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
         String errorMessage = getErrorTrace(scenario);
        switch (scenario.getStatus()){
            case PASSED:
                extentReports.createTest(testName).pass("Test Passed");
             break;
            case FAILED:
                extentReports.createTest(testName).fail(errorMessage).addScreenCaptureFromPath(getScreenShotLocation(screenShotFile));
             break;
            default:extentReports.createTest(testName).skip("Test Skipped");

        }

     }

   }

   private String getErrorTrace(Scenario scenario)  {
       List<Result> testResultList = null;
       List<Result> failedStepList = null;
       try {

         Field stepResults = scenario.getClass().getDeclaredField("stepResults");
         stepResults.setAccessible(true);
         testResultList = (List<Result>) stepResults.get(scenario);

       } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
           e.printStackTrace();
       }

       if(testResultList != null && !testResultList.isEmpty()){
          failedStepList = testResultList.stream().filter((x)->{
               return x.getErrorMessage() != null;
           }).collect(Collectors.toList());

       }
          if(failedStepList != null && !failedStepList.isEmpty() ){
              return failedStepList.get(0).getErrorMessage();
          }
          return "";
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
