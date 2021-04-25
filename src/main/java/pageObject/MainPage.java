package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchField;
    @FindBy(css = ".search-button-bar")
    private WebElement searchButton;
    @FindBy(xpath = "//img[@title='Аптека ЛЕДА']")
    private WebElement logoStore;
    @FindBy(id = "dropdownMenuButton")
    private WebElement dropDownCatalog;
    @FindBy(css = ".pt-4")
    private WebElement footer;
    @FindBy(xpath = "//a[@title='Задати питання']")
    private WebElement buttonQuestion;
    @FindBy(id="carousel0")
    private WebElement slideBar;
    @FindBy(css = ".wrapper-featured")
    private WebElement catalog;
    @FindBy(css=".wrapper-alphabet")
    private WebElement alphabet;
    @FindBy(css=".wrapper-bestseller")
    private WebElement bestseller;
    @FindBy(css=".wrapper-news")
    private WebElement news;




    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage openPage(){
        String url = "https://leda.kharkov.ua/ua/";
        driver.get(url);
        return this;
    }

    public MainPage findSearchField(){
        searchField.isDisplayed();
        return this;
    }

    public void checkHeader(){
        Assert.assertTrue(logoStore.isDisplayed());
        Assert.assertTrue(searchField.isDisplayed());
        searchButton.isEnabled();
        dropDownCatalog.isEnabled();
    }

    public void checkFooter(){
        Assert.assertTrue(footer.isDisplayed());
        buttonQuestion.isEnabled();
    }

    public void checkBody(){
        Assert.assertTrue(slideBar.isDisplayed());
        catalog.isDisplayed();
        alphabet.isDisplayed();
        bestseller.isDisplayed();
        news.isDisplayed();
    }

    public SearchPage searchForProduct(String productName){
        searchField.sendKeys(productName);
        searchButton.click();
        return new SearchPage(driver);
    }
}
