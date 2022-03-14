package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrderPage {
    @FindBy(xpath = "//div[@id='orderModal']//div[@class='modal-header']")
    WebElement orderModalSection;

    @FindBy(id = "name")
    WebElement inputName;

    @FindBy(id = "country")
    WebElement inputCountry;

    @FindBy(id = "city")
    WebElement inputCity;

    @FindBy(id = "card")
    WebElement inputCreditCard;

    @FindBy(id = "month")
    WebElement inputMonth;

    @FindBy(id = "year")
    WebElement inputYear;

    @FindBy(xpath = "//button[text()='Close']")
    WebElement buttonClose;

    @FindBy(xpath = "//button[text()='Purchase']")
    WebElement buttonPurchase;


    WebDriver driver;

    public PlaceOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void formComplete(int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(orderModalSection));

        inputName.sendKeys("Maximiliano");
        inputCountry.sendKeys("Argentina");
        inputCity.sendKeys("Rosario");
        inputCreditCard.sendKeys("4555990045759871");
        inputMonth.sendKeys("12");
        inputYear.sendKeys("2023");

    }

    public void clickPurchase() {
        buttonPurchase.click();
    }

    public void clickClose() {
        buttonClose.click();
    }

}
