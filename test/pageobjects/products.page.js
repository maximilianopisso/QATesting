const BasePage = require('./base.page');

class ProductsPage extends BasePage {

    get firstLaptop() {
        return $("//a[text()='Sony vaio i5']");
    }

    async clickFirstLaptop() {
        await this.clickOnWebElement(this.firstLaptop)
    }
}

module.exports = new ProductsPage();