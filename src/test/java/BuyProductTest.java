import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.BasePage;
import pageObject.OrderPage;

public class BuyProductTest extends BasePage {

    @Parameters({"productName"})
    @Test(groups = {"orderTests"})
    public void TestCorrectOrder(String productName) {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.ordering()
                .checkSuccesOrder();
    }

    @Parameters({"productName"})
    @Test(groups = {"orderTests"})
    public void TestWithError(String productName) {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.orderingIncorrect();
    }
}
