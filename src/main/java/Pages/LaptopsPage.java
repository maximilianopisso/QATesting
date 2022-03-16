package Pages;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LaptopsPage extends BasePage {

    By preciosLaptops = By.xpath("//h5[contains(text(),'$')]");
    By modelLaptops = By.xpath("//h4[@class='card-title']//a");

    public LaptopsPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void obtenerLaptops(int minPrice, int maxPrice) throws Exception {
        //SINO HAGO LA PAUSA ME TOMA LOS PRECIOS DE LOS CELULARES
        Thread.sleep(3000);

        //TOMO TODOS LOS LOS ELEMENTOS PRECIOS EN Y LOS COLOCO EN UNA LISTA DE WEBELEMENTS
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(preciosLaptops)));
        ArrayList<WebElement> listaPreciosWebElements = (ArrayList<WebElement>) driver.findElements(preciosLaptops);

        //CONVIERTO LISTADO DE WEBELEMENTS EN UNA LISTA DE NUMEROS CON LOS PRECIOS DE CADA WEBELEMENT
        List<Integer> listaPreciosNumber = listaPreciosWebElements.stream().map(webElement -> {
            String texto = webElement.getText().substring(1, webElement.getText().length());
            Integer numero = Integer.parseInt(texto);
            return numero;
        }).collect(Collectors.toList());

        //CAPTURO NUEEVAMENT TODOS LOS ELEMENTOS PERO A LOS QUE PUEDAN HACERSE CLICK (MODELO DE LAPTOPS)
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(modelLaptops)));
        ArrayList<WebElement> listaModeloWebElements = (ArrayList<WebElement>) driver.findElements(modelLaptops);

        WebElement webElementresult = null;
        /*RECORRO EL ARREGLO DE PRECIOS, BUSCANDO EL PRIMERO QUE CUMPLA LA CONDICION, SI CUMPLE, TOMO SU POSICION Y HAGO CLICK
         EN EL ELEMENTO QUE OCUPA ESA MISMA POSICION DEL LISTADO DE WEBELEMENTS, SINO, SE LANZA UNA EXCEPCION CON MSJ*/

        for (int i = 0; i < listaPreciosNumber.size(); i++) {
            if (listaPreciosNumber.get(i) >= minPrice && listaPreciosNumber.get(i) <= maxPrice) {
                webElementresult = listaModeloWebElements.get(i);
                System.out.println("Se selecciona el elemento Nº: "+(i+1));
                clickOnWebElement(webElementresult);
                break;
            }
        }
        if (webElementresult == null) {
            throw new Exception("NO HAY NINGUN ELEMENTO CON ESA CONDICION DE PRECIOS");
        }
    }
}
