package genericHook;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import webDriverServices.DriverServices;

public class GeneralHook {

   private DriverServices driverServices;
   private WebDriver driver;

   public GeneralHook(DriverServices driverServices){
       this.driverServices = driverServices;
       this.driver = driverServices.getDriver();

   }

    @Before
    public void setUp(){

     }

     @After
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
