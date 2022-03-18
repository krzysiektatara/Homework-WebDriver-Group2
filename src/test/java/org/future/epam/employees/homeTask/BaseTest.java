package org.future.epam.employees.homeTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import java.time.Duration;



public class BaseTest {

    WebDriver webDriver = setUpDriver();


        System.setProperty("webdriver.chrome.driver", "C:\\GIT\\Homework-WebDriver-Group2\\src\\test\\java\\resources\\chromedriver.exe");
        this.webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        webDriver.get("https://www.amazon.com/");
        return webDriver;
    }

    protected void quit() {
        webDriver.close();
        webDriver.quit();
    }
}
