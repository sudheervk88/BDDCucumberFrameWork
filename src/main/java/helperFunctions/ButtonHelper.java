package helperFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonHelper {
   private static ButtonHelper buttonHelper;
   private static WebDriver webDriver;


   private ButtonHelper(WebDriver driver){

       webDriver = driver;
   }

   public static ButtonHelper getInstance(WebDriver driver){
       if(buttonHelper == null || webDriver.hashCode() != driver.hashCode())
           buttonHelper = new ButtonHelper(driver);
       return buttonHelper;

   }

   public void click(By locator){
	   
     WebDriverWait wait = getWait();
     wait.until(ExpectedConditions.elementToBeClickable(locator));
	 WebElement element = webDriver.findElement(locator);
	// flashElement(element, webDriver);  
	 highLighterMethod(webDriver, element);
     webDriver.findElement(locator).click();

    }

   
    public void flashElement(WebElement element,WebDriver driver) {
    	
    	String bgColor = element.getCssValue("backgroundColor");
    	
    	for(int i=0;i<5;i++) {
    		changeColor("rgb(255,0,0)",element,driver);
    		changeColor(bgColor, element, driver);
    	}
    	
    }
    
    
    public void changeColor(String color,WebElement element,WebDriver driver) {
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",element);
    	
    	try {
    		Thread.sleep(20);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
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
