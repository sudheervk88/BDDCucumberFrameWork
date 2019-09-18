package helperFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownHelper {

    private static DropDownHelper dropDownHelper;
    private static WebDriver webDriver;
    private WebElement element;

    private DropDownHelper(WebDriver driver){
        webDriver = driver;
    }

    public static DropDownHelper getInstance(WebDriver driver){

        if(dropDownHelper == null || webDriver.hashCode() != driver.hashCode())
            dropDownHelper = new DropDownHelper(driver);
        return dropDownHelper;
    }


    public void selectByVisibleText(By locator, String visibleText){

     Select select = new Select(webDriver.findElement(locator)) ;
     select.selectByVisibleText(visibleText);

    }

    public void selectByVisibleText(WebElement element, String visibleText){

        Select select = new Select(element) ;
        select.selectByVisibleText(visibleText);

    }

    public void selectByIndex(By locator, int index){

        Select select = new Select(webDriver.findElement(locator)) ;
        select.selectByIndex(index);

    }

    public void selectByValue(By locator, String valueAttribute){

        Select select = new Select(webDriver.findElement(locator)) ;
        select.selectByValue(valueAttribute);

    }

    public List<WebElement> getAllElements(By locator){
        Select select = new Select(webDriver.findElement(locator));
        return select.getOptions();

    }

}
