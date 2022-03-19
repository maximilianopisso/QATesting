package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LaptopsPage extends BasePage {

    By priceLaptops = By.xpath("//h5[contains(text(),'$')]");
    By modelLaptops = By.xpath("//h4[@class='card-title']//a");

    public LaptopsPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickLaptopInRange(int minPrice, int maxPrice) throws Exception {
        //SINO HAGO LA PAUSA ME TOMA LOS PRECIOS DE LOS CELULARES
        Thread.sleep(2000);

        //TOMO TODOS LOS LOS ELEMENTOS PRECIOS EN Y LOS COLOCO EN UNA LISTA DE WEBELEMENTS
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(priceLaptops)));
        ArrayList<WebElement> listaPreciosWebElements = (ArrayList<WebElement>) driver.findElements(priceLaptops);

        //CONVIERTO LISTADO DE WEBELEMENTS EN UNA LISTA DE NUMEROS CON LOS PRECIOS DE CADA WEBELEMENT
        List<Integer> listaPreciosNumber = listaPreciosWebElements.stream().map(webElement -> {
            String text = webElement.getText().substring(1, webElement.getText().length());
            Integer number = Integer.parseInt(text);
            return number;
        }).collect(Collectors.toList());

        //CAPTURO NUEVAMENTE TODOS LOS ELEMENTOS PERO A LOS QUE PUEDAN HACERSE CLICK (MODELO DE LAPTOPS)
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(modelLaptops)));
        ArrayList<WebElement> listaModeloWebElements = (ArrayList<WebElement>) driver.findElements(modelLaptops);

        /*RECORRO EL ARREGLO DE PRECIOS, BUSCANDO EL PRIMERO QUE CUMPLA LA CONDICION, SI CUMPLE, TOMO SU POSICION Y HAGO CLICK
         EN EL ELEMENTO QUE OCUPA ESA MISMA POSICION DEL LISTADO DE WEBELEMENTS, SINO, SE LANZA UNA EXCEPCION CON MSJ*/
        WebElement webElementrResult = null;
        for (int i = 0; i < listaPreciosNumber.size(); i++) {
            if (listaPreciosNumber.get(i) >= minPrice && listaPreciosNumber.get(i) <= maxPrice) {
                webElementrResult = listaModeloWebElements.get(i);
                clickOnWebElement(webElementrResult);
                break;
            }
        }
        if (webElementrResult == null) {
            throw new Exception("NO HAY NINGUN ELEMENTO CON ESA CONDICION DE PRECIOS");
        }
    }
}
