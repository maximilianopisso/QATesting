package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'showSweetAlert visible')]//h2[text()='Thank you for your purchase!']")
    WebElement title;

    @FindBy(xpath = "//div[contains(@class,'showSweetAlert visible')]//button[text()='OK']")
    WebElement confirmButton;

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
}
