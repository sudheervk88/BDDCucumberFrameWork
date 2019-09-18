package helperFunctions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AlertHelper {

    private static AlertHelper alertHelper;
    private static WebDriver webDriver;


    private AlertHelper(WebDriver driver){

        webDriver = driver;
    }

    public static AlertHelper getInstance(WebDriver driver){
        if(alertHelper == null || webDriver.hashCode() != driver.hashCode())
            alertHelper = new AlertHelper(driver);
        return alertHelper;

    }

    private WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(webDriver,60);
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.ignoring(NoAlertPresentException.class);
        return wait;
    }

    private Alert waitForAlert(){
        WebDriverWait wait = getWait();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;

    }

    public void acceptAlert(){
     Alert alert = waitForAlert();
     alert.accept();
    }

    public void dimissAlert(){
        Alert alert = waitForAlert();
        alert.dismiss();
    }

    public void setAlertMessage(String alertInputMessage) throws InterruptedException {
        Alert alert = waitForAlert();
        alert.sendKeys(alertInputMessage);
    }

    public String getAlertText(){
        Alert alert = waitForAlert();
        return alert.getText();
    }




}
