package ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTestHRM extends BaseTest{
    @Test
    void loginTest() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);

        WebElement uName = driver.findElement(By.name("username"));
        uName.click();

        uName.sendKeys("Admin");
        Thread.sleep(3000);

        WebElement pass = driver.findElement(By.name("password"));
        pass.click();
        pass.sendKeys("admin123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();

        Thread.sleep(3000);

      }
}
