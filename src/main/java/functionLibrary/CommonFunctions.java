package functionLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;

public class CommonFunctions {

    public static WebDriver driver;
    //public static String propertyFilePath = new File("src/main/resources/testData/config.properties").getAbsolutePath();
    public void openBrowser()
    {
        WebDriverManager.safaridriver().setup();
        driver =new SafariDriver();
    }

    public void closeBrowser()
    {
        driver.quit();
    }
}
