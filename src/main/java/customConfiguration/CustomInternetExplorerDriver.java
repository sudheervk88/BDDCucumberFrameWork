package customConfiguration;

import utilsPackage.ResourceUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.ElementScrollBehavior;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class CustomInternetExplorerDriver implements BrowserConfiguration{

    private void setDriverExecutable(){
        String IE_Path = ResourceUtils.getResourcePath("IEDriverServer.exe");
        System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,IE_Path);
     //   System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,"D:\\MavenCuc\\IEDriverServer.exe");
    }


    private InternetExplorerOptions getIeOption(){

        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.destructivelyEnsureCleanSession();
        internetExplorerOptions.ignoreZoomSettings();
        internetExplorerOptions.introduceFlakinessByIgnoringSecurityDomains();
        internetExplorerOptions.elementScrollTo(ElementScrollBehavior.BOTTOM);
        return internetExplorerOptions;
    }

    public WebDriver getIeDriver(){

        setDriverExecutable();
        InternetExplorerOptions internetExplorerOptions = getIeOption();
        InternetExplorerDriver internetExplorerDriver = new InternetExplorerDriver(internetExplorerOptions);
        return internetExplorerDriver;
    }

    @Override
    public WebDriver getBrowserDriver() {
        return getIeDriver();
    }
}
