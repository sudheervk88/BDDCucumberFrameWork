package helperFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxHelper {

    private static TextBoxHelper textBoxHelper;
    private static WebDriver webDriver;
    private WebElement element;
    private TextBoxHelper(WebDriver driver){

        webDriver = driver;
    }

    public static TextBoxHelper getInstance(WebDriver driver){
        if(textBoxHelper == null || webDriver.hashCode() != driver.hashCode())
            textBoxHelper = new TextBoxHelper(driver);
        return textBoxHelper;

    }

    public void setText(By locator,String value){
    	WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element = webDriver.findElement(locator);
        highLighterMethod(webDriver,element);
        element.sendKeys(value);
    }


    public String getText(By locator){
    	WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element = webDriver.findElement(locator);
        String value = element.getText();
        return value;
    }

    public void clearText(By locator){
    	WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element = webDriver.findElement(locator);
        highLighterMethod(webDriver,element);
        element.clear();
    }
    
    public void highLighterMethod(WebDriver driver, WebElement element){
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	String bgColor = element.getCssValue("backgroundColor");
        js.executeScript("arguments[0].setAttribute('style', 'background: "+bgColor+"; border: 2px solid red;');", element);
        
        }
    
    @SuppressWarnings("deprecation")
   	private WebDriverWait getWait(){
           WebDriverWait wait = new WebDriverWait(webDriver,60);
           wait.pollingEvery(250, TimeUnit.MILLISECONDS);
           wait.ignoring(NoAlertPresentException.class);
           return wait;
       }

  }
