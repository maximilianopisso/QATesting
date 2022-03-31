

const BasePage = require('./base.page');

/**
 * sub page containing specific selectors and methods for a specific page
 */
class ConfirmPage extends BasePage {
    /**
     * define selectors using getter methods
     */
    get title() { return $("//h2[text()='Thank you for your purchase!']"); }
    get confirmButton() { return $("//button[text()='OK']"); }
    get detailPurchase() { return $("//p[@class='lead text-muted ']"); }

    async clickOkButton() {
        await this.clickOnWebElement(this.confirmButton);
    }

    async getTitlePurchaseMsj() {
        return (await this.getTextFromWebElement(this.title));
    }

    async getDetailPurchaseMsj() {
        return (await this.getTextFromWebElement(this.detailPurchase));
    }
}

module.exports = new ConfirmPage();
