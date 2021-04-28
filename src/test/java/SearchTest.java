import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.BasePage;
import pageObject.MainPage;

public class SearchTest extends BasePage {

    @DataProvider(name = "productData")
    public Object[][] productData(){
        return new Object[][]{
                {"Ранітидин"},
                {"Мезим форте"}
        };
    }

    @DataProvider(name = "productDataIncorrect")
    public Object[][] productDataIncorrect(){
        return new Object[][]{
                {"Ranitydyn"},
                {"Abrakadabra"}
        };
    }

    @Test(dataProvider = "productDataIncorrect", groups = {"checkinTests"} )
    public void TestIncorrectSearch(String productName) {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage()
                .findSearchField()
                .searchForProduct(productName)
                .verifyCurrentProductError();
    }

    @Test(dataProvider = "productData", groups = {"checkinTests"} )
    public void TestCorrectSearch(String productName) {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage()
                .findSearchField()
                .searchForProduct(productName)
                .verifyCurrentProduct(productName);
    }
}
