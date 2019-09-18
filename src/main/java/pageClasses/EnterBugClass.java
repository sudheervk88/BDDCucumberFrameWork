package pageClasses;

import helperFunctions.ButtonHelper;
import helperFunctions.DropDownHelper;
import helperFunctions.TextBoxHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterBugClass extends PageBase{

    private WebDriver driver;
    private DropDownHelper dropDownHelper;
    private ButtonHelper buttonHelper;
    private TextBoxHelper textBoxHelper;

    public EnterBugClass(WebDriver driver){
        super(driver);
        this.driver = driver;
       // PageFactory.initElements(driver,this);
    }

    //WebElements

   @FindBy(id ="component")
   public WebElement component;

   @FindBy(id ="version")
   public WebElement version;

   @FindBy(id ="bug_severity")
   public WebElement severity;

   @FindBy(id ="rep_platform")
   public WebElement hardware;

   @FindBy(id ="op_sys")
   public WebElement operating_system;

    @FindBy(id ="priority")
    public WebElement priority;

    @FindBy(id ="short_desc")
    public WebElement summery;

    @FindBy(id ="comment")
    public WebElement description;

    @FindBy(id ="commit")
    public WebElement submit_bug_button;


    //Action

 public void provideDetails(String comp,String vrsn,String sever,String hard){
     dropDownHelper = DropDownHelper.getInstance(driver);
     dropDownHelper.selectByVisibleText(component,comp);
     dropDownHelper.selectByVisibleText(version,vrsn);
     dropDownHelper.selectByVisibleText(severity,sever);
     dropDownHelper.selectByVisibleText(hardware,hard);
 }

 public void provideOtherDetails(String os,String prio,String summ,String desc){
     textBoxHelper = TextBoxHelper.getInstance(driver);
     dropDownHelper.selectByVisibleText(operating_system,os);
     //textBoxHelper.setText(summery,summ);
     summery.sendKeys(summ);
     description.sendKeys(desc);

 }

 public PageBase clickSubmitButton(){
     BugSummery summery = new BugSummery(driver);
     submit_bug_button.click();
     WebDriverWait wait = getWait();
     wait.until(ExpectedConditions.visibilityOf(summery.additionalComment));
     return summery;
 }
    //PageNavigation


}
