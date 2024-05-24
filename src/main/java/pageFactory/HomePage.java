package pageFactory;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.ExtentManager;
import utils.TestListeners;

public class HomePage {
    final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Open Menu')]")
    public WebElement app_menu;


    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Logout')]")
    public WebElement app_logout;


    public void HomePage_isdisplayed()
    {
        if(app_menu.isDisplayed()) {
            TestListeners.extentTest.get().log(Status.PASS, "Application page is loaded Menu option visible");
        }
    }

    public void Homepage_menuClick()
    {
        if(app_menu.isDisplayed()) {
            app_menu.click();
            TestListeners.extentTest.get().log(Status.PASS, "Opening app menu");
        }

    }

    public void logout_menuClick()
    {
        if(app_logout.isDisplayed()) {
            app_logout.click();
            TestListeners.extentTest.get().log(Status.PASS, "Clicking on Logout");
        }

    }

    public HomePage(WebDriver driver){

        this.driver = driver;

    }
}
