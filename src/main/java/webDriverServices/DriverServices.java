package webDriverServices;

import customConfiguration.BrowserConfiguration;
import customConfiguration.CustomChromeDriver;
import customConfiguration.CustomFirefoxDriver;
import customConfiguration.CustomInternetExplorerDriver;
//import com.WebDriver.helperFunctions.*;
import utilsPackage.IReader;
import utilsPackage.ReadConfigProperties;
import helperFunctions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

public class DriverServices {

    private WebDriver driver;
    private CustomChromeDriver chromeDriver;
    private BrowserHelper browserHelper;
    private ButtonHelper buttonHelper;
    private WindowHelper windowHelper;
    private AlertHelper alertHelper;
    private TextBoxHelper textBoxHelper;
    private DropDownHelper dropDownHelper;
    private IReader reader;
    private GenericHelper genericHelper;
    private BrowserConfiguration browserConfiguration;
    private JavascriptHelper javascriptHelper;

    public void launchBrowser(){

      //chromeDriver = new CustomChromeDriver();
        reader = new ReadConfigProperties();
     // driver = chromeDriver.getChromeDriver();
        driver = getBrowserDriver();
        buttonHelper = ButtonHelper.getInstance(getDriver());
        browserHelper = BrowserHelper.getInstance(getDriver());
        windowHelper = WindowHelper.getInstance(getDriver());
        alertHelper = AlertHelper.getInstance(getDriver());
        textBoxHelper = TextBoxHelper.getInstance(getDriver());
        dropDownHelper = DropDownHelper.getInstance(getDriver());
        genericHelper = GenericHelper.getInstance(getDriver());
        javascriptHelper = JavascriptHelper.getInstance(getDriver());

        browserHelper.maximizePage();

    }

    private WebDriver getBrowserDriver() {

        switch (reader.getBrowserType()){
          case BrowserType.CHROME:
          /*CustomChromeDriver chromeDriver = new CustomChromeDriver();
            return chromeDriver.getChromeDriver();*/
          browserConfiguration = new CustomChromeDriver();
          return browserConfiguration.getBrowserDriver();

          case BrowserType.FIREFOX:
           browserConfiguration = new CustomFirefoxDriver();
           return browserConfiguration.getBrowserDriver();

           case BrowserType.IE:
           browserConfiguration = new CustomInternetExplorerDriver();
           return browserConfiguration.getBrowserDriver();

           default:
                throw new RuntimeException("Invalid browser type" +reader.getBrowserType());
        }
    }

    public DriverServices(){

        launchBrowser();
    }

    public GenericHelper getGenericHelper() {return genericHelper; }

    public WebDriver getDriver() {
        return driver;
    }

    public CustomChromeDriver getChromeDriver() {
        return chromeDriver;
    }

    public BrowserHelper getBrowserHelper() {
        return browserHelper;
    }

    public DropDownHelper getDropDownHelper() {
        return dropDownHelper;
    }

    public TextBoxHelper getTextBoxHelper() {
        return textBoxHelper;
    }

    public ButtonHelper getButtonHelper() {
        return buttonHelper;
    }

    public WindowHelper getWindowHelper() {
        return windowHelper;
    }

    public AlertHelper getAlertHelper() {
        return alertHelper;
    }

    public IReader getIReader() {
        return reader;
    }

    public JavascriptHelper getJavascriptHelper(){
        return javascriptHelper;
    }
}
