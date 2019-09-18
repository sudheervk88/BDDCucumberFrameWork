package scenarioRunner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilsPackage.IReader;
import webDriverServices.DriverServices;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class WebElementFunctionDefnition {
    private WebDriver driver;
    private DriverServices services;
    private WebElement element;
    private List<WebElement> webElementList;
    private IReader readConfigFile;

  public WebElementFunctionDefnition(DriverServices services){
    this.services = services;
    this.driver   = services.getDriver();
    this.readConfigFile = services.getIReader();
  }

    @Given("^WebElement Function_I open face book page \"([^\"]*)\"$")
    public void webelement_Function_I_open_face_book_page(String url) throws Throwable {
          driver.get(url);
      //  driver.get(readConfigFile.getApplicationUrl());
    }

    @When("^WebElement Function_I provide unique locator to find element$")
    public void webelement_Function_I_provide_unique_locator_to_find_element() throws Throwable {
       element = driver.findElement(By.id("email"));

    }

    @Then("^WebElement Function_I should get web element$")
    public void webelement_Function_I_should_get_web_element() throws Throwable {
         System.out.println(element.toString());
    }

    @When("^BrowserFunction_I call quit method browser will close$")
    public void browserfunction_i_call_quit_method_browser_will_close() throws Throwable {

    }

    @When("^WebElement Function_I provide non unique locator to find element$")
    public void webelement_Function_I_provide_non_unique_locator_to_find_element() throws Throwable {
        webElementList = driver.findElements(By.xpath("//input"));
    }

    @Then("^WebElement Function_I should get list of web elements$")
    public void webelement_Function_I_should_get_list_of_web_elements() throws Throwable {
             System.out.println(webElementList.size());
    }

    @When("^WebElement Function_I call send key method value \"([^\"]*)\" should enter in the text box$")
    public void webelement_Function_I_call_send_key_method_value_should_enter_in_the_text_box(String value) throws Throwable {
         /*element = driver.findElement(By.id("email"));
         element.sendKeys(value); */
         services.getTextBoxHelper().setText(By.id("email"),value);
    }

    @When("^WebElement Function_I call get text method value should return$")
    public void webelement_Function_I_call_get_text_method_value_should_return() throws Throwable {

        String value =services.getTextBoxHelper().getText(By.id("email"));
        System.out.println(value);

    }

    @When("^WebElement Function_I call clear method the value should clear$")
    public void webelement_Function_I_call_clear_method_the_value_should_clear() throws Throwable {
       // element.clear();
        services.getTextBoxHelper().clearText(By.id("email"));
    }

    @When("^WebElement Function_I click on button it should perform the click action$")
    public void webelement_Function_I_click_on_button_it_should_perform_the_click_action() throws Throwable {
       services.getButtonHelper().click(By.id("loginbutton"));
       services.getBrowserHelper().moveBackWard();
    }

    @When("^WebElement Function_I click on radio button it should get selected$")
    public void webelement_Function_I_click_on_radio_button_it_should_get_selected() throws Throwable {
        services.getButtonHelper().click(By.xpath("//label[text()='Male']"));
    }

    @When("^WebElement Function_I click on hyper link it should get open$")
    public void webelement_Function_I_click_on_hyper_link_it_should_get_open() throws Throwable {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Create a Page']")));
        services.getButtonHelper().click(By.xpath("//a[text()='Create a Page']"));
        services.getBrowserHelper().moveBackWard();
    }

    @When("^WebElement Function_I select value by visible text it should select the value$")
    public void webelement_Function_I_select_value_by_visible_text_it_should_select_the_value() throws Throwable {
        services.getDropDownHelper().selectByVisibleText(By.id("month"),"Aug");
    }

    @When("^WebElement Function_I select value by index it should select the value$")
    public void webelement_Function_I_select_value_by_index_it_should_select_the_value() throws Throwable {
        services.getDropDownHelper().selectByIndex(By.id("day"),9);
    }

    @When("^WebElement Function_I select value by value method it should select the value$")
    public void webelement_Function_I_select_value_by_value_method_it_should_select_the_value() throws Throwable {
        services.getDropDownHelper().selectByValue(By.id("year"),"2011");
    }

    @When("^WebElement Function_I call get option it should print all values in the drop down$")
    public void webelement_Function_I_call_get_option_it_should_print_all_values_in_the_drop_down() throws Throwable {
        webElementList = services.getDropDownHelper().getAllElements(By.id("month"));
        System.out.println(webElementList.size());

        for (WebElement element:webElementList) {
            System.out.println(element.getText());
        }
    }


    private WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        return  wait;
    }


  }
