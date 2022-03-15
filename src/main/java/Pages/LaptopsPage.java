package Pages;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class LaptopsPage extends BasePage {

   /* @FindBy(xpath = "//div[@id='tbodyid']//div[1]//div[1]//a[1]//img")
    WebElement laptopsFirstProduct;*/

    By preciosLaptops = By.xpath("//h5[contains(text(),'$')]");

    By modelLaptops = By.xpath("//h4[@class='card-title']//a");

    public LaptopsPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

   /* public void clickFirstLaptop() {
        clickOnWebElement(laptopsFirstProduct);
    }*/

    public void obtenerLaptops(int minPrice, int maxPrice) throws Exception {
        //SINO HAGO LA PAUSA ME TOMA LOS PRECIOS DE LOS CELULARES
        Thread.sleep(2000);
        //TOMO TODOS LOS LOS ELEMENTOS PRECIOS EN Y LOS COLOCO EN UNA LISTA DE WEBELEMENTS
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(preciosLaptops)));
        ArrayList<WebElement> listaPreciosWebElements = (ArrayList<WebElement>) driver.findElements(preciosLaptops);

        // PASAR DE LA LISTA DE WEB ELEMENTS A LISTA DE TEXTO Y QUITANDO EL $
        ArrayList<String> listaPreciosText = new ArrayList<String>();
        listaPreciosWebElements.forEach(webElement -> {
            String texto = webElement.getText();
            listaPreciosText.add(texto.substring(1, texto.length()));
        });
        // PASAR DE LISTA DE TEXTO A LISTA DE NUMEROS
        ArrayList<Integer> listaPreciosNumber = new ArrayList<Integer>();
        listaPreciosText.forEach(element -> {
            listaPreciosNumber.add(Integer.parseInt(element));
            //System.out.println(Integer.parseInt(element) + " - " + listaPreciosNumber.size() );
        });
        //ME TRAIGO NUEVAMENTE TODOS LOS ELEMENTOS PERO QUE SEAN CLICLEABLES (MODELO DE LAPTOPS)
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(modelLaptops)));
        ArrayList<WebElement> listaModeloWebElements = (ArrayList<WebElement>) driver.findElements(modelLaptops);

        WebElement webElementresult = null;

        for ( int i = 0; i < listaPreciosNumber.size(); i++) {

            if (listaPreciosNumber.get(i) >= minPrice && listaPreciosNumber.get(i) <= maxPrice) {
                webElementresult = listaModeloWebElements.get(i);
                clickOnWebElement(webElementresult);
                break;
            }
        }
        if (webElementresult ==null){
            throw new Exception("NO HAY NINGUN ELEMENTO CON ESA CONDICION DE PRECIOS");
        }
    }
}
