package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SweetAlertPage {

    @FindBy (xpath = "//div[contains(@class,'showSweetAlert visible')]")
    WebElement sweetAlertModal;

    @FindBy (xpath = "//div[contains(@class,'showSweetAlert visible')]")
    WebElement sweetAlertTittle;

    @FindBy (xpath = "//div[contains(@class,'showSweetAlert visible')]")
    WebElement sweetAlertButton;



    //h2[normalize-space()='Thank you for your purchase!']
    //button[normalize-space()='OK']
}
