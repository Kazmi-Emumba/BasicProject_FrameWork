package TestCases;

import Base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFactory.HomePage;
import pageFactory.LoginPage;

//@Listeners(utils.TestListeners.class)
public class NavigationCase extends BaseClass {

HomePage HPage;
LoginPage LPage;
    ExtentReports loginTest;
    @BeforeClass
    public void setup() throws InterruptedException {
        HPage= PageFactory.initElements(driver, HomePage .class);
        LPage= PageFactory.initElements(driver, LoginPage.class);

    }

    @Test
    public void app_NavigationFLow_logout() throws InterruptedException {
        ApplicationLoginTry();
        HPage.HomePage_isdisplayed();
        HPage.Homepage_menuClick();
        HPage.logout_menuClick();

    }

}
