package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    @FindBy (linkText = "Laptops")
    WebElement laptopsCategory;

    WebDriver driver;

    public IndexPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLaptopCategory(){
        laptopsCategory.click();
    }

}
