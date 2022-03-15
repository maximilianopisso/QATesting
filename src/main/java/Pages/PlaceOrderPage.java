package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrderPage extends BasePage{

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

    public PlaceOrderPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void setName(String name) {
        SendKeysToWebElement(inputName, name);
    }

    public void setCountry(String country) {
        SendKeysToWebElement(inputCountry,country);
    }

    public void setCity(String city) {
        SendKeysToWebElement(inputCity,city);
    }

    public void setCreditCard(String card) {
        SendKeysToWebElement(inputCreditCard,card);
    }

    public void setMonth(String month) {
        SendKeysToWebElement(inputMonth,month);
    }

    public void setYear(String year) {
        SendKeysToWebElement(inputYear,year);
    }

    public void clickPurchase() {
        clickOnWebElement(buttonPurchase);
    }

    public void clickClose() {
        clickOnWebElement(buttonClose);
    }

    public void formComplete(String name, String country, String city, String creditCard, String month, String year) {
        wait.until(ExpectedConditions.elementToBeClickable(inputName));
        setName(name);
        setCountry(country);
        setCity(city);
        setCreditCard(creditCard);
        setMonth(month);
        setYear(year);
    }
}
