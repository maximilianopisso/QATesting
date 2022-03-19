package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPage extends BasePage {

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    WebElement title;

    @FindBy(xpath = "//button[text()='OK']")
    WebElement confirmButton;

    @FindBy(xpath = "//p[@class='lead text-muted ']")
    WebElement detailPurchase;

    public ConfirmationPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickOkButton() {
        clickOnWebElement(confirmButton);
    }

    public String getTitle() {
        return getTextFromWebElement(title);
    }

    public String getDetailPurchase() {
        return getTextFromWebElement(detailPurchase);
    }
}
