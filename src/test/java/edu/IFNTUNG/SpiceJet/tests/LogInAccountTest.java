package edu.IFNTUNG.SpiceJet.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogInAccountTest {
    private WebDriver driver;
    private static final String SPICEJET_URL = "https://www.spicejet.com/";
    private static final String ERROR_MESSAGE = "Please enter valid mobile number";

    @BeforeTest
    private void driverSetUp(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(SPICEJET_URL);
    }

    @AfterMethod
    public void driverClose(){
        driver.quit();
    }

    @Test
    public void LogIn(){
        WebElement LogInButton = driver.findElement(By.xpath("//div[text() = 'Login']"));
        LogInButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement NumberField = driver.findElement(By.xpath("//input[@data-testid='user-mobileno-input-box']"));
        NumberField.sendKeys("123456");
        WebElement PasswordField = driver.findElement(By.xpath("//input[@data-testid = 'password-input-box-cta']"));
        PasswordField.sendKeys("123456");
        WebElement ErrorMessage = driver.findElement(By.xpath("//div[@class = 'css-76zvg2 r-1ttbpl1 r-2t9rge r-1enofrn r-1bymd8e']"));
        Assert.assertTrue(ErrorMessage.getText().contains(ERROR_MESSAGE));
    }
}
