package TestCases;

import Base.BaseClass;
import Base.LoginTry;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFactory.HomePage;

public class NavigationCase extends LoginTry {

HomePage HPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        HPage= PageFactory.initElements(driver, HomePage .class);
        getExtent();
        logintry();
    }

    @Test
    public void app_logout()
    {
        HPage.app_menu.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        HPage.app_logout.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ExtentTest loginTest= extent.createTest("Logout Test");
        loginTest.pass("Logged out report check");

    }

}
