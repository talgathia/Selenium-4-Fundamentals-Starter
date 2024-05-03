package uitest.m6;

import helper.DemoHelper;
import helper.DriverFactory2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static helper.Pages.*;
import org.openqa.selenium.Alert;

public class HandleDialogTest {

    @Test
    void dismissAlertTest() {
        WebDriver driver = DriverFactory2.newDriver();
        driver.get(HOME);

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));

        firstName.sendKeys("John");
        lastName.sendKeys("Smith");

        DemoHelper.pause();
        driver.findElement(By.id("clear")).click();


        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Assert.assertEquals(firstName.getAttribute("value"), "John");
        Assert.assertEquals(lastName.getAttribute("value"), "Smith");

        driver.quit();
    }

    @Test
    void acceptAlertTest() {
        WebDriver driver = DriverFactory2.newDriver();
        driver.get(HOME);

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));

        firstName.sendKeys("John");
        lastName.sendKeys("Smith");

        DemoHelper.pause();
        driver.findElement(By.id("clear")).click();


        Alert alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertEquals(firstName.getAttribute("value"), "");
        Assert.assertEquals(lastName.getAttribute("value"), "");

        driver.quit();
    }
}
