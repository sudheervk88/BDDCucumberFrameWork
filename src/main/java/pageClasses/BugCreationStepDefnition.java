package pageClasses;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import webDriverServices.DriverServices;

import java.util.List;

public class BugCreationStepDefnition {

    private WebDriver driver;
    private DriverServices driverServices;
    private HomePageClass homePage;
    private LoginPageClass loginPage;
    private EnterBugClass enterBug;
    private BugSummery bugSummery;


    public BugCreationStepDefnition(DriverServices driverServices){
        this.driverServices = driverServices;
        this.driver = driverServices.getDriver();

    }


    @Given("^Bugzilla_I am at buzilla home page$")
    public void bugzilla_i_am_at_buzilla_home_page() throws Throwable {
        driver.get(driverServices.getIReader().getApplicationUrl());
        homePage = new HomePageClass(driver);

    }

    @Then("^Bugzilla_I click on file a bug and navigate to login page$")
    public void bugzilla_i_click_on_file_a_bug_and_navigate_to_login_page() throws Throwable {
        loginPage = (LoginPageClass)homePage.navigateToLoginPage();
    }

    @Then("^Bugzilla_I log into the application and navigate to enter bug page$")
    public void bugzilla_i_log_into_the_application_and_navigate_to_enter_bug_page() throws Throwable {
         enterBug = (EnterBugClass)loginPage.performLogin(driverServices.getIReader().getUserName(),driverServices.getIReader().getPassword());
    }

    @Then("^Bugzilla_I provide the details component as \"([^\"]*)\" version as \"([^\"]*)\" severity as \"([^\"]*)\" hardware as \"([^\"]*)\"$")
    public void bugzilla_i_provide_the_details_component_as_version_as_severity_as_hardware_as(String comp, String vrsn,String sever, String hard) throws Throwable {
         enterBug.provideDetails(comp,vrsn,sever,hard);
    }

    @Then("^Bugzilla_I provide other details like operating system as \"([^\"]*)\" priority as \"([^\"]*)\" summery as \"([^\"]*)\" description as \"([^\"]*)\"$")
    public void bugzilla_i_provide_other_details_like_operating_system_as_priority_as_summery_as_description_as(String os, String prio, String summ, String desc) throws Throwable {
         enterBug.provideOtherDetails(os,prio,summ,desc);
    }

    @Then("^Bugzilla_I select submit bug button$")
    public void bugzilla_i_select_submit_bug_button() throws Throwable {
        bugSummery = (BugSummery) enterBug.clickSubmitButton();
    }

    @Then("^Bugzilla_I am at summery page and i click logout button$")
    public void bugzilla_i_am_at_summery_page_and_i_click_logout_button() throws Throwable {
            bugSummery.logoutFromApplication();
    }

    @Then("^Bugzilla_I check the page title$")
    public void bugzilla_i_check_the_page_title(DataTable table) throws Throwable {
        List<List<String>> list = table.raw();
        Assert.assertEquals(driver.getTitle(),list.get(0).get(0));
    }




}
