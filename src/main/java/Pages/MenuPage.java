package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class MenuPage extends BasePage{

    @FindBy(xpath = "//a[text()='Cart']")
    WebElement linkToCart;

    public MenuPage(){
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void navigateToCart() {
        clickOnWebElement(linkToCart);
    }
}
