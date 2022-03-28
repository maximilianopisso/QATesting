package Pages;

import Utility.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = DriverFactory.getWait();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void clickOnWebElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void SendKeysToWebElement(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        (element).sendKeys(text);
    }

    public String getTextFromWebElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
}