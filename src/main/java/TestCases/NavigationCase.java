package TestCases;

import Base.ApplicationLogin;
import Base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageFactory.HomePage;
import pageFactory.LoginPage;

import static utils.ExtentManager.createInstance;

@Listeners(utils.TestListeners.class)
public class NavigationCase extends ApplicationLogin {

HomePage HPage;
LoginPage LPage;
    ExtentReports loginTest;
    @BeforeClass
    public void setup() throws InterruptedException {
        HPage= PageFactory.initElements(driver, HomePage .class);
        LPage= PageFactory.initElements(driver, LoginPage.class);

    }

    @Test
    public void app_logout()
    {
        HPage.HomePage_isdisplayed();
        HPage.Homepage_menuClick();
        HPage.logout_menuClick();
        LPage.LoginPage_isdisplayed();

    }

}
