package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class MenuPage {

    @FindBy(xpath = "//a[text()='Cart']")
    WebElement linkToCart;

    WebDriver driver;

    public MenuPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToCart() {
        linkToCart.click();
    }
}
