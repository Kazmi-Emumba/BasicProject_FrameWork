package pageFactory;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Listeners;
import utils.TestListeners;

//@Listeners(utils.TestListeners.class)
public class CartFlow {
    final WebDriver driver;

    @FindBy(how = How.ID, using = "shopping_cart_container")
    public WebElement shopping_cart;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Sauce Labs Backpack')]")
    public WebElement bag_title;

    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-backpack")
    public WebElement add_to_cart_bag;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Checkout')]")
    public WebElement cart_Checkout;


    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Checkout: Your Information')]")
    public WebElement cart_Checkout_details;
    @FindBy(how = How.ID, using = "first-name")
    public WebElement cart_firstname;

    @FindBy(how = How.ID, using = "last-name")
    public WebElement cart_lastname;

    @FindBy(how = How.ID, using = "postal-code")
    public WebElement cart_postalcode;



    @FindBy(how = How.ID, using = "continue")
    public WebElement cart_continue;


    @FindBy(how = How.ID, using = "finish")
    public WebElement cart_finish;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Thank you for your order!')]")
    public WebElement checkOut_Done;


    public void itemBag_isdisplayed()
    {
        if(bag_title.isDisplayed()) {
            //System.out.println(TestListeners.extentTest.get());
            TestListeners.extentTest.get().log(Status.PASS, "Bag Item is available in List");
        }
    }

    public void BagItem_addToCart()
    {
        if(add_to_cart_bag.isDisplayed()) {
            add_to_cart_bag.click();
            TestListeners.extentTest.get().log(Status.PASS, "Clicked Bag add to cart button");
        }

    }

    public void BagItem_shoppingCart()
    {
        if(shopping_cart.isDisplayed()) {
            shopping_cart.click();
            TestListeners.extentTest.get().log(Status.PASS, "Clicked on Shopping");
        }

    }

    public void BagItem_Cart_checkout()
    {
        if(cart_Checkout.isDisplayed()) {
            cart_Checkout.click();
            TestListeners.extentTest.get().log(Status.PASS, "Clicked on shopping Cart checkout");
        }

    }

    public void Bag_detailsin_Cart_isdisplayed()
    {
        if(cart_Checkout_details.isDisplayed()) {
            //System.out.println(TestListeners.extentTest.get());
            TestListeners.extentTest.get().log(Status.PASS, "Bag Item is available in List");
        }
    }


    public void ChecoutDetails_inputfirstName()
    {
        if(cart_firstname.isDisplayed()) {
            cart_firstname.sendKeys("First_Name");
            TestListeners.extentTest.get().log(Status.PASS, "Inserted FirstName in shopping details");
        }

    }

    public void ChecoutDetails_inputLastName()
    {
        if(cart_lastname.isDisplayed()) {
            cart_lastname.sendKeys("Last_Name");
            TestListeners.extentTest.get().log(Status.PASS, "Inserted LastName in shopping details");
        }

    }
    public void ChecoutDetails_inputPostCode()
    {
        if(cart_postalcode.isDisplayed()) {
            cart_postalcode.sendKeys("1234");
            TestListeners.extentTest.get().log(Status.PASS, "Inserted PostalCode in shopping details");
        }

    }

    public void Cart_ContinueClick()
    {
        if(cart_continue.isDisplayed()) {
            cart_continue.click();
            TestListeners.extentTest.get().log(Status.PASS, "Clicked Cart checkout continue");
        }

    }
    public void Cart_FinishClick()
    {
        if(cart_finish.isDisplayed()) {
            cart_finish.click();
            TestListeners.extentTest.get().log(Status.PASS, "Clicked Cart checkout Finish");
        }

    }

    public void checkOutDone_isdisplayed()
    {
        if(checkOut_Done.isDisplayed()) {
            //System.out.println(TestListeners.extentTest.get());
            TestListeners.extentTest.get().log(Status.PASS, "Checkout confirmation, Thanks for shopping is displayed");
        }
    }

    public CartFlow(WebDriver driver){

        this.driver = driver;

    }
}
