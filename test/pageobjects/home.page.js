const BasePage = require('./base.page');

/**
 * sub page containing specific selectors and methods for a specific page
 */
class HomePage extends BasePage {

    get laptopsCatergory() { return $("//a[text()='Laptops']"); }

    async clickLaptopCategory() {
        await this.clickOnWebElement(this.laptopsCatergory)
    }

    async navigateTo(url) {
        await browser.maximizeWindow();
        await browser.url(url);
    }

    async closeURL() {
        await browser.closeWindow();
    }
}

module.exports = new HomePage();