const BasePage = require('./base.page');

/**
 * sub page containing specific selectors and methods for a specific page
 */
class MenuPage extends BasePage {

    get linkToCart() { return $("//a[text()='Cart']"); }

    async navegatoToSectionCart() {
        await this.clickOnWebElement(this.linkToCart)
    }
}

module.exports = new MenuPage();