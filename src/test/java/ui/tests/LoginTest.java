package ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;
    Actions action;
    @BeforeClass
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        action = new Actions(driver);
    }

    @Test
    void LoginToApp() throws InterruptedException {
        driver.get("https://snapdeal.com/");
        dismissOfferNotification();
        Thread.sleep(3000);
        WebElement signInSection = driver.findElement(By.xpath("//span[starts-with(@class,'accountUserName')]"));
        action.moveToElement(signInSection).build().perform();
        Thread.sleep(3000);
        WebElement loginBtn = driver.findElement(By.xpath("//a[text()='login']"));
        //action.moveToElement(loginBtn).build().perform();
        loginBtn.click();
    }

    @AfterClass
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

    void dismissOfferNotification(){
        try{
            driver.findElement(By.id("pushDenied")).click();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}