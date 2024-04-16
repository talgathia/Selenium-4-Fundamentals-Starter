package uitest.m4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static helper.Pages.*;

public class WindowManagementDemo {

    @Test
    public void tabsAndWindowsDemo() {
        WebDriver driver = new ChromeDriver();
        driver.get(HOME);

        driver.quit();
    }
}
