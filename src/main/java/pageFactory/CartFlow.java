package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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




    public CartFlow(WebDriver driver){

        this.driver = driver;

    }
}
