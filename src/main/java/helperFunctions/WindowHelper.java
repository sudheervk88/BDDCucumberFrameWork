package helperFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WindowHelper {

    private static WindowHelper windowHelper;
    private static WebDriver webDriver;
    private WebElement element;
    private WindowHelper(WebDriver driver){

        webDriver = driver;
    }

    public static WindowHelper getInstance(WebDriver driver){
        if(windowHelper == null || webDriver.hashCode() != driver.hashCode())
            windowHelper = new WindowHelper(driver);
        return windowHelper;

    }

    private List<String> getWindowIds(){

        ArrayList<String> windowIds = new ArrayList<>(webDriver.getWindowHandles());
        return Collections.unmodifiableList(windowIds);
        //it will prevent the modification of the list by other methods

    }

    private WebDriverWait getWait(){

        WebDriverWait wait = new WebDriverWait(webDriver,60);
        return wait;
    }

    public void switchToWindow(int index){

     /*   WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.numberOfWindowsToBe(index)); */
        ArrayList<String> windowIds = new ArrayList<>(getWindowIds());
        if(index < 0 || index >windowIds.size())
            throw new IllegalArgumentException("Invalid index" +index);
        webDriver.switchTo().window(windowIds.get(index));

    }

    public void switchToParent(){

        ArrayList<String> windowIds = new ArrayList<>(getWindowIds());
        webDriver.switchTo().window(windowIds.get(0));

    }

    public void switchToParentWithClose(){
      //This will close all windows(Child windows) except parent window
        ArrayList<String> windowIds = new ArrayList<>(getWindowIds());

        for(int i=1;i<windowIds.size();i++){
            webDriver.switchTo().window(windowIds.get(i));
            webDriver.close();
        }
        switchToParent();
    }


 }
