package customConfiguration;

import utilsPackage.ResourceUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomFirefoxDriver implements BrowserConfiguration{
    private void setDriverExecutable(){
        String Firefox_Path = ResourceUtils.getResourcePath("geckodriver.exe");
        System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY,Firefox_Path) ;
      //  System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY,"D:\\MavenCuc\\geckodriver.exe") ;
    }

    private FirefoxOptions getFirefoxOption(FirefoxProfile firefoxProfile){

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(firefoxProfile);
        firefoxOptions.setAcceptInsecureCerts(true);
        return firefoxOptions;
    }

    private FirefoxProfile getFirefoxProfile(){

        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setAcceptUntrustedCertificates(true);
        firefoxProfile.setAssumeUntrustedCertificateIssuer(true);
        return firefoxProfile;
    }

    public WebDriver getFirefoxDriver(){
       // setDriverExecutable();
    	WebDriverManager.firefoxdriver().setup();
    	System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
        FirefoxProfile firefoxProfile = getFirefoxProfile();
        FirefoxOptions firefoxOptions = getFirefoxOption(firefoxProfile);
        FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
        return firefoxDriver;
    }

    @Override
    public WebDriver getBrowserDriver() {
        return getFirefoxDriver();
    }
}
