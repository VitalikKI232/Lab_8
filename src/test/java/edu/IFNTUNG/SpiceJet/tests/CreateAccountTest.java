package edu.IFNTUNG.SpiceJet.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateAccountTest {
    private WebDriver driver;
    private static final String SPICEJET_URL = "https://spiceclub.spicejet.com/signup";
    private static final String SUCCESS_MESSAGE = "OTP Verification";

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
    public void CreateAccount(){
        WebElement TitleList = driver.findElement(By.xpath("//select[@class = 'form-control form-select ']"));
        TitleList.click();
        WebElement Title = driver.findElement(By.xpath("//option[text() = 'Mr']"));
        Title.click();
        WebElement FirstNameField = driver.findElement(By.xpath("//input[@id = 'first_name']"));
        FirstNameField.sendKeys("Vitalii");
        WebElement LastNameField = driver.findElement(By.xpath("//input[@id = 'last_name']"));
        LastNameField.sendKeys("Oliinyk");
        WebElement CountryList = driver.findElement(By.xpath("//select[@class = 'form-control form-select']"));
        CountryList.click();
        WebElement ChooseCountry = driver.findElement(By.xpath("//option[@value = 'UA']"));
        ChooseCountry.click();
        WebElement BirthField = driver.findElement(By.xpath("//input[@id = 'dobDate']"));
        BirthField.sendKeys("01/23/2005");
        BirthField.sendKeys(Keys.RETURN);
        WebElement NumberCode = driver.findElement(By.xpath("//div[@class = ' flag-dropdown']"));
        NumberCode.click();
        WebElement ChooseNumCode = driver.findElement(By.xpath("//li[@data-flag-key = 'flag_no_198']"));
        ChooseNumCode.click();
        WebElement NumberField = driver.findElement(By.xpath("//input[@type = 'tel']"));
        NumberField.sendKeys("506812469");
        NumberField.sendKeys(Keys.RETURN);
        //Зявлялося вікно збереження номеру на секунду а код продовжував працювати і вводити пошту но вона не відображалася
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement EmailField = driver.findElement(By.xpath("//input[@id = 'email_id']"));
        EmailField.sendKeys("vitalii.oliinyk-ki232@nung.edu.ua");
        EmailField.sendKeys(Keys.TAB);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement PasswordField = driver.findElement(By.xpath("//input[@id = 'new-password']"));
        PasswordField.sendKeys("Ifntung2025!");
        WebElement ConfirmPasswordField = driver.findElement(By.xpath("//input[@id = 'c-password']"));
        ConfirmPasswordField.sendKeys("Ifntung2025!");
        WebElement ConditionsButton = driver.findElement(By.xpath("//input[@id = 'defaultCheck1']"));
        ConditionsButton.click();
        WebElement SubmitButton = driver.findElement(By.xpath("//button[@class = 'btn btn-red']"));
        SubmitButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement SuccessMessage = driver.findElement(By.xpath("//label[@class = 'modal-red-title mb-2']"));
        Assert.assertTrue(SuccessMessage.getText().contains(SUCCESS_MESSAGE));
    }
}