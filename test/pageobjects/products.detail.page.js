const BasePage = require('./base.page');

/**
 * sub page containing specific selectors and methods for a specific page
 */
class ProductsDetailPage extends BasePage {

    get productModel() { return $("//h2[@class='name']"); }
    get productPrice() { return $("//h3[@class='price-container']"); }
    get addToCart() { return $("//a[normalize-space()='Add to cart']"); }

    async getModel() {

        return (await this.getTextFromWebElement(this.productModel))
    }

    async getPrice() {
        const priceText = await this.getTextFromWebElement(this.productPrice);
        const inicioPrice = priceText.indexOf("$") + 1;
        const finPrice = priceText.indexOf("*") - 1;
        return (priceText.substring(inicioPrice, finPrice));
    }

    async clickToAddCart() {
        await this.clickOnWebElement(this.addToCart);
    }
}

module.exports = new ProductsDetailPage();