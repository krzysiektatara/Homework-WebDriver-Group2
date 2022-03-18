package com.epam.home_task.amazon.test.test;

import com.epam.home_task.amazon.page_object.pageObject.pages.MainPage;
import com.epam.home_task.amazon.page_object.pageObject.pages.deliver_to.LocationWindow;
import com.epam.home_task.amazon.test.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeliverToTest extends BaseTest{
    MainPage mainPage = new MainPage(webDriver);



    @DataProvider(name = "postCodes")
    public Object[][] postCodes() {
        return new Object[][]{{"36104"}, {"99801"},
        };
    }

    @Test(dataProvider = "postCodes")
    public void postCodesTest(String postCode) {
        final String postCodeToVerify = mainPage.open().openLocation().fillPostCode(postCode).returnPostCode();
        Assert.assertEquals(postCode, postCodeToVerify);
    }
//    @Test
//    public void isPolandPresentTest() {
//        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.amazon.com/");
//        driver.manage().window().maximize();
//        DeliverToPage deliverToPage = new DeliverToPage(driver).getPopUp().rollMenu();
//        Assert.assertTrue(deliverToPage.getPoland().isDisplayed());
//    }
}
