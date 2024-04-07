package uitest.m4;

import helper.DemoHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

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
    }
}
