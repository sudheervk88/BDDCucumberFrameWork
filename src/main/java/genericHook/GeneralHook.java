package genericHook;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import webDriverServices.DriverServices;

import java.io.IOException;

public class GeneralHook {

   private DriverServices driverServices;
   private WebDriver driver;
   private static CustomExtentReporter customExtentReporter;
   private static boolean isReporterRunning;

   public GeneralHook(DriverServices driverServices){
       this.driverServices = driverServices;
       this.driver = driverServices.getDriver();

   }

  /* @Before
    public void setUp(){

     } */

    @Before
    public void beforeScenario(Scenario scenario){
        if(!isReporterRunning){
            customExtentReporter = new CustomExtentReporter("D:\\ExtentReport\\AutomationReport.html");
            isReporterRunning = true;
        }
    }

     @After
     public void afterScenario(Scenario scenario) throws IOException {
        String screenShotFileName = "D:\\ExtentReport\\" +scenario.getName().replaceAll(" "," ") +".jpeg";
        
        if(scenario.isFailed()){
            driverServices.getGenericHelper().takeScreenShot(screenShotFileName);
           
            
         }
        customExtentReporter.createTest(scenario,screenShotFileName);
        customExtentReporter.writeToReport();
         if(driver != null)
             driver.quit();
     }


    // @After
     public void tearDown(Scenario scenario){

       if(scenario.isFailed()){
           captureScreenShot(scenario);
       }

         if(driver != null)
             driver.quit();

     }

    private void captureScreenShot(Scenario scenario) {
        int random = (int) (Math.random()*1000);
        driverServices.getGenericHelper().takeScreenShot("Screenshot","src"+ random +".png");
        scenario.embed(driverServices.getGenericHelper().takeScreenShot(),"image/png");
    }


}
