const HomePage = require('../pageobjects/home.page');
const ProductsPage = require('../pageobjects/products.page');
const ProductsDetailPage = require('../pageobjects/products.detail.page');
const CartPage = require('../pageobjects/cart.page');
const MenuPage = require('../pageobjects/menu.page');
const FormPage = require('../pageobjects/form.page');
const ConfirmPage = require('../pageobjects/confirm.page');
const URL = 'https://www.demoblaze.com/';

describe('Mi Primera Prueba Automatica con WebDriverIO', () => {
    it('Prueba Demoblaze', async () => {

        // Inicio la URL
        await HomePage.navigateTo(URL);

        // Hago click en categoria "Laptos"
        await HomePage.clickLaptopCategory();

        // Hago click la primer Laptop
        await ProductsPage.clickFirstLaptop();

        // Obtengo Modelo y Precio del Detalle del Producto. Me aseguro que sean los buscados y hago click en Add to Cart.
        const modelDetail = await ProductsDetailPage.getModel();
        const priceDetail = await ProductsDetailPage.getPrice();
        await expect(priceDetail).toEqual("790");
        await expect(modelDetail).toEqual("Sony vaio i5");
        await ProductsDetailPage.clickToAddCart();

        // Capturo el msj de la alerta, comparo msj, acepto alerta.
        await browser.pause(1000);
        if (await browser.isAlertOpen()) {
            const msjAlert = await browser.getAlertText();
            await browser.acceptAlert();
            await expect(msjAlert).toEqual("Product added");
        }

        // Navego a Seccion Cart
        await MenuPage.navegatoToSectionCart();

        // Obtengo Modelo y Precio del Cart. Comparo con los precios del Detalle del Producto y luego Hago click en Order
        const modelCart = await CartPage.getModel();
        const priceCart = await CartPage.getPrice();
        await expect(priceDetail).toEqual(priceCart);
        await expect(modelDetail).toEqual(modelCart);
        await CartPage.clickOrderButton();

        //Relleno Formulario y hago click en "Purchase"
        await FormPage.formComplete("NOMBRE", "PAIS", "CIUDAD", "TARJETA CREDITO", "MES", "AÑO");
        await FormPage.clickPurchaseButton();

        //Traigo titulo del msj de confirmacion y comparon con Thank you for your purchase!
        const tituloMsj = await ConfirmPage.getTitlePurchaseMsj();
        await expect(tituloMsj).toEqual("Thank you for your purchase!");

        //Traigo cuerpo del msj de confirmacion y comparon que este el nombre, tarjeta de credito anteriormente ingresados y precio del cart
        const paragraphMsj = await ConfirmPage.getDetailPurchaseMsj();
        await expect(paragraphMsj.includes("NOMBRE")).toBe(true);
        await expect(paragraphMsj.includes("TARJETA CREDITO")).toBe(true);
        await expect(paragraphMsj.includes(priceCart)).toBe(true);

        //Hago click en Boton "OK" del msj de confirmacion.
        browser.pause(2000);
        await ConfirmPage.clickOkButton();

        //Cierro browser
        await HomePage.closeURL();
    });
});


