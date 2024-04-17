package uitest.m7;

import helper.DemoHelper;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static helper.Pages.*;

public class WindowSizeDemo {

    @Test
    public void windowSizeDemo() {
        WebDriver driver = new ChromeDriver();

        // to change the size of the window we need the window object:
        WebDriver.Window window = driver.manage().window();

        window.maximize();
        window.minimize();
        window.setSize(new Dimension(1200, 800));

        driver.get(HOME);

        DemoHelper.pause();



        driver.quit();
    }
}
