package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrderPage {

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

    public void setName(String name) {
        inputName.sendKeys(name);
    }

    public void setCountry(String country) {
        inputCountry.sendKeys(country);
    }

    public void setCity(String city) {
        inputCity.sendKeys(city);
    }

    public void setCreditCard(String card) {
        inputCreditCard.sendKeys(card);
    }

    public void setMonth(String month) {
        inputMonth.sendKeys(month);
    }

    public void setYear(String year) {
        inputYear.sendKeys(year);
    }

    public void clickPurchase() {
        buttonPurchase.click();
    }

    public void clickClose() {
        buttonClose.click();
    }

    public void formComplete(int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(inputName));
        setName("Maximiliano");
        setCountry("Argentina");
        setCity("Rosario");
        setCreditCard("4555990015485487");
        setMonth("12");
        setYear("2023");
    }
}
