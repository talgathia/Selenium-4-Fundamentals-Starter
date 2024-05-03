package uitest.m5;

import helper.DemoHelper;
import helper.DriverFactory2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static helper.Pages.*;

public class ByLinkTest {

    @Test
    public void byLinkText() {
        WebDriver driver = DriverFactory2.newDriver();
        driver.get(HOME);

        driver.findElement(By.linkText("Savings")).click();
        DemoHelper.pause();

        driver.findElement(By.partialLinkText("Reg")).click();
        DemoHelper.pause();

        driver.quit();

    }
}
