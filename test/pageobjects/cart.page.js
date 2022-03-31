const BasePage = require('./base.page');

/**
 * sub page containing specific selectors and methods for a specific page
 */
class CartPage extends BasePage {
    /**
     * Se definen los selectors
     */
    get productModel() {return $("//tr[@class='success']//td[2]");}

    get productPrice() {return $("//tr[@class='success']//td[3]");}

    get orderButton() {return $("//button[text()='Place Order']");}

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
        return (await this.getTextFromWebElement(this.productPrice));
    }

    /**
     * Hace click en Agregar Producto
     * 
     */
    async clickOrderButton() {
        await this.clickOnWebElement(this.orderButton);
    }
}

module.exports = new CartPage();