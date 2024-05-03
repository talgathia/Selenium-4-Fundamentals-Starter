package uitest.m6;

import helper.DriverFactory2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static helper.Pages.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

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


    @Test
    public void explicitWaitTest() {
        driver = new ChromeDriver();
        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("500");

        WebElement result = waitUntilClickable(driver, By.id("result"));
        Assert.assertTrue(result.isDisplayed());

        driver.quit();
    }


    @Test
    public void fluentWaitTest() {
        driver = DriverFactory2.newDriver();
        driver.get(LOANS);
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(6))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);
        // Method chaining - makes code more fluent to read - hence the name 'fluent wait'.

        driver.findElement(By.id("borrow")).sendKeys("500");

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        element.click();


        driver.quit();
    }

    public static WebElement waitUntilClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(6)).until(elementToBeClickable(locator));
    }
}
