import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PruebasDemoblaze {

    private String url = PropertiesFile.getProperty("url");
    private WebDriver driver = DriverFactory.getDriver();

    @Test
    public void navegarToHome() {
        driver.manage().window().maximize();
        driver.navigate().to(url);
        Assert.assertEquals("STORE", driver.getTitle());
        driver.quit();
    }
}
