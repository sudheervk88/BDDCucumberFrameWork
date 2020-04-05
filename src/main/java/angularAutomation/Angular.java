package angularAutomation;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularBinding;
import com.paulhammant.ngwebdriver.NgWebDriver;
import cucumber.api.java.After;
import cucumber.api.java.nl.Stel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.sql.DriverManager;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Angular {

    static NgWebDriver ngWebDriver;
    static WebDriver driver;
    static  WebDriverWait wait;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
      
        driver = new ChromeDriver();
        driver.get("https://www.gmail.com");
        Thread.sleep(4000);
        WebElement ele = driver.findElement(By.xpath("//*[@name='identifier']"));
                       //Call the highlighterMethod and pass webdriver and WebElement which you want to highlight as arguments.
        highLighterMethod(driver,ele);
        ele.sendKeys("SoftwareTestingMaterial.com");
        }
        
               //Creating a custom function
        public static void highLighterMethod(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid red;');", element);
        }


}
