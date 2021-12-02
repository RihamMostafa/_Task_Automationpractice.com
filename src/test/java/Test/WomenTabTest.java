package Test;

import Pages.WomenTab;
import org.junit.Assert;
import org.testng.annotations.Test;

public class WomenTabTest extends BaseTest {

    public WomenTab WT;

    @Test
    public void OrderBlouses() throws InterruptedException {
        WT= new WomenTab();
        WT.openBlousesTab();
        WT.SelectProduct();
        Assert.assertTrue(WT.FollowCheckout());
        Assert.assertTrue(WT.PaybyBankWire());
        Assert.assertTrue(WT.OrderPlaced());
    }
}
