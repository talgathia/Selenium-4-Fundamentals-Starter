package uitest.m9;

import factory.DriverFactory;
import helper.DriverFactory2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicRefactoringDemo {

    @Test
    public void beforeRefactoring() {
        // setup

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless=true");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();

        // do things
    }


    @Test
    public void newDriverAndToolsDemo() {
        WebDriver chromeDriver = DriverFactory.newChromeDriver();
        WebDriver edgeDriver = DriverFactory.newEdgeDriver();
        WebDriver firefoxDriver = DriverFactory.newFirefoxDriver();

    }

}
