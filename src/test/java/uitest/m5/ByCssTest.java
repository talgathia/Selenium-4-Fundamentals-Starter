package uitest.m5;

import helper.DemoHelper;
import helper.DriverFactory2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static helper.Pages.*;

public class ByCssTest {

    WebDriver driver;

    @Test
    public void byCssSelector() {
        driver = DriverFactory2.newDriver();
        driver.get(HOME);
        WebElement datePicker = driver.findElement(By.cssSelector("input[type=date]"));
        datePicker.sendKeys("01/01/2000");

        DemoHelper.pause();

        driver.quit();

    }

    @Test
    public void byCssSelector_2() {
        driver = DriverFactory2.newDriver();
        driver.get(HOME);
        WebElement checkbox = driver.findElement(By.cssSelector("[type=checkbox]:not(:checked)"));
        checkbox.click();

        DemoHelper.pause();
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

}
