package uitest.m4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static helper.Pages.*;

public class WaitingTest {

    WebDriver driver;

    @Test
    public void implicitWaitTest() {
        driver = new ChromeDriver();
        driver.get(LOANS);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.findElement(By.id("borrow")).sendKeys("500");


        // Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());
        // already in HTML, not added by JavaScript - therfore is not affected by the implicit wait! We'll leave it out.

        driver.findElement(By.id("result")).click();
        // logically, it's not clickable. But using actions like clicking and typing forces Selenium to wait for the element.

        driver.quit();
    }
}
