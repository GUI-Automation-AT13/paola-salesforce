package salesforce.test.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.test.before.GoToOpportunity;

public class OpportunityTest extends GoToOpportunity {

    @Test
    public void createOnlyWithRequiredField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[title='New']")));
        driver.findElement(By.cssSelector("a[title='New']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Name']")));
        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Only required opportunity");
        driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("7/31/2021");
        driver.findElement(By.xpath("//label[text()='Stage']/..//input[@class='slds-input slds-combobox__input']")).click();
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Prospecting']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='SaveEdit']")));
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//slot[@slot='primaryField']/lightning-formatted-text")));
        Assert.assertEquals(driver.findElement(By.xpath("//slot[@slot='primaryField']/lightning-formatted-text")).getText(), "Only required opportunity");
    }

    @Test
    public void createWithAllFields() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title=\'New\']")));
        driver.findElement(By.xpath("//a[@title=\'New\']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\'Name\']")));
        driver.findElement(By.xpath("//input[@name=\'Name\']")).sendKeys("All fields opportunity");
        driver.findElement(By.xpath("//input[@name=\'CloseDate\']")).sendKeys("7/31/2021");
        driver.findElement(By.xpath("//label[text()=\'Stage\']/..//input[@class=\'slds-input slds-combobox__input\']")).click();
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value=\'Prospecting\']")).click();
        driver.findElement(By.xpath("//input[contains(@placeholder,\'Accounts\')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title=\'Opportunity Account\']")));
        driver.findElement(By.xpath("//span[@title=\'Opportunity Account\']")).click();
        driver.findElement(By.xpath("//input[contains(@placeholder,\'Campaign\')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title=\'Opportunity Campaign\']")));
        driver.findElement(By.xpath("//span[@title=\'Opportunity Campaign\']")).click();
        driver.findElement(By.xpath("//label[text()=\'Type\']/..//input[@class=\'slds-input slds-combobox__input\']")).click();
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value=\'New Customer\']")).click();
        driver.findElement(By.xpath("//label[text()=\'Lead Source\']/..//input[@class=\'slds-input slds-combobox__input\']")).click();
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value=\'Web\']")).click();
        driver.findElement(By.xpath("//input[@name=\'Amount\']")).sendKeys("30,50");
        driver.findElement(By.xpath("//input[@name=\'NextStep\']")).sendKeys("Number#3");
        {
            WebElement element = driver.findElement(By.xpath("//input[@name=\'IsPrivate\']"));
            if (!element.isSelected()) {
                element.click();
            }
        }
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()=\'Delivery/Installation Status\']/..//input[@class=\'slds-input slds-combobox__input\']")));
        //driver.findElement(By.xpath("//label[text()=\'Delivery/Installation Status\']/..//input[@class=\'slds-input slds-combobox__input\']")).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//lightning-base-combobox-item[@data-value=\'Completed\']")));
        //driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value=\'Completed\']")).click();
        driver.findElement(By.xpath("//input[@name=\'MainCompetitors__c\']")).sendKeys("Comp. #45 Tom");
        driver.findElement(By.xpath("//input[@name=\'OrderNumber__c\']")).sendKeys("#4545-df");
        driver.findElement(By.xpath("//input[@name=\'CurrentGenerators__c\']")).sendKeys("Recent Gen");
        driver.findElement(By.xpath("//input[@name=\'TrackingNumber__c\']")).sendKeys("#45-132.21QR");
        driver.findElement(By.xpath("//textarea[@class=\'slds-textarea\']")).sendKeys("Description of the new opportunity, created with all the fields.");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name=\'SaveEdit\']")));
        driver.findElement(By.xpath("//button[@name=\'SaveEdit\']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//slot[@slot='primaryField']/lightning-formatted-text")));
        Assert.assertEquals(driver.findElement(By.xpath("//slot[@slot='primaryField']/lightning-formatted-text")).getText(), "All fields opportunity");
    }
}
