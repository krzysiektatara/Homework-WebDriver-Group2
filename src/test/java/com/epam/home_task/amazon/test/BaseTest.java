package com.epam.home_task.amazon.test;

import com.epam.home_task.amazon.page_object.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public abstract class BaseTest {
    protected final WebDriver webDriver = new WebDriverFactory().getWebDriver();

    @BeforeTest
    public void setUpDriver() {
        webDriver.manage().window().maximize();
    }


//    @AfterTest
//    public void tearDown() {
//        webDriver.quit();
//    }
}

