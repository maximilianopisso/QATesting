package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver driver;
    public static String driverPath = "./src/main/resources/drivers/";
    private static String browser;

    public static WebDriver getDriver() {

        browser = PropertiesFile.getProperty("browser");
        if( browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
            driver = new ChromeDriver();
        } else if(browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
            driver = new FirefoxDriver();
        } else if(browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", driverPath + "msedgedriver.exe");
            driver = new EdgeDriver();
        }
        //Configuracion de espera implicita en el driver
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Tiempo implicit Wait: " + driver.manage().timeouts().getImplicitWaitTimeout());
        return driver;
    }
}
