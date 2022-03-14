package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPage {

    @FindBy (xpath = "//div[contains(@class,'showSweetAlert visible')]")
    WebElement sweetAlertModal;

    @FindBy (xpath = "//div[contains(@class,'showSweetAlert visible')]//h2[text()='Thank you for your purchase!']")
    WebElement sweetAlertTittle;

    @FindBy (xpath = "//div[contains(@class,'showSweetAlert visible')]//button[normalize-space()='OK']")
    WebElement sweetAlertButton;

    WebDriver driver;

    public ConfirmationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOkButton (int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.elementToBeClickable(sweetAlertButton)).click();
    }

    public String getTitte (int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        return (wait.until(ExpectedConditions.visibilityOf(sweetAlertTittle)).getText());
    }
}
