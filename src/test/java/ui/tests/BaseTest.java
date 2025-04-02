package ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    WebDriver driver;
    Properties prop;

    @BeforeTest
    void setup() throws IOException, InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        prop = new Properties();
        prop.load(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config.properties"));
        System.out.println("Path of project is : "+System.getProperty("user.dir"));
        //loginIntoApplication(prop.getProperty("hrmUrl"));
    }

    @AfterTest
    void tearDown(){
        driver.close();
        driver.quit();
    }

    void loginIntoApplication(String url) throws InterruptedException {
        driver.get(url);
        WebElement uName = driver.findElement(By.name("username"));
        uName.click();

        uName.sendKeys("Admin");
        Thread.sleep(3000);

        WebElement pass = driver.findElement(By.name("password"));
        pass.click();
        pass.sendKeys("admin123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
    }

}
