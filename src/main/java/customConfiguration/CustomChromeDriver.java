package customConfiguration;

import utilsPackage.ResourceUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomChromeDriver implements BrowserConfiguration {

//  private void setDriverExecutable(){
////      String Chrome_Path = ResourceUtils.getResourcePath("chromedriver.exe");
////      System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,Chrome_Path) ;
//       //  System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,"D:\\MavenCuc\\chromedriver.exe") ;
//      // CHROME_DRIVER_EXE_PROPERTY - contains "webdriver.chrom.driver property"//
//
//      WebDriverManager.chromedriver().setup();
//  }

  private ChromeOptions getChromeOptions(){

      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.setAcceptInsecureCerts(true);
      return chromeOptions;
  }

  public WebDriver getChromeDriver(){
      //setDriverExecutable();
	  WebDriverManager.chromedriver().setup();
	  System.setProperty("webdriver.chrome.silentOutput", "true");
      ChromeOptions options = getChromeOptions();
      ChromeDriver chromeDriver = new ChromeDriver(options);
      return chromeDriver;
  }


    @Override
    public WebDriver getBrowserDriver() {
        return getChromeDriver();
    }
}
