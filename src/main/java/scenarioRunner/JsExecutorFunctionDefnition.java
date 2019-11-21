package scenarioRunner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilsPackage.IReader;
import webDriverServices.DriverServices;

import java.util.List;

public class JsExecutorFunctionDefnition {

    private WebDriver driver;
    private DriverServices services;
    private WebElement element;
    private List<WebElement> webElementList;
    private IReader readConfigFile;


    public JsExecutorFunctionDefnition(DriverServices services){
        this.services = services;
        this.driver   = services.getDriver();
        this.readConfigFile = services.getIReader();
    }

    @Given("^JS Function_I navigate to google page \"([^\"]*)\"$")
    public void js_Function_I_navigate_to_google_page(String url) throws Throwable {
        driver.get(url);
    }

    @When("^JS Function_I click on Sign in button$")
    public void js_Function_I_click_on_Sign_in_button() throws Throwable {
        services.getJavascriptHelper().jscriptExecutor("arguments[0].click();",By.xpath("//a[@title='Google apps']"));
    }



}
