/*
 * Java script helper package
 * 
 */

package helperFunctions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class JavascriptHelper {

    private static JavascriptHelper javascriptHelper;
    private static WebDriver webDriver;
    private static WebElement element;

    private JavascriptHelper(WebDriver driver){

        webDriver = driver;
    }

    public static JavascriptHelper getInstance(WebDriver driver){
        if(javascriptHelper == null || webDriver.hashCode() != driver.hashCode())
            javascriptHelper = new JavascriptHelper(driver);
        return javascriptHelper;

    }

    public Object jsExecutor(String script, By locator){
        WebDriverWait wait = getWait();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        element = webDriver.findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return js.executeScript(script,element);
    }

    public Object jsExecutor(String script){
    	
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        return js.executeScript(script);
    }

    



    private WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(webDriver,60);
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.ignoring(NoAlertPresentException.class);
        return wait;
    }





}
