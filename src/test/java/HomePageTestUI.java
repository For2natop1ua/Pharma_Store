import org.testng.annotations.Test;
import pageObject.BasePage;
import pageObject.MainPage;

public class HomePageTestUI extends BasePage {

    @Test(groups = {"checkinTests"} )
    public void TestHeader() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage()
                .checkHeader();
    }

    @Test(groups = {"checkinTests"} )
    public void TestFooter() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage()
                .checkFooter();
    }

    @Test(groups = {"checkinTests"} )
    public void TestBody() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage()
                .checkBody();
    }
}
