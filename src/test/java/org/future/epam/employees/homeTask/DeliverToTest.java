package org.future.epam.employees.homeTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class DeliverToTest {
    public void test() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        DeliverToPage deliverToPage = new DeliverToPage(driver).openPopUp();
        Assert.assertTrue(driver.findElement(By.id("a-popover-header-1")).getSize() != null);
        DeliverToPage checkPostcode = deliverToPage.fillPostCode("85001");
        Assert.assertTrue(driver!=null);
    }
}
