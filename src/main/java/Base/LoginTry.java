package Base;

import Variables.configReader;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import pageFactory.HomePage;
import pageFactory.LoginPage;
import static org.testng.Assert.assertTrue;

public class LoginTry extends BaseClass{
    protected LoginPage Login;

    protected HomePage HomePage;

    protected String LoginUser;
    protected String LoginPass;
    @BeforeClass
    public void setupl() {
        LoginUser = configReader.property.getProperty("Login_User");
        LoginPass = configReader.property.getProperty("Login_Pass");
        Login= PageFactory.initElements(driver, LoginPage.class);
        HomePage= PageFactory.initElements(driver, HomePage.class);
        getExtent();
    }
    public void logintry() throws InterruptedException {
        ExtentTest loginTest= extent.createTest("Pre-req Login of Application");

        // Login Page visibility Check
        if(Login.Login_logo.isDisplayed())
            loginTest.log(Status.INFO, "Login Logo is visible");
        else loginTest.fail("Login Page is not loaded successfully");

        // Inserting Username for Login
        if(Login.Input_UserName.isDisplayed())
        {loginTest.log(Status.INFO, "Username input field is visible and Inserting username");
            Login.Input_UserName.sendKeys(LoginUser);
            Thread.sleep(2000);}
        else loginTest.fail("Username Input field not able to locate");

        // Inserting Password for Login
        if(Login.Input_LoginPass.isDisplayed())
        {loginTest.log(Status.INFO, "Password input field is visible and Inserting password");
            Login.Input_LoginPass.sendKeys(LoginPass);
            Thread.sleep(2000);}
        else loginTest.fail("Password Input field not able to locate");


        // Clicking on Login Button
        if(Login.Login_btn.isDisplayed())
        {loginTest.log(Status.INFO, "Login button is visible and Clicking after inserting credentials");
            Login.Login_btn.click();
            Thread.sleep(3000);}
        else loginTest.fail("Login button not able to locate");

        // Verify Logged into Application
        if(HomePage.app_menu.isDisplayed())
            loginTest.pass("Home page of Application is successfully Loaded");
        else loginTest.fail("Application Home Page is loaded successfully");



    }
}
