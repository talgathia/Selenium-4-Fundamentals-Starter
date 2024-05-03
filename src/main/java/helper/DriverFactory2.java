package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverFactory2 {

    // in Java, a class called factory is responsible for creating and returning objects


    public static WebDriver newDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // gives 5 seconds to find element before throwing an exception
        return driver;
    }
}
