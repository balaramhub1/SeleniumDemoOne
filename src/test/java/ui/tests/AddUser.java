package ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class AddUser extends BaseTest{

    @Test
    public void addUserTest() throws InterruptedException {
        loginIntoApplication(prop.getProperty("hrmUrl"));

        Thread.sleep(3000);
        // Click on Admin link
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        Thread.sleep(3000);

        // Input username
        List<WebElement> searchBar = driver.findElements(By.xpath("//div/input[starts-with(@class,'oxd-input')]"));
        searchBar.get(1).sendKeys("NewEmployee101");
        Thread.sleep(3000);

        // Input Employee Name
        driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("samar");
        Thread.sleep(3000);

        // Click on Add button
        driver.findElement(By.xpath("//button[text()=' Add ']")).click();

        List<WebElement> userRole_Status = driver.findElements(By.xpath("//div[text()='-- Select --']"));
        WebElement userRole = userRole_Status.get(0);
        WebElement Status = userRole_Status.get(1);

        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[text()=' Add ']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()=' Cancel ']")).click();

        Thread.sleep(3000);

    }
}
