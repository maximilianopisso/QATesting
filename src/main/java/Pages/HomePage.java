package Pages;

import Utility.PropertiesFile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy (linkText = "Laptops")
    WebElement laptopsCategory;

    public HomePage(){
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickLaptopCategory(){
        clickOnWebElement(laptopsCategory);
    }

    public void nativagetoHome(){
        driver.manage().window().maximize();
        driver.navigate().to(PropertiesFile.getProperty("urlHome"));
    }

    public void quit() {
        driver.quit();
    }
}
