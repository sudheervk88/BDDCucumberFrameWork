package alertFunction;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilsPackage.IReader;
import webDriverServices.DriverServices;


import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class AlertFunctionDefnition {

    private WebDriver driver;
    private DriverServices driverServices;
    private WebElement webElement;
    private IReader readConfigFile;


   public AlertFunctionDefnition(DriverServices driverServices){
     this.driverServices = driverServices;
     this.driver = driverServices.getDriver();
     this.readConfigFile = driverServices.getIReader();

   }

    @Given("^Alerts_I navigate to the given url \"([^\"]*)\"$")
    public void alerts_i_navigate_to_the_given_url(String url) throws Throwable {

        driver.get(url);
    }

    @When("^Alerts_I click on try it button it should show the alert$")
    public void alerts_i_click_on_try_it_button_it_should_show_the_alert() throws Throwable {
       WebDriverWait wait = getWait(driver,readConfigFile.getExplicitWait());
       wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tryhome"))); 
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
       driverServices.getButtonHelper().click(By.xpath("//button[text()='Try it']"));
    }

    @When("^Alerts_I switch to alert and accept the alert$")
    public void alerts_i_switch_to_alert_and_accept_the_alert() throws Throwable {
        driverServices.getAlertHelper().acceptAlert();

    }

    @Then("^Alerts_I switch to default content$")
    public void alerts_i_switch_to_default_content() throws Throwable {
        driver.switchTo().defaultContent();
    }

    @Given("^Alerts_I navigate to the given web page \"([^\"]*)\"$")
    public void alerts_i_navigate_to_the_given_web_page(String url) throws Throwable {
        driver.get(url);
    }

    @When("^Alerts_I switch to alert and dismiss the alert$")
    public void alerts_i_switch_to_alert_and_dismiss_the_alert() throws Throwable {
      driverServices.getAlertHelper().dimissAlert();
    }

    @Given("^Alerts_I navigate to the given webpage \"([^\"]*)\"$")
    public void alerts_i_navigate_to_the_given_webpage(String url) throws Throwable {
        driver.get(url);
    }

    @When("^Alerts_I provide string as \"([^\"]*)\"$")
    public void alerts_i_provide_string_as(String str) throws Throwable {
        driverServices.getAlertHelper().setAlertMessage(str);
        System.out.println("The Prompt text is"+"  "+ driverServices.getAlertHelper().getAlertText());
      //  Thread.sleep(5000);
        driverServices.getAlertHelper().acceptAlert();
    }

    @Then("^Alerts_I get the text from the prompt$")
    public void alerts_i_get_the_text_from_the_prompt() throws Throwable {
        System.out.println("The displayed text is"+"  "+driverServices.getTextBoxHelper().getText(By.id("demo")));
    }


    @Given("^Alerts_I navigate to the given page \"([^\"]*)\"$")
    public void alerts_i_navigate_to_the_given_page(String url) throws Throwable {
        driver.get(url);
    }

    @When("^Alerts_I click on open model button$")
    public void alerts_i_click_on_open_model_button() throws Throwable {
        driverServices.getButtonHelper().click(By.xpath("//button[text()='Click To Open Modal']"));
    }

    @Then("^Alerts_It should open bootstrap popup$")
    public void alerts_it_should_open_bootstrap_popup() throws Throwable {
       WebDriverWait wait = getWait(driver,readConfigFile.getExplicitWait());
       webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Close']")));

    }

    @Then("^Alerts_I click on close button to close popup$")
    public void alerts_i_click_on_close_button_to_close_popup() throws Throwable {
         webElement.click();
    }


    @When("^Alerts_I call quit method browser will close$")
    public void alerts_i_call_quit_method_browser_will_close() throws Throwable {
       /* if(driver != null)
           driver.quit(); */
    }

    @When("^Alerts_I take screenshot of the page$")
    public void alerts_i_take_screenshot_of_the_page() throws Throwable {

    /*  File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot,new File("src.png")); */
      driverServices.getGenericHelper().takeScreenShot("Screenshot","a.png");
    }

    private WebDriverWait getWait(WebDriver driver, int timeOut){

        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        return wait;
    }


}
