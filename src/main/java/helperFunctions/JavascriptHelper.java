package helperFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptHelper {

    private static JavascriptHelper javascriptHelper;
    private static WebDriver webDriver;


    private JavascriptHelper(WebDriver driver){

        webDriver = driver;
    }

    public static JavascriptHelper getInstance(WebDriver driver){
        if(javascriptHelper == null || webDriver.hashCode() != driver.hashCode())
            javascriptHelper = new JavascriptHelper(driver);
        return javascriptHelper;

    }


    public Object executeScript(By locator){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
       return js.executeScript("arguments[0].click();",locator);

    }

    public Object executeScript(WebElement id){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return js.executeScript("document.getElementById("+ id +").click();");
    }


}
