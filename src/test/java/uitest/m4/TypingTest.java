package uitest.m4;

import helper.DemoHelper;
import helper.DriverFactory2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static helper.Pages.*;

public class TypingTest {

    @Test
    public void typingTest() {
        WebDriver driver = DriverFactory2.newDriver();
        driver.get(HOME);

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement birthday = driver.findElement(By.id("dob"));

        firstName.sendKeys("Amanda");
        lastName.sendKeys("Walker");
        email.sendKeys("am.walker@email.com");
        DemoHelper.pause();
        email.clear();
        email.sendKeys("am.walker@email.com");
        birthday.sendKeys("27/03/2022");

        DemoHelper.pause();
        driver.quit();
    }
}
