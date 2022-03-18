package org.future.epam.employees.homeTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;


public class BaseTest {

    WebDriver webDriver = setUpDriver();

    @BeforeTest
    public WebDriver setUpDriver() {
        WebDriverManager.chromedriver().browserVersion("99").setup();
        this.webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        webDriver.get("https://www.amazon.com/");
        return webDriver;
    }

    @AfterTest
    protected void quit() {
        webDriver.close();
        webDriver.quit();
    }
}
