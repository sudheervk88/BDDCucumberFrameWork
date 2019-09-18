package helperFunctions;

import org.openqa.selenium.WebDriver;

public class BrowserHelper {

    private static BrowserHelper browserHelper;
    private static WebDriver webDriver;

    private BrowserHelper(WebDriver driver){
        webDriver = driver;
    }

    public static BrowserHelper getInstance(WebDriver driver){

        if(browserHelper == null || webDriver.hashCode() != driver.hashCode())
            browserHelper = new BrowserHelper(driver);
        return browserHelper;

    }

    public void moveForward(){
        webDriver.navigate().forward();
    }

    public void moveBackWard(){
        webDriver.navigate().back();
    }

    public void refreshPage(){
        webDriver.navigate().refresh();
    }

    public void maximizePage(){
        webDriver.manage().window().maximize();
    }

}
