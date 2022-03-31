

const BasePage = require('./base.page');

/**
 * sub page containing specific selectors and methods for a specific page
 */
class ConfirmPage extends BasePage {
    /**
     * define selectors using getter methods
     */
    get tittle() { return $("//h2[text()='Thank you for your purchase!']"); }

    get confirmButton() { return $("//button[text()='OK']"); }

    get detailPurchase() { return $("//p[@class='lead text-muted ']"); }


    async clickOkButton() {
        this.clickOnWebElement(this.confirmButton);
    }

    async getTitlePurchaseMsj() {
        return this.getTextFromWebElement(title);
    }

    async getDetailPurchaseMsj() {
        return this.getTextFromWebElement(detailPurchase);
    }
}

module.exports = new ConfirmPage();
