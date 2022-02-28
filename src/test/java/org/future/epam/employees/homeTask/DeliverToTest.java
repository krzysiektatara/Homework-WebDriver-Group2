package org.future.epam.employees.homeTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DeliverToTest {
@DataProvider(name = "postCodes")
public Object[][] postCodes(){
    return new Object[][]{ {"36104"},{"99801"},{"85001"},{"72201"},{"95814"},{"80202"},
};
}

    @Test(dataProvider = "postCodes")
    public void test(String postCode) {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        DeliverToPage deliverToPage = new DeliverToPage(driver).openPopUp().fillPostCode(postCode);

        Assert.assertTrue(deliverToPage.returnPostCode().getAttribute("innerHTML").equals(postCode));

    }
}
