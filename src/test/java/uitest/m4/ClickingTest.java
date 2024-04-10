package uitest.m4;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

        Actions actions = new Actions(driver);
        // special actions like double click or right click are "hidden" in the Actions class
        actions.doubleClick(checkbox).perform();
        actions.contextClick(checkbox);

        checkbox.click();
        registerBtn.click();
        DemoHelper.pause();


        driver.quit();
    }
}
