import Data.DataProviderClass;
import Pages.*;
import Utility.PropertiesFile;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DemoblazeFinal {

    private String url = PropertiesFile.getProperty("url");
    private final int MAX_EXPLICIT_WAIT = 10;

    @BeforeTest
    public void beforeTest() {
        System.out.println(" * Execution Before Test * ");
    }

    @Test(dataProvider = "usersForTest", dataProviderClass = DataProviderClass.class)
    public void addToCartFistProductLaptops(String name, String country, String city, String creditCard, String month, String year) throws Exception {

        HomePage homePage = new HomePage();
        homePage.nativagetoHome();

        // Definicion de variables locales
        String modelProductDetail;
        String priceProductDetail;
        System.out.println("** Inicio de Test ** - User: " + name);

        // Instancias de Pages
        LaptopsPage laptopsPage = new LaptopsPage();
        ProductDetailPage productDetailPage = new ProductDetailPage();
        MenuPage menuPage = new MenuPage();
        CartPage cartPage = new CartPage();
        PlaceOrderPage placeOrderPage = new PlaceOrderPage();
        ConfirmationPage confirmationPage = new ConfirmationPage();
        Waits waits = new Waits();

        // Clickear Categoria Laptops
        homePage.clickLaptopCategory();

        // Click en la primer Laptop bajo las condiciones de precio min y max
        laptopsPage.clickLaptopInRange(780, 890);

        // Obtengo el modelo y precio del articulo e imprimo en consola
        modelProductDetail = productDetailPage.getModel();
        priceProductDetail = productDetailPage.getPrice();

        // Agrego al cart el producto seleccionado
        productDetailPage.clickAddToCart();

        // Espero a la presencia del alert, retorno testo y lo con el texto esperado "producto agregado"
        Assert.assertEquals("Product added", waits.waitForAlert(), "NO SE ENCONTRO MESAJE DE PRODUCTO AGREGADO");

        // Ingreso Tab Cart
        menuPage.navigateToCart();

        // Obtengo titulo y precio
        Assert.assertEquals(modelProductDetail, cartPage.getTittle(), "NO COINCIDEN NOMBRES DE MODELO DEL DETALLE Y EL CART");
        Assert.assertEquals(priceProductDetail, cartPage.getPrice(), "NO COINCIDEN PRECIOS DEL DETALLE Y CART");

        //Click Place Order
        cartPage.clickOrder();

        //Completar Formulario de Compra y Click en "Purchase"
        placeOrderPage.formComplete(name, country, city, creditCard, month, year);
        placeOrderPage.clickPurchase();

        //Comparo texto de la confirmacion de compra y doy click al boton "OK"
        Assert.assertEquals(confirmationPage.getTitle(), "Thank you for your purchase!", "NO COINCIDE MENSAJE DE AGREDECIMIENTO POR COMPRA");
        Assert.assertTrue(confirmationPage.getDetailPurchase().contains(name), "NO COINCIDE NOMBRE");
        Assert.assertTrue(confirmationPage.getDetailPurchase().contains(creditCard), "NO COINCIDE TARJETA DE CREDITO");
        Assert.assertTrue(confirmationPage.getDetailPurchase().contains(priceProductDetail), "NO COINCIDE PRECIO");
        confirmationPage.clickOkButton();
    }

    @AfterTest
    public void AfterTest() {
        System.out.println(" * Execution After Test * ");
        HomePage homePage = new HomePage();
        homePage.quit();
    }
}