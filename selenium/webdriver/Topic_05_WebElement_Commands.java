package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

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
//        WebElement name = driver.findElement(By.xpath("//h5[contains(text(),'User5')]");
//        assertEquals(name.isDisplayed(),false);
//        driver.findElement(By.xpath("//img[@alt='User Avatar 05']")).click();
//        WebElement viewProfile = driver.findElement(By.xpath("//img[@alt='User Avatar 05']"));


        email.sendKeys("Automation Test");
        assertEquals("Automation Test", email.getDomProperty("value"));
        edu.sendKeys("Automation Test");
        assertEquals("Automation Test",edu.getDomProperty("value"));
//        under18.click();

//        //Check if elements displayed and print the result to console
//        if (name.isDisplayed() == true && viewProfile.isDisplayed() == true) {
//            System.out.println("Element is displayed");
//        } else {
//            System.out.println("Element is not displayed");
//        }
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
        if(javaCheckbox.isSelected() == true && under18.isSelected() == true) {
            System.out.println("Element is selected");
        } else
        {
            System.out.println("Element is de-selected");
        }
        javaCheckbox.click();
        if(javaCheckbox.isSelected() == true && under18.isSelected() == true) {
            System.out.println("Element is selected");
        } else
        {
            System.out.println("Element is de-selected");
        }
        driver.quit();
    }

}

