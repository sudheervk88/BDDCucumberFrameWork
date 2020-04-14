package webDriverFrameFunction;

import utilsPackage.IReader;
import webDriverServices.DriverServices;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.ByAngular;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class WebDriverFrameFunctionDefnition {

     private WebDriver driver;
     private DriverServices services;
     private WebElement webElement;
     private ArrayList<String> windowID;
     private IReader readConfigFile;

     public WebDriverFrameFunctionDefnition(DriverServices services){
         this.services = services;
         this.driver = services.getDriver();
         this.readConfigFile = services.getIReader();
     }


    @Given("^IFrame_I navigate to url \"([^\"]*)\"$")
    public void iframe_i_navigate_to_url(String url) throws Throwable {

        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(readConfigFile.getExplicitWait(), TimeUnit.SECONDS);

    }

    @When("^IFrame_I click on the element in the iframe it should click$")
    public void iframe_i_click_on_the_element_in_the_iframe_it_should_click() throws Throwable {
        WebDriverWait webDriverWait = getWait(driver, readConfigFile.getExplicitWait());
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("tryhome")));
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='https://www.w3schools.com']")));
        services.getButtonHelper().click(By.cssSelector("a[title='Search W3Schools']"));
    }

    @When("^IFrame_I call quit method browser will close$")
    public void iframe_i_call_quit_method_browser_will_close() throws Throwable {
       /* if(driver!=null)
            driver.quit(); */
    }

    @When("^IFrame_I click on home button$")
    public void iframe_i_click_on_home_button() throws Throwable {
        driver.switchTo().defaultContent();
        services.getButtonHelper().click(By.id("tryhome"));
        
    }

    @Given("^MultipleWindow_I open the web page \"([^\"]*)\"$")
    public void multiplewindow_i_open_the_web_page(String url) throws Throwable {
      driver.get(url);
    }

    @Then("^MultipleWindow_I click on button it will open child browser window$")
    public void multiplewindow_i_click_on_button_it_will_open_child_browser_window() throws Throwable {
       services.getButtonHelper().click(By.xpath("//a[@href='tryit.asp?filename=tryjs_alert']"));
    }

    @Then("^MultipleWindow_I switch to child browser and click on home button$")
    public void multiplewindow_i_switch_to_child_browser_and_click_on_home_button() throws Throwable {
         WebDriverWait wait = getWait(driver,readConfigFile.getExplicitWait());
         services.getWindowHelper().switchToWindow(1);
         wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tryhome")));
         services.getButtonHelper().click(By.id("tryhome"));
         services.getWindowHelper().switchToWindow(2);
         services.getWindowHelper().switchToParent();
         wait.until(ExpectedConditions.presenceOfElementLocated(By.id("topnavbtn_tutorials")));
         services.getButtonHelper().click(By.id("topnavbtn_tutorials"));
         services.getWindowHelper().switchToParentWithClose();

    }


    private WebDriverWait getWait(WebDriver driver,int timeOut){

       WebDriverWait wait = new WebDriverWait(driver,timeOut);
       wait.pollingEvery(250,TimeUnit.MILLISECONDS);
       wait.ignoring(NoSuchElementException.class);
       return wait;
    }


}
