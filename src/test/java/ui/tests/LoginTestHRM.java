package ui.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTestHRM {

    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        // Load target application
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Enter username
        WebElement userName = driver.findElement(By.name("username"));
        userName.click();
        userName.sendKeys("Admin");

        // Enter password
        WebElement pass = driver.findElement(By.name("password"));
        pass.click();
        pass.sendKeys("admin123");

        Thread.sleep(3000);

        // Click on Login Button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(3000);


        driver.close();
        driver.quit();
    }
}
