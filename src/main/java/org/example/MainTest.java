package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainTest {

    private WebDriver driver;

    @BeforeMethod
    public void SetUp() {
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\alan.arandia\\Documents\\SDET\\Cdriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void Tests1() throws InterruptedException{
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        String webTitle = driver.getTitle();
        String Expected = "DEMOQA";
        Assert.assertEquals(webTitle, Expected);
    }

    @Test
    public void Tests2() throws InterruptedException{
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        WebElement firstName = driver.findElement(By.id("firstName"));
        //Thread.sleep(3000);
        //firstName.click();
        firstName.sendKeys("Alan");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Jaimes");
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("a@a.com");
        //Thread.sleep(3000);
        WebElement genderRadio1 = driver.findElement(By.xpath("//input[@id='gender-radio-1']//..//label"));
        //Thread.sleep(3000);
        genderRadio1.click();
        WebElement userNumber = driver.findElement(By.id("userNumber"));
        userNumber.sendKeys("6077153600");
        /*Thread.sleep(3000);
        WebElement checkBox1 = driver.findElement(By.cssSelector()
        Thread.sleep(3000);
        checkBox1.click();
*/
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        }

}
