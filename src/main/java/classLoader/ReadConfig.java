package classLoader;

import java.io.*;
import java.util.Properties;

public class ReadConfig {


    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();
        InputStream inputStream = new FileInputStream(new File("D:\\MavenCuc\\src\\main\\resources\\config.properties"));
        prop.load(inputStream);
        System.out.println(prop.getProperty("Browser"));
        System.out.println(prop.getProperty("BaseUrl"));
        System.out.println(prop.getProperty("ExplicitWait"));



    }
}
