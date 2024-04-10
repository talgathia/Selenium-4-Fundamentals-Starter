package uitest.m4;

import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static helper.Pages.*;

public class ByIdClassTagTest {

    WebDriver driver;

    @Test
    public void byId() {
        driver = DriverFactory.newDriver();
        driver.get(HOME);

        driver.findElement(By.id("register")).click();


        driver.quit();
    }
    

}
