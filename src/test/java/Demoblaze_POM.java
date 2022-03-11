import Pages.*;
import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class Demoblaze_POM {

    private String url = PropertiesFile.getProperty("url");
    private WebDriver driver = DriverFactory.getDriver();

    @Test
    public void addToCartFistProductLaptops() throws InterruptedException {
        // definicion de variables locales
        String modelo;
        String precio;

        // Instancias de Pages
        IndexPage indexPage = new IndexPage(driver);
        LaptopsPage laptopsPage = new LaptopsPage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        MenuPage menuPage = new MenuPage(driver);
        WaitsPage waitsPage = new WaitsPage(driver);

        driver.manage().window().maximize();
        driver.navigate().to(url);

        //Clickear Categoria Laptops
        indexPage.clickLaptopCategory();

        //Esperar al que el primer producto sea clicleable y hacerle click
        laptopsPage.clickFirstLaptop(10);

        //Obtengo modelo y precio del articulo e imprimo en consola
        modelo = productDetailPage.getModel();
        precio = productDetailPage.getPrice();
        System.out.println("Modelo: " + modelo + "\n" + "Precio: " + precio);

        //Agrego al cart el producto seleccionado
        productDetailPage.clickAddToCart();

        //Espero a que aparezca la alerta, obtengo su texto y la acepto.
        waitsPage.explicitWaitAlertPresent(5);
        Alert alert = driver.switchTo().alert();
        String alertmessage = alert.getText();
        alert.accept();

        //Compara texto de la alerta con el texto esperado "producto agregado"
        Assert.assertEquals("Product added", alertmessage);

        //Ingreso Tab Cart
        menuPage.navigateToCart();

        //Espero hasta que se muestre el producto agregado
        waitsPage.explicitWaitIsClickeable(driver.findElement(By.xpath("//tr[@class='success']//td//img")), 5);

        //Cierro Navegador
        driver.quit();

    }
}
