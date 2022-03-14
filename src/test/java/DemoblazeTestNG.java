import Pages.*;
import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class DemoblazeTestNG {

    private String url = PropertiesFile.getProperty("url");
    private WebDriver driver = DriverFactory.getDriver();
    private final int MAX_EXPLICIT_WAIT = 10;
    @BeforeTest
    public void beforeTest() {
        System.out.println(" * Execution Before Test * ");
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

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
        PlaceOrderPage placeOrderPage =new PlaceOrderPage(driver);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);

        // Clickear Categoria Laptops
        indexPage.clickLaptopCategory();

        // Espera a que sea clicleable y le hace click

     /*   List<WebElement> listado = new ArrayList<WebElement>();
        listado = laptopsPage.obtenerLaptops();

        listado.forEach(webElement -> System.out.println(webElement.getText()));*/

        laptopsPage.clickFirstLaptop(MAX_EXPLICIT_WAIT);

        // Obtengo modelo y precio del articulo e imprimo en consola
        modelo = productDetailPage.getModel();
        precio = convertirAPrecio(productDetailPage.getPrice());
        System.out.println("- Product Detail Info -" + "\n" + "Modelo: " + modelo + "\n" + "Precio: " + precio);

        // Agrego al cart el producto seleccionado
        productDetailPage.clickAddToCart();

        // Espero a que aparezca la alerta, obtengo su texto y la acepto.
        WebDriverWait wait = new WebDriverWait(driver, MAX_EXPLICIT_WAIT);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertmessage = alert.getText();
        alert.accept();

        // Compara texto de la alerta con el texto esperado "producto agregado"
        Assert.assertEquals("Product added", alertmessage);

        // Ingreso Tab Cart
        menuPage.navigateToCart();

        // Obtengo titulo y precio
        System.out.println("- Cart Info -" + "\n" +"Título: " + cartPage.getTittle(MAX_EXPLICIT_WAIT) +"\n"+ "Precio: " + cartPage.getPrice(10));
        Assert.assertEquals(modelo, cartPage.getTittle(MAX_EXPLICIT_WAIT));
        Assert.assertEquals(precio, cartPage.getPrice(MAX_EXPLICIT_WAIT));

        cartPage.clickOrder(MAX_EXPLICIT_WAIT);

        //Completar Formulario de Compra y Click en "Purchase"
        placeOrderPage.formComplete(MAX_EXPLICIT_WAIT);
        placeOrderPage.clickPurchase();

        //De la confirmacion de compra obtengo el texto y doy click al boton "OK"
        Assert.assertEquals(confirmationPage.getTitte(MAX_EXPLICIT_WAIT),"Thank you for your purchase!");
        confirmationPage.clickOkButton(MAX_EXPLICIT_WAIT);
    }

    @AfterTest
    public void AfterTest() {
        System.out.println(" * Execution After Test * ");
        // Cierro Navegador
        driver.quit();
    }

    public String convertirAPrecio(String price) {
        int finPrecio = price.indexOf("*") - 1;
        return (price.substring(1, finPrecio));
    }
}