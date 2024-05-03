package uitest.m4;

import helper.DemoHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helper.Pages.*;

public class WindowManagementDemo {

    @Test
    public void tabsAndWindowsDemo() {
        WebDriver driver = new ChromeDriver(); // window
        driver.get(HOME);

        String firstTab = driver.getWindowHandle();

        DemoHelper.pause();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(SAVINGS);
        Assert.assertEquals(driver.getWindowHandles().size(), 2);

        driver.switchTo().window(firstTab);
        DemoHelper.pause();
        driver.close();
        Assert.assertEquals(driver.getWindowHandles().size(), 1);

        driver.quit();
    }
}
