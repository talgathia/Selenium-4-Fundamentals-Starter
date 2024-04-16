package uitest.m4;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static helper.Pages.*;

public class StorageAndCookiesTest {

    @Test
    public void storageTest() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement saveBtn = driver.findElement(By.id("save"));

        firstName.sendKeys("Maria");
        lastName.sendKeys("Diaz");
        saveBtn.click();


        WebStorage webStorage = (WebStorage) driver; // to get the content of the storage, we need to cast the driver object to WebStorage
        SessionStorage storage = webStorage.getSessionStorage();
        storage.keySet().forEach(key -> System.out.println(key + "=" + storage.getItem(key)));

        DemoHelper.pause();
        driver.get(SAVINGS);
        driver.navigate().back();


        DemoHelper.pause();


        WebElement firstName_1 = driver.findElement(By.id("firstName"));
        WebElement lastName_1 = driver.findElement(By.id("lastName"));
        Assert.assertEquals(firstName_1.getAttribute("value"), "Maria");
        Assert.assertEquals(lastName_1.getAttribute("value"), "Diaz");


        storage.clear();
        driver.navigate().refresh();


        WebElement firstName_2 = driver.findElement(By.id("firstName"));
        WebElement lastName_2 = driver.findElement(By.id("lastName"));
        Assert.assertEquals(firstName_2.getAttribute("value"), "");
        Assert.assertEquals(lastName_2.getAttribute("value"), "");

        driver.quit();
    }
}