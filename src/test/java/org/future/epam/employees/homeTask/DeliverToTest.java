package org.future.epam.employees.homeTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class DeliverToTest {
    public void test() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        DeliverToPage deliverToPage = new DeliverToPage(driver).openPopUp();

    }
}
