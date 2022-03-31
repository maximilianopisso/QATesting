const BasePage = require('./base.page');

/**
 * sub page containing specific selectors and methods for a specific page
 */
class ProductsPage extends BasePage {
    /**
     * Se definen los selectors
     */
     get firstLaptop () {
        return $("//a[text()='Sony vaio i5']");
    }
  
    /**
     * Hace click sobre la categoria Laptops
     * 
     */
    async clickFirstLaptop () {
        await this.clickOnWebElement(this.firstLaptop)
    }

}

module.exports = new ProductsPage();