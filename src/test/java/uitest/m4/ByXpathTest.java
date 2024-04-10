package uitest.m4;

import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static helper.Pages.*;

public class ByXpathTest {

    WebDriver driver;
    @Test
    public void byXpath() {

        driver = DriverFactory.newDriver();
        driver.get(SAVINGS);

        WebElement cell = driver.findElement(By.xpath("//*[@id=\"rates\"]/tbody/tr[1]/td[4]"));
        System.out.println("Chrome xpath: " + cell.getText());

    }

    @Test
    public void byXpath_2() {
        driver = DriverFactory.newDriver();
        driver.get(HOME);
        WebElement button = driver.findElement(By.xpath("//form/button[contains(text(), 'Register')]"));
        System.out.println(button.getText());
    }

    @AfterMethod
    void cleanup() {
        driver.quit();
    }

}
