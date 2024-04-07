package uitest.m4;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static helper.Pages.*;

public class NavigationTest {

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "\\src\\web\\";

    // System.getProperty("user.dir"): opens current project folder
    // \src\web\: goes deeper to the web folder with the html-files

    @Test
    public void basicNavigationTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(PREFIX + "index.html");

        DemoHelper.pause();
        driver.get(PREFIX + "savings.html");

        DemoHelper.pause();
        driver.navigate().back();

        DemoHelper.pause();
        driver.navigate().forward();

        driver.navigate().refresh();

        driver.quit();

        // difference between driver.quit() and driver.close():
        // driver.quit closes all tabs and windows
        // driver.close closes current tab only (if only one, closes window)
    }

    @Test
    public void basicNavigationTestRefactored() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);
        driver.get(SAVINGS);

        driver.quit();

    }
}
