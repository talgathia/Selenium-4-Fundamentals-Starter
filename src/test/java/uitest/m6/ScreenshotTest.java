package uitest.m6;

import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static helper.Pages.*;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ScreenshotTest {

    @Test
    public void fullPageScreenshot() throws IOException {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        // in a temporary folder

        // if we want to put them in a different folder:
        Path destination = Paths.get("failure-screenshot.png");
        Files.move(screenshot.toPath(), destination, REPLACE_EXISTING);


        driver.quit();
    }


    @Test
    public void elementScreenshot() throws IOException {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        // to make a screenshot of a specific element:
        WebElement form = driver.findElement(By.tagName("form"));
        File screenshot = form.getScreenshotAs(OutputType.FILE);


        Path destination = Paths.get("failure-element.png");
        Files.move(screenshot.toPath(), destination, REPLACE_EXISTING);

        driver.quit();

    }
}
