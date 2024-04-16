package TestCases;

import Base.BaseClass;
import Base.LoginTry;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFactory.CartFlow;

public class ShoppingCase extends LoginTry {


    CartFlow CartPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        CartPage= PageFactory.initElements(driver, CartFlow .class);
        getExtent();
        logintry();
    }

    @Test
    public void bag_shopping_flow() throws InterruptedException {
        if(CartPage.bag_title.isDisplayed())
        {
            CartPage.add_to_cart_bag.click();
            Thread.sleep(3000);
            CartPage.shopping_cart.click();
            Thread.sleep(2000);
            if (CartPage.bag_title.isDisplayed())
            {
                CartPage.cart_Checkout.click();
                Thread.sleep(2000);
                if(CartPage.cart_Checkout_details.isDisplayed())
                {
                    CartPage.cart_firstname.sendKeys("First_Name");
                    CartPage.cart_lastname.sendKeys("Last_Name");
                    CartPage.cart_postalcode.sendKeys("1234");
                    Thread.sleep(2000);
                    CartPage.cart_continue.click();
                }
                if (CartPage.bag_title.isDisplayed())
                {
                   CartPage.cart_finish.click();
                   CartPage.checkOut_Done.isDisplayed();
                }

            }
        }
        ExtentTest loginTest= extent.createTest("shopping Test");
        loginTest.pass("Shopping report check");



    }




}
