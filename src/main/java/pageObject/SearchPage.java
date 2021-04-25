package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class SearchPage {

    WebDriver driver;

    @FindBy(xpath = "//p[contains(.,'Немає товарів, які відповідають критеріям пошуку.')]")
    private WebElement currentError;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public SearchPage verifyCurrentProduct(String productName){
        WebElement currentProduct = driver.findElement(By.partialLinkText(productName));
        Assert.assertTrue(currentProduct.isDisplayed());
        return this;
    }

    public SearchPage verifyCurrentProductError(){
        Assert.assertTrue(currentError.isDisplayed());
        return this;
    }

    public ProductPage clickCurrentProduct(String productName){
        driver.findElement(By.partialLinkText(productName)).click();
        return new ProductPage(driver);
    }

}
