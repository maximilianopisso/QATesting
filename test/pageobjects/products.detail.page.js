const BasePage = require('./base.page');

/**
 * sub page containing specific selectors and methods for a specific page
 */
class ProductsDetailPage extends BasePage {
    /**
     * Se definen los selectors
     */
    get productModel() { return $("//h2[@class='name']"); }

    get productPrice() { return $("//h3[@class='price-container']"); }

    get addToCart() { return $("//a[normalize-space()='Add to cart']"); }

    /**
     * Obtiene el texto del nombre del modelo
     * 
     */
    async getModel() {

        return (await this.getTextFromWebElement(this.productModel))
    }

    /**
     * Devuelve el numero entero que representa el precio del producto
     * 
     */
    async getPrice() {
        const priceText = await this.getTextFromWebElement(this.productPrice);
        const inicioPrice = priceText.indexOf("$") + 1;
        const finPrice = priceText.indexOf("*") - 1;
        return (priceText.substring(inicioPrice, finPrice));
    }

    /**
     * Hace click en Agregar Producto
     * 
     */
    async clickToAddCart() {
        await this.clickOnWebElement(this.addToCart);
    }

}

module.exports = new ProductsDetailPage();