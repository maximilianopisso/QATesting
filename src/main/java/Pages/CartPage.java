package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    @FindBy(xpath = "//tr[@class='success']//td[1]//img")
    WebElement firstImgProductAdded;

    @FindBy(xpath = "//tr[@class='success']//td[2]")
    WebElement firstTittleProductAdded;

    @FindBy(xpath = "//tr[@class='success']//td[3]")
    WebElement firstPriceProductAdded;

    @FindBy(xpath="//button[text()='Place Order']")
    WebElement buttonOrder;

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean imageProductIsVisible(int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(firstImgProductAdded));
        return firstImgProductAdded.isDisplayed();
    }

    public String getTittle(int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(firstTittleProductAdded));
        return firstTittleProductAdded.getText();
    }

    public String getPrice(int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(firstPriceProductAdded));
        return firstPriceProductAdded.getText();
    }

    public void clickOrder(int time){
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(buttonOrder));
        buttonOrder.click();
    }
}