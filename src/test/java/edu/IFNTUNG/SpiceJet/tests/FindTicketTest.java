package edu.IFNTUNG.SpiceJet.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.Zip;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindTicketTest {
    private WebDriver driver;
    private static final String SPICEJET_URL = "https://www.spicejet.com/";

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
    public void FindTicket(){
        WebElement FromField = driver.findElement(By.xpath("//div[text()='From']/following-sibling::div//input[@autocapitalize='sentences']"));
        FromField.sendKeys("Del");
        WebElement ToField = driver.findElement(By.xpath("//div[text()='To']/following-sibling::div//input[@autocapitalize='sentences']"));
        ToField.sendKeys("Mum");
        WebElement DepartureDate = driver.findElement(By.xpath("//div[@class = 'css-1dbjc4n r-1awozwy r-16ru68a r-y47klf r-1loqt21 r-17b3b9k r-1otgn73 r-1aockid']"));
        DepartureDate.click();
        WebElement SearchTicket = driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']"));
        SearchTicket.click();
    }
}
