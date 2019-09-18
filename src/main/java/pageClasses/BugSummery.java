package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BugSummery extends PageBase {

    public BugSummery(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    private WebDriver driver;

    @FindBy(id = "comment")
    public WebElement additionalComment;






}
