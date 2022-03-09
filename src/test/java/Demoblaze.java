import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Demoblaze {

    private String url = PropertiesFile.getProperty("url");
    private WebDriver driver = DriverFactory.getDriver();

    @Test
    public void addToCartFistProductLaptops() {
        // definicion de variables locales
        String modelo;
        String precio;

        //definicion de locators
        By firstProduct = By.xpath("//div[@id='tbodyid']//div[1]//div[1]//a[1]//img");
        By laptopCategory = By.linkText("Laptops");
        By price = By.cssSelector("h2.name");
        By model = By.cssSelector("h3.price-container");

        driver.manage().window().maximize();
        driver.navigate().to(url);

        //Clickear Categoria Laptops
        driver.findElement(laptopCategory).click();

        //Esperar al que el primer producto sea clicleable y hacerle click
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        driver.findElement(firstProduct).click();

       //Obtengo modelo y precio del articulo e imprimo en consola
        modelo = driver.findElement(price).getText();
        precio = driver.findElement(model).getText();
        System.out.println("Modelo:" + modelo + "Precio:" + precio );

        //Agrego al cart el producto seleccionado
        driver.findElement(By.linkText("Add to cart")).click();

        //Espero a que aparezca la alerta, obtengo su texto y la acepto.
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertmessage = alert.getText();
        alert.accept();

        //Compara texto de la alerta con el texto esperado "producto agregado"
        Assert.assertEquals("Product added", alertmessage);

        //Cierro Navegador
        driver.quit();

    }
}
