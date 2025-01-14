package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

//second commit
public class Topic_05_WebBrowser_Commands {
    WebDriver driver;

    @Test
    public void TC_01_VerifyURL() {
        driver = new ChromeDriver();
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        String loginURL = driver.getCurrentUrl();
        assertEquals("https://live.techpanda.org/index.php/customer/account/login/",loginURL);
        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
        String createAccountURL = driver.getCurrentUrl();
        assertEquals("https://live.techpanda.org/index.php/customer/account/create/",createAccountURL);
        driver.quit();
    }

    @Test
    public void TC_02_VerifyTitle() {
        driver = new ChromeDriver();
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        String loginPageTitle = driver.getTitle();
        assertEquals("Customer Login",loginPageTitle);
        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
        String createAccountPageTitle = driver.getTitle();
        assertEquals("Create New Customer Account",createAccountPageTitle);
        driver.quit();
    }

    @Test
    public void TC_03_NavigateFunction() {
        driver = new EdgeDriver();
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
        String registerPageURL = driver.getCurrentUrl();
        assertEquals("https://live.techpanda.org/index.php/customer/account/create/", registerPageURL);
        driver.navigate().back();
        String loginPageURL = driver.getCurrentUrl();
        assertEquals("https://live.techpanda.org/index.php/customer/account/login/",loginPageURL);
        driver.navigate().forward();
        String registerPageTitle2 = driver.getTitle();
        assertEquals("Create New Customer Account", registerPageTitle2);
        driver.quit();
    }

    @Test
    public void TC_04_GetPageSource() {
        driver = new EdgeDriver();
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        String actualText = driver.getPageSource();
        Assert.assertTrue(actualText.contains("Login or Create an Account"));

//        assertEquals("https://live.techpanda.org/index.php/customer/account/create/", registerPageURL)
//        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
//        ;
//        driver.navigate().back();
//        String loginPageURL = driver.getCurrentUrl();
//        assertEquals("https://live.techpanda.org/index.php/customer/account/login/",loginPageURL);
//        driver.navigate().forward();
//        String registerPageTitle2 = driver.getTitle();
//        assertEquals("Create New Customer Account", registerPageTitle2);
        driver.quit();
    }
}

