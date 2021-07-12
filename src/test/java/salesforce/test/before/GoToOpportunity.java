package salesforce.test.before;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoToOpportunity extends Login {

    @Before
    public void goMainOpportunity() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".slds-icon-waffle_container")));
        driver.findElement(By.cssSelector(".slds-icon-waffle_container")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='slds-size_medium']")));
        driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("opportunities");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='Opportunity']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='Opportunity']/parent::*")));
        driver.findElement(By.xpath("//a[@id='Opportunity']/parent::*")).click();
    }
}
