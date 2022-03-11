import Pages.*;
import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Demoblaze_POM {

    private String url = PropertiesFile.getProperty("url");
    private WebDriver driver = DriverFactory.getDriver();

    @Test
    public void addToCartFistProductLaptops() throws InterruptedException {

        // Definicion de variables locales
        String modelo;
        String precio;

        // Instancias de Pages
        IndexPage indexPage = new IndexPage(driver);
        LaptopsPage laptopsPage = new LaptopsPage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        MenuPage menuPage = new MenuPage(driver);
        CartPage cartPage = new CartPage(driver);

        driver.manage().window().maximize();
        driver.navigate().to(url);

        // Clickear Categoria Laptops
        indexPage.clickLaptopCategory();

        // Espera a que sea clicleable y le hace click
        laptopsPage.clickFirstLaptop(10);

        // Obtengo modelo y precio del articulo e imprimo en consola
        modelo = productDetailPage.getModel();
        precio = productDetailPage.getPrice();
        System.out.println("Modelo: " + modelo + "\n" + "Precio: " + precio);

        // Agrego al cart el producto seleccionado
        productDetailPage.clickAddToCart();

        // Espero a que aparezca la alerta, obtengo su texto y la acepto.
        WebDriverWait wait = new WebDriverWait(driver, 10 );
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertmessage = alert.getText();
        alert.accept();

        // Compara texto de la alerta con el texto esperado "producto agregado"
        Assert.assertEquals("Product added", alertmessage);

        // Ingreso Tab Cart
        menuPage.navigateToCart();

        // Espero hasta que se muestre el producto agregado y compruebo que se muestre en el carrito
        Assert.assertTrue(cartPage.imageProductIsVisible(10));

        // Cierro Navegador
        driver.quit();
    }
}
