package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaptopsPage {

    @FindBy (xpath ="//div[@id='tbodyid']//div[1]//div[1]//a[1]//img")
    WebElement laptopsFirstProduct;

    WebDriver driver;

    public LaptopsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFirstLaptop(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(laptopsFirstProduct)).click();
    }
}
