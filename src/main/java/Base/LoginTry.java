package Base;

import Variables.configReader;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import pageFactory.LoginPage;
import static org.testng.Assert.assertTrue;

public class LoginTry extends BaseClass{
    protected LoginPage Login;

    protected String LoginUser;
    protected String LoginPass;
    @BeforeClass
    public void setupl() {
        LoginUser = configReader.property.getProperty("Login_User");
        LoginPass = configReader.property.getProperty("Login_Pass");
        Login= PageFactory.initElements(driver, LoginPage.class);
        getExtent();
    }
    public void logintry() throws InterruptedException {
        assertTrue(Login.Login_logo.isDisplayed(), "Login Page is not loaded successfully");
        Login.Input_UserName.sendKeys(LoginUser);
        Thread.sleep(2000);
        Login.Input_LoginPass.sendKeys(LoginPass);
        Thread.sleep(2000);
        Login.Login_btn.click();
        Thread.sleep(3000);
        ExtentTest loginTest= extent.createTest("Pre-req Login");
        loginTest.pass("Logged In Successfully");
    }





}
