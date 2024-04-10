package uitest.m4;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static helper.Pages.*;

public class ByCssTest {

    WebDriver driver;

    @Test
    public void byCssSelector() {
        driver = DriverFactory.newDriver();
        driver.get(HOME);
        WebElement datePicker = driver.findElement(By.cssSelector("input[type=date]"));
        datePicker.sendKeys("01/01/2000");

        DemoHelper.pause();

        driver.quit();

    }

}
