import Pages.*;
import Utility.PropertiesFile;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class DemoblazeTestNG {

    private String url = PropertiesFile.getProperty("url");
   // private WebDriver driver = DriverFactory.getDriver();
    private final int MAX_EXPLICIT_WAIT = 10;

    @BeforeTest
    public void beforeTest() {
        System.out.println(" * Execution Before Test * ");
        HomePage homePage = new HomePage();
        homePage.nativagetoHome();
    }

    @Test
    public void addToCartFistProductLaptops() throws Exception {

        // Definicion de variables locales
        String modelo;
        String precio;

        // Instancias de Pages
        HomePage homePage = new HomePage();
        LaptopsPage laptopsPage = new LaptopsPage();
        ProductDetailPage productDetailPage = new ProductDetailPage();
        MenuPage menuPage = new MenuPage();
        CartPage cartPage = new CartPage();
        PlaceOrderPage placeOrderPage =new PlaceOrderPage();
        ConfirmationPage confirmationPage = new ConfirmationPage();
        Waits waits = new Waits();

        // Clickear Categoria Laptops
        homePage.clickLaptopCategory();

        // Click en la primer Laptop bajo las condiciones de precio min y max
        laptopsPage.obtenerLaptops(700,800);
        //laptopsPage.clickFirstLaptop();

        // Obtengo el modelo y precio del articulo e imprimo en consola
        modelo = productDetailPage.getModel();
        precio = convertirAPrecio(productDetailPage.getPrice());
        System.out.println("- Product Detail Info -" + "\n" + "Modelo: " + modelo + "\n" + "Precio: " + precio);

        // Agrego al cart el producto seleccionado
        productDetailPage.clickAddToCart();

        // Espero a la presencia del alert, retorno testo y lo con el texto esperado "producto agregado"
        Assert.assertEquals("Product added", waits.waitForAlert());

        // Ingreso Tab Cart
        menuPage.navigateToCart();

        // Obtengo titulo y precio
        System.out.println("- Cart Info -" + "\n" +"Título: " + cartPage.getTittle() +"\n"+ "Precio: " + cartPage.getPrice());
        Assert.assertEquals(modelo, cartPage.getTittle());
        Assert.assertEquals(precio, cartPage.getPrice());

        //Click Place Order
        cartPage.clickOrder();

        //Completar Formulario de Compra y Click en "Purchase"
        placeOrderPage.formComplete("Maximiliano", "Argentina","Rosario","4555990015746584","12","2022");
        placeOrderPage.clickPurchase();

        //Comparo texto de la confirmacion de compra y doy click al boton "OK"
        Assert.assertEquals(confirmationPage.getTitle(),"Thank you for your purchase!");
        confirmationPage.clickOkButton();
    }

    @AfterTest
    public void AfterTest() {
        System.out.println(" * Execution After Test * ");
        // Cierro Navegador
        HomePage homePage = new HomePage();
        homePage.quit();
    }

    public String convertirAPrecio(String price) {
        int finPrecio = price.indexOf("*") - 1;
        return (price.substring(1, finPrecio));
    }


}