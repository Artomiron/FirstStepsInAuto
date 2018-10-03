package base;

//import com.sun.tools.sjavac.Log;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.logging.Logger;


public class BaseTest {
    protected WebDriver driver;
    protected Logger log;

    @BeforeClass
    protected void setUpClass(ITestContext ctx){
        String testName = ctx.getCurrentXmlTest().getName();
        log = Logger.getLogger(testName);
    }
    @Parameters({ "browser" })

    @BeforeMethod
    protected void methodSetUp(String browser){
        log.info("Method set up");
        driver = BrowserFactory.getDriver(browser, log);


    }

    @AfterMethod
    protected void methodTearDown() {
        log.info("Method tear down");
        driver.quit();
    }
}
