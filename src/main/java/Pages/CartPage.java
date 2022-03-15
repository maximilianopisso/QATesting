package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    @FindBy(xpath = "//tr[@class='success']//td[1]//img")
    WebElement firstImgProductAdded;

    @FindBy(xpath = "//tr[@class='success']//td[2]")
    WebElement firstTittleProductAdded;

    @FindBy(xpath = "//tr[@class='success']//td[3]")
    WebElement firstPriceProductAdded;

    @FindBy(xpath = "//button[text()='Place Order']")
    WebElement buttonOrder;


    public CartPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public String getTittle() {
        return getTextFromWebElement(firstTittleProductAdded);
    }

    public String getPrice() {
        return getTextFromWebElement(firstPriceProductAdded);
    }

    public void clickOrder() {
        clickOnWebElement(buttonOrder);
    }
}