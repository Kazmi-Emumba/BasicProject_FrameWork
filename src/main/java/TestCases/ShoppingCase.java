package TestCases;

import Base.BaseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFactory.CartFlow;

//@Listeners(utils.TestListeners.class)
public class ShoppingCase extends BaseClass {


    CartFlow CartPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        CartPage= PageFactory.initElements(driver, CartFlow .class);

    }

    @Test
    public void bag_shopping_flow() throws InterruptedException {
        ApplicationLoginTry();

      CartPage.itemBag_isdisplayed();
      CartPage.BagItem_addToCart();
      CartPage.BagItem_shoppingCart();
      CartPage.itemBag_isdisplayed();
     CartPage.BagItem_Cart_checkout();
     CartPage.Bag_detailsin_Cart_isdisplayed();
     CartPage.ChecoutDetails_inputfirstName();
    CartPage.ChecoutDetails_inputLastName();
          CartPage.ChecoutDetails_inputPostCode();
        CartPage.Cart_ContinueClick();
        CartPage.itemBag_isdisplayed();
        CartPage.Cart_FinishClick();
        CartPage.checkOutDone_isdisplayed();


    }




}
