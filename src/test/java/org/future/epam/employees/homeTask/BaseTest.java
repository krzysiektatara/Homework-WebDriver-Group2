package org.future.epam.employees.homeTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
    protected final WebDriver webDriver = new ChromeDriver();

    protected void setUpDriver() {
        webDriver.manage().window().maximize();
    }

    protected void quit() {
        webDriver.quit();
    }
}
