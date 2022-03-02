import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
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
        Thread.sleep(2000);
        driver.findElement(By.linkText("Sony vaio i5")).click();
        Thread.sleep(2000);
        modelo = driver.findElement(By.cssSelector("h2.name")).getText();
        precio = driver.findElement(By.cssSelector("h3.price-container")).getText();
        System.out.println("Modelo:" + modelo + "Precio:" + precio );
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);

        //Me creo alerta para leer alert de la web
        Alert alert = driver.switchTo().alert();
        String alertmessage = alert.getText();

        Assert.assertEquals("Product added", alertmessage);
        driver.quit();

    }
}
