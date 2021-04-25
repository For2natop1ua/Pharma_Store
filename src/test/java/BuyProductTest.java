import factory.DriverManager;
import factory.DriverType;
import factory.WebDriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObject.MainPage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static org.apache.commons.io.FileUtils.copyFile;

public class BuyProductTest {

    DriverManager driverManager;

    WebDriver driver;

    @BeforeTest(groups = {"checkinTests"})
    public void setUP() {
        DriverType driverType = DriverType.fromValue(System.getenv("browser").toUpperCase());
        driverManager = WebDriverFactory.getDriver(driverType);
    }

    @BeforeMethod(groups = {"checkinTests"})
    public void beforeMethod() {
        driver = driverManager.getDriver();
    }


    @Parameters({"productName"})
    @Test(groups = {"brokenTests"} )
    public void TestCorrectOrder(String productName) {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage()
                .findSearchField()
                .searchForProduct(productName)
                .verifyCurrentProduct(productName)
                .clickCurrentProduct(productName)
                .clickToBuy()
                .addToBasket()
                .ordering()
                .checkSuccesOrder();
    }

    @Parameters({"productName"})
    @Test(groups = {"checkinTests"} )
    public void TestWithError(String productName) {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage()
                .findSearchField()
                .searchForProduct(productName)
                .verifyCurrentProduct(productName)
                .clickCurrentProduct(productName)
                .clickToBuy()
                .addToBasket()
                .orderingIncorrect();
    }

    @AfterMethod(alwaysRun = true)
    public void takeScreenshot(ITestResult result) {
        if (!result.isSuccess())
            try {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                copyFile(scrFile, new File(result.getName() + "[" + LocalDate.now() + "][" + System.currentTimeMillis() + "].png"));
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
    }

    @AfterMethod(dependsOnMethods = "takeScreenshot", alwaysRun = true)
    public void quitBrowser() {
        driverManager.quiteDriver();
    }
}
