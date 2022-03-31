const BasePage = require('./base.page');

/**
 * sub page containing specific selectors and methods for a specific page
 */
class MenuPage extends BasePage {
    /**
     * Se definen los selectors
     */
    get linkToCart() {
        return $("//a[text()='Cart']");
    }

    /**
     * Hace click sobre la categoria Laptops
     * 
     */
    async navegatoToSectionCart() {
        await this.clickOnWebElement(this.linkToCart)
    }
}

module.exports = new MenuPage();