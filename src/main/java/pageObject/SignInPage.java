package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignInPage {

    WebDriver driver;

    @FindBy(id = "createAccountSubmit")
    private WebElement createAccount;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyButtonAccount(){
        Assert.assertTrue(createAccount.isDisplayed());
    }
}
