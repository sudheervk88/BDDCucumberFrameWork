package dragAndDropFunction;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilsPackage.IReader;
import webDriverServices.DriverServices;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class DragAndDropStepDef {

    private WebDriver driver;
    private DriverServices driverServices;
    private WebElement webElement;
    private IReader readConfigFile;


    public DragAndDropStepDef(DriverServices driverServices){
        this.driverServices = driverServices;
        this.driver = driverServices.getDriver();
        this.readConfigFile = driverServices.getIReader();

    }

    @Given("^I navigate to the given url \"([^\"]*)\"$")
    public void i_navigate_to_the_given_url(String url) throws Throwable {
       driver.get(url);
    }

    @When("^I reach page I will perform drag and drop$")
    public void i_reach_page_I_will_perform_drag_and_drop() throws Throwable {
        WebDriverWait wait = getWait(driver,readConfigFile.getExplicitWait());
        Thread.sleep(5000);
        //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='tryhtml5_draganddrop_ifr.htm']")));
        WebElement frame = driver.findElement(By.xpath("//iframe[@src='tryhtml5_draganddrop_ifr.htm']"));
        driver.switchTo().frame(frame);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("//*[@id='drag1' and @alt='W3Schools']")));
        driverServices.getActionHelper().performDragAdnDrop(By.xpath("//*[@id='drag1' and @alt='W3Schools']"),By.id("//div[@id='main']//*[@id='div2']"));
    }

    private WebDriverWait getWait(WebDriver driver, int timeOut){

        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        return wait;
    }
}
