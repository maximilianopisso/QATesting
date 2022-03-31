const BasePage = require('./base.page');

/**
 * sub page containing specific selectors and methods for a specific page
 */
class CartPage extends BasePage {
    /**
     * Se definen los selectors
     */
    get productModel() { return $("//tr[@class='success']//td[2]"); }
    get productPrice() { return $("//tr[@class='success']//td[3]"); }
    get orderButton() { return $("//button[text()='Place Order']"); }

    async getModel() {
        return (await this.getTextFromWebElement(this.productModel))
    }

    async getPrice() {
        return (await this.getTextFromWebElement(this.productPrice));
    }

    async clickOrderButton() {
        await this.clickOnWebElement(this.orderButton);
    }
}

module.exports = new CartPage();