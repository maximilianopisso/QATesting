/**
* main page object containing all methods, selectors and functionality
* that is shared across all page objects
*/
module.exports = class Page {
    /**
    * Opens a sub page of the page
    * @param path path of the sub page (e.g. /path/to/page.html)
    */
    navigateTo (url) {
        return browser.url(url)
    }

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
