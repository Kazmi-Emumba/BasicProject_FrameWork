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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.fail;

public class BaseClass {

    protected WebDriver driver;

    protected String AppUrl;
    protected String BrowserType;
    protected StringBuffer verificationErrors = new StringBuffer();
    protected static ExtentReports extent = new ExtentReports();
    protected static ExtentSparkReporter spark = new ExtentSparkReporter("index.html");

    public static ExtentReports getExtent() {
        extent.attachReporter(spark);
        spark.config().setDocumentTitle("Automation Assignment Report");
        spark.config().setReportName("Project Setup Training");
        return extent;
    }

    @BeforeClass
    public void suiteSetUP() throws InterruptedException {
        configReader.initializePropertyFile();
        BrowserType= configReader.property.getProperty("BrowserType");

        AppUrl= configReader.property.getProperty("APP_URL");
        try {
            initialize(BrowserType,AppUrl);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void initialize(String BrowserType,String AppURLProperty) throws InterruptedException{

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
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            //driver = new FirefoxDriver();
        }
        else if(BrowserType.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
           /* EdgeOptions options = new EdgeOptions();
            try {
                driver = new RemoteWebDriver(new URI("http://localhost:4444/").toURL(), options);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }*/
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get(AppURLProperty);




    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {

        cleanUp();
    }

    protected void cleanUp(){
        extent.flush();
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }

    }


}
