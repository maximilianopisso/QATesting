const BasePage = require('./base.page');

/**
 * sub page containing specific selectors and methods for a specific page
 */
class ProductsDetailPage extends BasePage {
    /**
     * Se definen los selectors
     */
    get productModel() {return $("//h2[@class='name']");}

    get productPrice() {return $("//h3[@class='price-container']");}

    get addToCart() {return $("//a[normalize-space()='Add to cart']");}


    /**
     * Obtiene el texto del nombre del modelo
     * 
     */
    async getModel() {
        return  await this.productModel.getText()
        //return await this.getTextFromWebElement(this.productModel)
    }

    /**
     * Devuelve el numero entero que representa el precio del producto
     * 
     */
    async getPrice() {
        priceText = getTextFromWebElement(this.productPrice);
        console.log(priceText);
        //inicioPrice = priceText.indexOf("$") + 1;
        //finPrice = priceText.indexOf("*") - 1;
        return (priceText.substring(1, 4));
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