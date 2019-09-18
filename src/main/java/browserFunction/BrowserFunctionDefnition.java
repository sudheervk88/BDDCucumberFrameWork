package browserFunction;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helperFunctions.BrowserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFunctionDefnition {

   private WebDriver driver;
   private WebDriver.Navigation navigate;
   private BrowserHelper browserHelper;

    @Given("^BrowserFunction_I have chrome driver instance$")
    public void browserfunction_i_have_chrome_driver_instance() throws Throwable {
        System.setProperty("webdriver.chrom.driver","D:\\MavenCuc\\chromedriver.exe") ;
        driver = new ChromeDriver();
        browserHelper = BrowserHelper.getInstance(driver);
    }

    @Given("^BrowserFunction_I navigate to \"([^\"]*)\"$")
    public void browserfunction_i_navigate_to(String url) throws Throwable {
        driver.get(url);
    }

    @When("^BrowserFunction_I call quit method browser will close$")
    public void browserfunction_i_call_quit_method_browser_will_close() throws Throwable {
        if(driver != null)
        driver.quit();
    }

    @Then("^BrowserFunction_I call back api$")
    public void browserfunction_i_call_back_api() throws Throwable {
        browserHelper.moveBackWard();
    }

    @Then("^BrowserFunction_I call forward api$")
    public void browserfunction_i_call_forward_api() throws Throwable {
        browserHelper.moveForward();
    }

    @Then("^BrowserFunction_I call refresh api$")
    public void browserfunction_i_call_refresh_api() throws Throwable {
        browserHelper.refreshPage();
    }
    @When("^BrowserFunction_I maximize the browser$")
    public void browserfunctioni_maximize_the_browser() throws Throwable {
        browserHelper.maximizePage();
    }


  }
