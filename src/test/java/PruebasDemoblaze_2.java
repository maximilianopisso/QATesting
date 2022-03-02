import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PruebasDemoblaze_2 {

    private String url = PropertiesFile.getProperty("url");
    private WebDriver driver = DriverFactory.getDriver();

    @Test
    public void addToCart() throws InterruptedException {
        String modelo;
        String precio;

        driver.manage().window().maximize();
        driver.navigate().to(url);

        driver.findElement(By.linkText("Laptops")).click();
        driver.wait(10000);
        //driver.findElement(By.cssSelector("")).click();

        modelo = driver.findElement(By.cssSelector("h2.name")).getText();
        precio = driver.findElement(By.cssSelector("h3.price-container")).getText();
        System.out.println("Modelo:" + modelo + "Precio:" + precio );

        driver.findElement(By.linkText("Add to cart")).click();
        //Assert.assertEquals("STORE", driver.getTitle());
        driver.quit();

    }
}
