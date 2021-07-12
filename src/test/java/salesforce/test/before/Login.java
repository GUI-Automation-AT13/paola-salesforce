package salesforce.test.before;

import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static config.VariableConfiguration.envVariables;

public class Login extends SetUp{

    @Before
    public void Login() {
        driver.get(envVariables("LOGIN_URL"));
        driver.findElement(By.id("username")).sendKeys(envVariables("USER"));
        driver.findElement(By.id("password")).sendKeys(envVariables("PASS"));
        driver.findElement(By.id("Login")).click();
    }

    @After
    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".branding-userProfile-button")));
        driver.findElement(By.cssSelector(".branding-userProfile-button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log Out")));
        driver.findElement(By.linkText("Log Out")).click();
    }
}
