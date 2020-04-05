package helperFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionHelper {

    private static ActionHelper actionHelper;
    private static WebDriver webDriver;


    private ActionHelper(WebDriver driver){

        webDriver = driver;
    }

    public static ActionHelper getInstance(WebDriver driver){
        if(actionHelper == null || webDriver.hashCode() != driver.hashCode())
            actionHelper = new ActionHelper(driver);
        return actionHelper;

    }

    public void performDragAdnDrop(By source, By destination){

        Actions actions = new Actions(webDriver);
        WebElement el1 = webDriver.findElement(source);
        WebElement el2 = webDriver.findElement(destination);
        actions.clickAndHold(el1).release(el2).build().perform();

    }





}






