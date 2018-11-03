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


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import gvjava.org.json.JSONException;
import gvjava.org.json.JSONObject;

import com.techventus.server.voice.Voice;
import com.techventus.server.voice.datatypes.AllSettings;
import com.techventus.server.voice.datatypes.Contact;
import com.techventus.server.voice.datatypes.DisabledForwardingId;
import com.techventus.server.voice.datatypes.Group;
import com.techventus.server.voice.datatypes.Phone;
import com.techventus.server.voice.datatypes.Greeting;
import com.techventus.server.voice.datatypes.records.SMS;
import com.techventus.server.voice.datatypes.records.SMSThread;
import com.techventus.server.voice.exception.CaptchaRequiredException;
import com.techventus.server.voice.util.ParsingUtil;



public class loginBot {
    public static void main(String[] args) throws Exception {



        /**
        try {
            Voice voice = new Voice("enrollmentbot", "calhacks2018","GoogleVoiceJava",true,Voice.GOOGLE);
            String messages = voice.getRecent();
            System.out.println(messages);

        } catch (Exception e){
            System.out.println("failed");
        }
         **/



        System.setProperty("webdriver.chrome.driver","chromedriver/chromedriver");

        WebDriver voice = new ChromeDriver();
        WebDriverWait waitV = new WebDriverWait(voice, 10);
        voice.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String voiceURL = "https://voice.google.com/about";

        voice.get(voiceURL);




        ((ChromeDriver) voice).findElementByXPath("//*[@id=\"header\"]/div[2]/a\n").click();
        ((ChromeDriver) voice).findElementByXPath("//*[@id=\"identifierId\"]").sendKeys("enrollmentbot@gmail.com\n");
        ((ChromeDriver) voice).findElementByXPath("//*[@id=\"password\"]/div[1]/div/div[1]/input").sendKeys("calhacks2018\n");
        ((ChromeDriver) voice).findElementByXPath("/html/body/div[1]/div[2]/div[2]/gv-mini-nav/md-content/div[1]/gv-nav-tab[2]/div/gv-nav-item/div[1]/ng-transclude[1]/gv-nav-item-icon/md-icon\n").click();


        WebDriver enrollmentDriver = new ChromeDriver();
        WebDriverWait waitE = new WebDriverWait(enrollmentDriver, 10);
        enrollmentDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String enrollmentURL = "https://calcentral.berkeley.edu";

        // launch chrome and direct it to the Base URL
        enrollmentDriver.get(enrollmentURL);

        enrollmentDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //LOGIN

        try {
            //sign in button
            ((ChromeDriver) enrollmentDriver).findElementByXPath("//*[@id=\"cc-main-content\"]/div[2]/div/div[1]/div[2]/button").click();

            String username = "INSERT_USERNAME";
            String password = "INSERT_PASSWORD!";
            //username field
            ((ChromeDriver) enrollmentDriver).findElementByXPath("//*[@id=\"username\"]").sendKeys(username);
            //password field
            ((ChromeDriver) enrollmentDriver).findElementByXPath("//*[@id=\"password\"]").sendKeys(password);
            //click on log in button
            ((ChromeDriver) enrollmentDriver).findElementByXPath("//*[@id=\"loginForm\"]/fieldset/p[4]/input[4]\n").click();

            ((ChromeDriver) enrollmentDriver).findElementByXPath("//*[@id=\"passcode\"]\n").click();


        } catch(NoSuchElementException nsee) {
            System.out.println(":(");
        } catch(AssertionError ae) {
            System.out.println("The table was located, but not displayed.");
        }



    }

}