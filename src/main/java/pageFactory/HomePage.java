package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
    final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Open Menu')]")
    public WebElement app_menu;


    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Logout')]")
    public WebElement app_logout;




    public HomePage(WebDriver driver){

        this.driver = driver;

    }
}
