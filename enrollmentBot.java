import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert.*;


public class enrollmentBot {
    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
        //WebDriver driver = new FirefoxDriver();
        //comment the above 2 lines and uncomment below 2 lines to use Chrome

        System.setProperty("webdriver.chrome.driver","chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String baseUrl = "https://calcentral.berkeley.edu/academics";

        // launch chrome and direct it to the Base URL
        driver.get(baseUrl);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //LOGIN
        try {
            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement form = driver.findElement(By.id("form"));
            Assert.assertTrue(username.isDisplayed());

            username.sendKeys("usernamehere");
            password.sendKeys("passwordhere");
            form.submit();
        } catch(NoSuchElementException nsee) {
            System.out.println(":(");
        } catch(AssertionError ae) {
            System.out.println("The table was located, but not displayed.");
        }




        // Go to enrollment
        wait.until( ExpectedConditions.presenceOfElementLocated(By.name("enrollmentInstruction.links.chooseClasses.name")) );
        driver.findElement(By.name("enrollmentInstruction.links.chooseClasses.name")).click();



    }

}