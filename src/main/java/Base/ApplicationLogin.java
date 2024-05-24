package Base;


import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageFactory.HomePage;
import pageFactory.LoginPage;

@Listeners(utils.TestListeners.class)
public class ApplicationLogin extends BaseClass{
    LoginPage Login;

    HomePage HomePage;


    ExtentReports loginTest;
    @BeforeClass
    public void setupl() {
        Login= PageFactory.initElements(driver, LoginPage.class);
        HomePage= PageFactory.initElements(driver, HomePage.class);
    }
    @Test(testName = "Login to application as pre-requisite for every Testcase")
    public void ApplicationLoginTry() throws InterruptedException {

        Login.LoginPage_isdisplayed();
        Login.LoginPage_inputUser();
        Login.LoginPage_inputPass();
        Login.LoginPage_LoginbuttonClick();
        HomePage.HomePage_isdisplayed();

    }




}
