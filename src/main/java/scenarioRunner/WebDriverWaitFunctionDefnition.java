package scenarioRunner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import customConfiguration.CustomChromeDriver;
import helperFunctions.BrowserHelper;
import helperFunctions.ButtonHelper;
import helperFunctions.TextBoxHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class WebDriverWaitFunctionDefnition  {

      private WebDriver driver;
      private ButtonHelper buttonHelper;
      private BrowserHelper browserHelper;
      private TextBoxHelper textBoxHelper;
      private WebElement webElement;


    @Given("^WebdriverWaitFunction_I open face book home page \"([^\"]*)\"$")
    public void webdriverwaitfunction_i_open_face_book_home_page(String url) throws Throwable {

        CustomChromeDriver chromeDriver = new CustomChromeDriver();
        driver = chromeDriver.getChromeDriver();
        buttonHelper = ButtonHelper.getInstance(driver);
        browserHelper = BrowserHelper.getInstance(driver);
        textBoxHelper = TextBoxHelper.getInstance(driver);
        browserHelper.maximizePage();
        driver.get(url);

    }

    @When("^WebdriverWaitFunction_I wait \"([^\"]*)\" milli second$")
    public void webdriverwaitfunction_i_wait_milli_second(String delay) throws Throwable {
         Thread.sleep(Integer.parseInt(delay));
    }

    @Then("^WebdriverWaitFunction_I click on login button$")
    public void webdriverwaitfunction_i_click_on_login_button() throws Throwable {
         buttonHelper.click(By.id("loginbutton"));
         browserHelper.moveBackWard();
        }

    @When("^WebdriverWaitFunction_I call quit method browser will close$")
    public void webdriverwaitfunction_i_call_quit_method_browser_will_close() throws Throwable {
            if(driver != null)
                driver.quit();
    }

    @When("^WebdriverWaitFunction_I wait \"([^\"]*)\" second , it should wait (\\d+)s for the element$")
    public void webdriverwaitfunction_i_wait_second_it_should_wait_s_for_the_element(String delay, int arg2) throws Throwable {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt("0"), TimeUnit.SECONDS);
    }

    @Then("^WebdriverWaitFunction_I send \"([^\"]*)\" to the user name$")
    public void webdriverwaitfunction_i_send_to_the_user_name(String text) throws Throwable {
       textBoxHelper.setText(By.id("email"),text);
    }

    @When("^WebdriverWaitFunction_I provide the dynamic wait with polling duration (\\d+)ms and time out duration as (\\d+)s$")
    public void webdriverwaitfunction_i_provide_the_dynamic_wait_with_polling_duration_ms_and_time_out_duration_as_s(int pollingDuration, int timeOutInSeconds) throws Throwable {

        WebDriverWait webDriverWait = new WebDriverWait(driver,timeOutInSeconds);
        webDriverWait.pollingEvery(pollingDuration,TimeUnit.SECONDS);
        webDriverWait.ignoring(NoSuchElementException.class);
       // webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginbutton")));
      //  webDriverWait.until(customWait());
      //  webElement = webDriverWait.until(customWaitOnElement());
        webElement = webDriverWait.until(elementIsVisible(By.id("loginbutton")));
        System.out.println(webElement.getText());


    }


    private Function<WebDriver, Boolean> customWait(){
         Function<WebDriver,Boolean> wait = new Function<WebDriver, Boolean>() {
             @Override
            public Boolean apply(WebDriver t) {
              if(t.findElements(By.id("loginbutton")).size()>=1){
                  System.out.println("Element located");
                  return true;
              }
                 else
                  System.out.println("Waiting for the element");
                    return false;
             }
         };

        return wait;
    }

    private Function<WebDriver, WebElement> customWaitOnElement(){
        Function<WebDriver, WebElement> wait = new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver t) {
                if (t.findElements(By.id("loginbutton")).size() >= 1) {
                    System.out.println("Element located");
                    return t.findElement(By.id("loginbutton"));
                } else
                    System.out.println("Waiting for the element");
                    return null;
            }

        };

































         return wait;

    }

    private Function<WebDriver, WebElement> elementIsVisible(By locator){

        Function<WebDriver, WebElement> wait = new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                if (webDriver.findElements(locator).size() >= 1) {
                    System.out.println("Element located");
                    return webDriver.findElement(locator);
                } else
                    System.out.println("Waiting for the element");
                return null;

            }
        };

        return wait;
    }


}
