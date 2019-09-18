package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageClass extends PageBase {

   private WebDriver driver;


    public HomePageClass(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

  //WebElements

   @FindBy(id = "enter_bug")
   public WebElement fileABug;

   @FindBy(id = "quicksearch_main")
   public WebElement quickSearchBox;



   //Action

    public void search(String searchKeyWord){


    }


    //Navigation

    public PageBase navigateToLoginPage(){
        LoginPageClass loginpage = new LoginPageClass(driver);
        fileABug.click();
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.elementToBeClickable(loginpage.loginButton));
        return loginpage;
    }



}
