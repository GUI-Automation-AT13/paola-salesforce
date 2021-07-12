package salesforce.test.before;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class SetUp {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Map<String, Object> vars;
    protected JavascriptExecutor js;

    @Before
    public void setUp() {
        ChromeOptions options=new ChromeOptions();
        Map<String, Object> prefs=new HashMap<String,Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
//1-Allow, 2-Block, 0-default
        options.setExperimentalOption("prefs",prefs);


        String PATH = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", PATH + "/drive/chrome/chromedriver");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        wait = new WebDriverWait(driver,30);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
