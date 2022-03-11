package org.future.epam.employees.homeTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class BaseTest {
    protected final WebDriver webDriver = new ChromeDriver();

    protected void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\GIT\\Homework-WebDriver-Group2\\src\\test\\java\\resources\\chromedriver.exe");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
    }

    protected void quit() {
        webDriver.quit();
    }
}
