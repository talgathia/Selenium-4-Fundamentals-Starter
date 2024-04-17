package uitest.m7;

import helper.DemoHelper;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.Map;

import static helper.Pages.*;

public class DeviceEmulationDemo {

    @Test
    public void deviceEmulation() {

        Map<String, String> mobileEmulation = Map.of("deviceName", "Nexus 5");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);


        WebDriver driver = new ChromeDriver(options);
        driver.get(HOME);

        DemoHelper.pause();
        driver.quit();
    }
}
