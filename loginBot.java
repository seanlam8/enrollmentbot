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
import com.techventus.server.voice.Voice;


public class loginBot {
    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
        //WebDriver driver = new FirefoxDriver();
        //comment the above 2 lines and uncomment below 2 lines to use Chrome

        System.setProperty("webdriver.chrome.driver","chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String baseUrl = "https://calcentral.berkeley.edu";

        // launch chrome and direct it to the Base URL
        driver.get(baseUrl);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //LOGIN

        try {
            ((ChromeDriver) driver).findElementByXPath("//*[@id=\"cc-main-content\"]/div[2]/div/div[1]/div[2]/button").click();

            String username = "INSERT_USERNAME_HERE";
            String password = "INSERT_PASSWORD_HERE";
            ((ChromeDriver) driver).findElementByXPath("//*[@id=\"username\"]").sendKeys(username);
            ((ChromeDriver) driver).findElementByXPath("//*[@id=\"password\"]").sendKeys(password);
            ((ChromeDriver) driver).findElementByXPath("//*[@id=\"loginForm\"]/fieldset/p[4]/input[4]\n").click();
        } catch(NoSuchElementException nsee) {
            System.out.println(":(");
        } catch(AssertionError ae) {
            System.out.println("The table was located, but not displayed.");
        }



    }

}