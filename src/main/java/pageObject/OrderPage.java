package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderPage {

    @FindBy(xpath = "//input[@id='customer_firstname']")
    private WebElement fullNameField;
    @FindBy(xpath = "//input[@id='customer_telephone']")
    private WebElement telephoneField;
    @FindBy(xpath = "//input[@id='customer_email']")
    private WebElement emailField;
    @FindBy(xpath = "//textarea[@name='comment']")
    private WebElement commentField;
    @FindBy(xpath = "//a[@data-onclick='createOrder']")
    private WebElement orderingButton;
    @FindBy(xpath = "//span[contains(.,'Успішно')]")
    private WebElement succesSpan;
    @FindBy(xpath = "//div[contains(.,'Ви не заповнили поле')]")
    private WebElement checkErrorFulName;
    @FindBy(xpath = "//div[contains(.,'Ви не ввели номер телефону!')]")
    private WebElement checkErrorTelephone;
    @FindBy(xpath = "//div[contains(.,'Некоректно введено електронний адрес!')]")
    private WebElement checkErrorEmail;



    String fullName = "Василий Васильевич Пупкин";
    String telephone = "7777777777";
    String goodEmail = "test@gmail.com";
    String commed = "=)";
    String badEmail = "qwdqef";

    WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OrderPage ordering(){
        fullNameField.sendKeys(fullName);
        telephoneField.sendKeys(telephone);
        emailField.sendKeys(goodEmail);
        commentField.sendKeys(commed);
        orderingButton.click();
        return this;
    }

    public void checkSuccesOrder(){
        succesSpan.isDisplayed();
    }

    public void orderingIncorrect(){
        orderingButton.click();
        Assert.assertTrue(checkErrorFulName.isDisplayed());
        Assert.assertTrue(checkErrorTelephone.isDisplayed());
        fullNameField.sendKeys(fullName);
        telephoneField.sendKeys(telephone);
        emailField.sendKeys(badEmail);
        orderingButton.click();
        Assert.assertTrue(checkErrorEmail.isDisplayed());
    }
}