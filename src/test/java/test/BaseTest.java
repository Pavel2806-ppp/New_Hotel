package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.hotel.utils.Config;
import net.hotel.utils.LogUtil;
import net.hotel.utils.TestHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected  WebDriver driver;
    protected Properties config = Config.readProperties("conf.properties");
    private static Logger log = LogUtil.getLogger(BaseTest.class);


    protected BaseTest() {
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase ("chrome")){
            WebDriverManager
                    .chromedriver()
                    .browserVersion (config.getProperty ("conf.version"))
                    .setup();
           driver = new ChromeDriver ();
            log.info(String.format("Navigate to %s", config.getProperty("conf.https")));
        }else if (browser.equalsIgnoreCase("opera")){
            WebDriverManager.operadriver ().setup ();
            driver = new OperaDriver ();
        }else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver ().setup ();
            driver = new FirefoxDriver ();
        }else if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver ().setup ();
            driver = new EdgeDriver ();
        }
       // System.setProperty ("webdriver.chrome.driver", "C:\\Users\\Павел\\.cache\\selenium\\chromedriver\\win32\\88.0.4324.96\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage ().timeouts ().pageLoadTimeout (30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate ().to (config.getProperty ("conf.https"));

    }
    @AfterMethod
    public void teardown() {
        log.info("Close browser");
        TestHelper.sleepSeconds(3l);
        driver.quit();
    }

}
