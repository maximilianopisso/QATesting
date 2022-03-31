/**
* main page object containing all methods, selectors and functionality
* that is shared across all page objects
*/
module.exports = class BasePage {
    

    async clickOnWebElement(element) {
        await element.waitForClickable();
        await element.click();
    }

    async sendKeysToWebElement(element,text) {
        if (text !== "")
            await element.waitForExist();
        await element.setValue(text);
    }
 
    async getTextFromWebElement(element){
        await element.visibilityOf();
        return (await element.getText());
    }
}
