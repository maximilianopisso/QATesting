const LoginPage = require('../pageobjects/login.page');
const HomePage = require('../pageobjects/home.page');
const ProductsPage = require('../pageobjects/products.page');
const ProductsDetailPage = require('../pageobjects/products.detail.page');
const SecurePage = require('../pageobjects/secure.page');
const URL = 'https://www.demoblaze.com/';

describe('My Login application', () => {
    it('Prueba Demoblaze', async () => {

        // Inicio la URL
        await HomePage.navigateTo(URL);
        
        // Hago click en categoria "Laptos"
        await HomePage.clickLaptopCategory();
        
        await ProductsPage.clickFirstLaptop();
        console.log("MODELO");
         console.log(await ProductsDetailPage.getModel());
         console.log("Price" );
        
        await ProductsDetailPage.clickToAddCart();
        await browser.pause(2000);
        
        
        
        await HomePage.closeURL();
        
  
        // await LoginPage.login('tomsmith', 'SuperSecretPassword!');
        // await expect(SecurePage.flashAlert).toBeExisting();
        // await expect(SecurePage.flashAlert).toHaveTextContaining(
        //     'You logged into a secure area!');
    });
});


