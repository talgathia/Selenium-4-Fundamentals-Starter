package uitest.m4;

import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static helper.Pages.*;

public class UnderstandingWebElement {

    @Test
    public void webElementTest() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        WebElement input = driver.findElement(By.id("firstName"));
        System.out.println(input.isDisplayed());

        WebElement button = driver.findElement(By.id("register"));
        System.out.println(button.getText());

        button.click();
        // button.sendKeys("some input"); -> possible but doesn't make sense

        driver.quit();
    }
}
