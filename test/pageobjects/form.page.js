const BasePage = require('./base.page');

class FormPage extends BasePage {

    get inputName() { return $("#name"); }
    get inputCountry() { return $("#country"); }
    get inputCity() { return $("#city"); }
    get inputCard() { return $("#card"); }
    get inputMonth() { return $("#month"); }
    get inputYear() { return $("#year"); }
    get buttonPurchase() { return $("//button[text()='Purchase']"); }

    async setName(name) {
        this.sendKeysToWebElement(this.inputName, name);
    }

    async setCountry(country) {
        this.sendKeysToWebElement(this.inputCountry, country);
    }

    async setCity(city) {
        this.sendKeysToWebElement(this.inputCity, city);
    }

    async setCreditCard(card) {
        this.sendKeysToWebElement(this.inputCard, card);
    }

    async setMonth(month) {
        this.sendKeysToWebElement(this.inputMonth, month);
    }

    async setYear(year) {
        this.sendKeysToWebElement(this.inputYear, year);
    }

    async formComplete(name, country, city, card, month, year) {
        await this.setName(name);
        await this.setCountry(country);
        await this.setCity(city);
        await this.setCreditCard(card);
        await this.setMonth(month);
        await this.setYear(year);
    }

    async clickPurchaseButton() {
        await this.clickOnWebElement(this.buttonPurchase);
    }
}

module.exports = new FormPage();