package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

//second commit
public class Topic_05_WebElement_Commands {
    WebDriver driver;

    @Test
    public void TC_01_CheckElementIsDisplayed() {
        driver = new ChromeDriver();
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement email = driver.findElement(By.name("user_email"));
        email.isDisplayed();
        WebElement under18 = driver.findElement(By.id("under_18"));
        under18.isDisplayed();
        WebElement edu = driver.findElement(By.id("edu"));
        edu.isDisplayed();
        WebElement name = driver.findElement(By.xpath("//h5[contains(text(),'User5')]"));
        Assert.assertFalse(name.isDisplayed());
        driver.findElement(By.xpath("//img[@alt='User Avatar 05']")).click();
        WebElement viewProfile = driver.findElement(By.xpath("//img[@alt='User Avatar 05']"));


        email.sendKeys("Automation Test");
        assertEquals("Automation Test", email.getDomProperty("value"));
        edu.sendKeys("Automation Test");
        assertEquals("Automation Test",edu.getDomProperty("value"));
//        under18.click();

        //Check if elements displayed and print the result to console
        if (name.isDisplayed() && viewProfile.isDisplayed()) {
            System.out.println("Element is displayed");
        } else {
            System.out.println("Element is not displayed");
        }
        driver.quit();
    }

    @Test
    public void TC_02_CheckElementIsDisplayed() {
        driver = new ChromeDriver();
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if(driver.findElement(By.name("user_email")).isEnabled()){
            System.out.println("Email is enabled");
        } else {
            System.out.println("Email is disabled");
        }

        if(driver.findElement(By.name("user_edu")).isEnabled()){
            System.out.println("Edu is enabled");
        } else {
            System.out.println("Edu is disabled");
        }

        if(driver.findElement(By.name("user_job1")).isEnabled()){
            System.out.println("Job role 1 is enabled");
        } else {
            System.out.println("Job role 1 disabled");
        }


        if(driver.findElement(By.name("user_job2")).isEnabled()){
            System.out.println("Job role 2 is enabled");
        } else {
            System.out.println("Job role 2 disabled");
        }

            if (driver.findElement(By.id("check-disbaled")).isEnabled()) {
                System.out.println("Interest Checkbox is enabled");
            } else {
                System.out.println("Interest Checkbox disabled");
            }

            if (driver.findElement(By.name("slider-1")).isEnabled()) {
                System.out.println("Slider 1 is enabled");
            } else {
                System.out.println("Slider 1 disabled");
            }

            if (driver.findElement(By.id("disable_password")).isEnabled()) {
                    System.out.println("Password is enabled");
            } else {
                    System.out.println("Password disabled");
                }
        driver.quit();
        }

    @Test
    public void TC_03_CheckElementIsSelected() {
        driver = new ChromeDriver();
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement under18 = driver.findElement(By.id("under_18"));
        under18.click();
        WebElement javaCheckbox = driver.findElement(By.id("java"));
        javaCheckbox.click();
        if(javaCheckbox.isSelected() && under18.isSelected()) {
            System.out.println("Element is selected");
        } else
        {
            System.out.println("Element is de-selected");
        }
        javaCheckbox.click();
        if(javaCheckbox.isSelected() && under18.isSelected()) {
            System.out.println("Element is selected");
        } else
        {
            System.out.println("Element is de-selected");
        }
        driver.quit();
    }

    @Test
    public void TC_04_MailChimp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.cssSelector("#email")).sendKeys("motcanhcay@gmail.com");
        driver.findElement(By.cssSelector("#new_password")).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("li[class='username-check not-completed']")));

        Thread.sleep(3000);

        WebElement newPassword = driver.findElement(By.cssSelector("#new_password"));
//        WebElement failLowerCase = driver.findElement(By.cssSelector("li.lowercase-char.not-completed"));
//        WebElement failUpperCase = driver.findElement(By.cssSelector("li.uppercase-char.not-completed"));
//        WebElement fail1Num = driver.findElement(By.cssSelector("li.number-char.not-completed"));
//        WebElement fail1SpecialChar = driver.findElement(By.cssSelector("li.special-char.not-completed"));
//        WebElement failMin8Chars = driver.findElement(By.cssSelector("li[class='8-char not-completed']"));
//        WebElement failNotContainUsername = driver.findElement(By.cssSelector("li[class='username-check not-completed']"));

//        WebElement passLowerCase = driver.findElement(By.cssSelector("li.lowercase-char.completed"));
//        WebElement passUpperCase = driver.findElement(By.cssSelector("li.uppercase-char.completed"));
//        WebElement pass1Num = driver.findElement(By.cssSelector("li.number-char.completed"));
//        WebElement pass1SpecialChar = driver.findElement(By.cssSelector("li.special-char.completed"));
//        WebElement passMin8Chars = driver.findElement(By.cssSelector("li[class='8-char completed]"));
//        WebElement passNotContainUsername = driver.findElement(By.cssSelector("li.username-check.completed"));

        Thread.sleep(3000);
        //empty
        newPassword.clear();
        newPassword.sendKeys("");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='username-check not-completed']")).isDisplayed());

        Thread.sleep(3000);

        //only lowercase
        newPassword.clear();
        newPassword.sendKeys("asda");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        Thread.sleep(3000);
        //only uppercase
        newPassword.clear();
        newPassword.sendKeys("ASLKFS");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        Thread.sleep(3000);
        //only special char
        newPassword.clear();
        newPassword.sendKeys("#@$#");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        Thread.sleep(3000);
        //only number
        newPassword.clear();
        newPassword.sendKeys("11111");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        Thread.sleep(3000);
        //only 8-char
        newPassword.clear();
        newPassword.sendKeys("Testtttttt");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        Thread.sleep(3000);
        //only username
        newPassword.clear();
        newPassword.sendKeys("motcanhcay@gmail.com");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());

        Thread.sleep(3000);
        //valid password
        newPassword.clear();
        newPassword.sendKeys("Test@123456");
        Assert.assertFalse(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        driver.quit();


    }

}

