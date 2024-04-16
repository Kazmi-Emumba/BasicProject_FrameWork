package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    final WebDriver driver;

    @FindBy(how = How.CSS, using = "input[placeholder='Username']")
    public WebElement Input_UserName;

    @FindBy(how = How.CSS, using = "input[placeholder='Password']")
    public WebElement Input_LoginPass;

    @FindBy(how = How.ID, using = "login-button")
    public WebElement Login_btn;
    @FindBy(how = How.CSS, using = "div[class='login_logo']")
    public WebElement Login_logo;

    public LoginPage(WebDriver driver){

        this.driver = driver;

    }
}
