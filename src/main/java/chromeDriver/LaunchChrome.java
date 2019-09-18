package chromeDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrom.driver","D:\\MavenCuc\\chromedriver.exe") ;
        ChromeDriver driver = new ChromeDriver();
        System.out.println(driver.toString());

    }


}
