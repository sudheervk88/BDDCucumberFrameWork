package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageClass extends PageBase {

    private WebDriver driver;

    public LoginPageClass(WebDriver driver){
        super(driver);
        this.driver = driver;
       // PageFactory.initElements(driver,this);
    }

    //WebElements

    @FindBy(id = "Bugzilla_login")
    public WebElement userName;

    @FindBy(id = "Bugzilla_password")
    public WebElement password;

    @FindBy(id = "log_in")
    public WebElement loginButton;


    //Action


    //Navigation
    public PageBase performLogin(String user, String pass){
        EnterBugClass enterbugClass = new EnterBugClass(driver);
        WebDriverWait wait = getWait();
        userName.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(enterbugClass.submit_bug_button));
        return enterbugClass;
    }





}
