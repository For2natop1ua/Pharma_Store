package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {


    @FindBy(css = ".button-buy")
    private WebElement currentButton;
    @FindBy(xpath = "//button[contains(.,'До кошика')]")
    private WebElement buttonBasket;

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public ProductPage findElementToBuy(String productName){
        WebElement buttonToBuy = driver.findElement(By.partialLinkText(productName));
        buttonToBuy.isDisplayed();
        buttonToBuy.click();
        return this;
    }

    public ProductPage clickToBuy(){
        currentButton.isDisplayed();
        currentButton.click();
        return this;
    }

    public OrderPage addToBasket(){
        buttonBasket.isEnabled();
        buttonBasket.click();
        return new OrderPage(driver);
    }

}
