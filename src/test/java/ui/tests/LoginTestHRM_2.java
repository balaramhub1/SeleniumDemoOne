package ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTestHRM_2 extends BaseTest{
    @Test
    void loginTest() throws InterruptedException {
        driver.get(prop.getProperty("hrmUrl"));
        Thread.sleep(3000);

        WebElement uName = driver.findElement(By.name("username"));
        uName.click();

        uName.sendKeys(prop.getProperty("username"));
        Thread.sleep(3000);

        WebElement pass = driver.findElement(By.name("password"));
        pass.click();
        pass.sendKeys(prop.getProperty("password"));

        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();

        Thread.sleep(3000);

      }
}
