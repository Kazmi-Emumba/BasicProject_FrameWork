package Base;

import Variables.configReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pageFactory.HomePage;
import pageFactory.LoginPage;
import utils.ExtentManager;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import static Base.ApplicationLogin.*;
import static org.testng.AssertJUnit.fail;
@Listeners(utils.TestListeners.class)
public class BaseClass {

    public WebDriver driver;
    LoginPage Login;

    HomePage HomePage;

    protected String AppUrl;
    protected String BrowserType;
    protected String ExecutionMode;
    protected StringBuffer verificationErrors = new StringBuffer();

   /* protected static ExtentReports extent = new ExtentReports();
    protected static ExtentSparkReporter spark = new ExtentSparkReporter("index.html");

    public static ExtentReports getExtent() {
        extent.attachReporter(spark);
        spark.config().setDocumentTitle("Automation Assignment Report");
        spark.config().setReportName("Project Setup Training");
        return extent;
    }*/

    @BeforeClass
    public void suiteSetUP() throws InterruptedException {
        configReader.initializePropertyFile();
        BrowserType= configReader.property.getProperty("BrowserType");
        ExecutionMode= configReader.property.getProperty("ExecutionMode");
        AppUrl= configReader.property.getProperty("APP_URL");
        try {
            initialize(BrowserType,AppUrl,ExecutionMode);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void initialize(String BrowserType,String AppURLProperty, String RunMode) throws InterruptedException{

        if(BrowserType.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(BrowserType.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            try {
                driver = new RemoteWebDriver(new URI("http://localhost:4444/").toURL(), options);
            } catch (URISyntaxException | MalformedURLException e) {
                throw new RuntimeException(e);
            }
            //driver = new FirefoxDriver();
        }
        else if(BrowserType.equalsIgnoreCase("edge"))
        {

           if(RunMode.equalsIgnoreCase("seleniumgrid"))
           {
               EdgeOptions options = new EdgeOptions();
            try {
                driver = new RemoteWebDriver(new URI("http://localhost:4444/").toURL(), options);
                WebDriverManager.edgedriver().setup();
            } catch (URISyntaxException | MalformedURLException e) {
                throw new RuntimeException(e);
            }
           }
           else{
               WebDriverManager.edgedriver().setup();
               driver = new EdgeDriver();
           }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get(AppURLProperty);


    }
    public void ApplicationLoginTry() throws InterruptedException {
        Login= PageFactory.initElements(driver, LoginPage .class);
        HomePage= PageFactory.initElements(driver, HomePage .class);
        Login.LoginPage_isdisplayed();
        Login.LoginPage_inputUser();
        Login.LoginPage_inputPass();
        Login.LoginPage_LoginbuttonClick();
        HomePage.HomePage_isdisplayed();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {

        cleanUp();
    }

    protected void cleanUp(){
        //extent.flush();

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
        this.driver.quit();

    }


}
