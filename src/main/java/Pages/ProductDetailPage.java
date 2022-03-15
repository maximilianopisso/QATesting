package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends BasePage {

    @FindBy(css = "h2.name")
    WebElement model;

    @FindBy(css = "h3.price-container")
    WebElement price;

    @FindBy(linkText = "Add to cart")
    WebElement addToCart;

    public ProductDetailPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public String getPrice() {
        return getTextFromWebElement(price);
    }

    public String getModel() {
        return getTextFromWebElement(model);
    }

    public void clickAddToCart() {
        clickOnWebElement(addToCart);
    }

}
