package uitest.m4;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static helper.Pages.*;

public class ClickingTest {

    @Test
    public void clickingTest() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement checkbox = driver.findElement(By.id("heard-about"));
        WebElement registerBtn = driver.findElement(By.id("register"));

        checkbox.click();
        registerBtn.click();
        DemoHelper.pause();


        driver.quit();
    }
}
