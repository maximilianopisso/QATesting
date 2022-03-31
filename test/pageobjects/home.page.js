const BasePage = require('./base.page');

/**
 * sub page containing specific selectors and methods for a specific page
 */
class HomePage extends BasePage {
    /**
     * Se definen los selectors
     */
    get laptopsCatergory () {
        return $("//a[text()='Laptops']");
    }
  
    /**
     * Hace click sobre la categoria Laptops
     * 
     */
    async clickLaptopCategory () {
        await this.clickOnWebElement(this.laptopsCatergory)
    }

    /**
     * Abre el browser lo maximiza y carga la URL pasada por parametro
     */
    async navigateTo(url){
        await browser.maximizeWindow();
        await browser.url(url);
    }
    /**
     * Cierra el browser
     */
    async closeURL(){
        await browser.closeWindow();
    }
}

module.exports = new HomePage();