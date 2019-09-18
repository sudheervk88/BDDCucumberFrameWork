package helperFunctions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class GenericHelper {

    private static GenericHelper genericHelper;
    private static WebDriver webDriver;

    private GenericHelper(WebDriver driver){
        webDriver = driver;
    }

    public static GenericHelper getInstance(WebDriver driver){

        if(genericHelper == null || webDriver.hashCode() != driver.hashCode())
            genericHelper = new GenericHelper(driver);
        return genericHelper;

    }


   public void takeScreenShot(String Directory, String fileName){

       File directory = new File(Directory);

       if(!directory.exists())
           directory.mkdirs();

       File screenshot =((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
       try {
           FileUtils.copyFile(screenshot,new File(directory.getAbsolutePath() + File.separator +fileName));
       }
       catch (IOException e) {

       }

   }
     public byte[] takeScreenShot(){
       byte[] screenShot = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
       return screenShot;
     }

}
