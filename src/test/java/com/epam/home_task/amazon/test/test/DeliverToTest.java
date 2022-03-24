package com.epam.home_task.amazon.test.test;

import com.epam.home_task.amazon.test.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeliverToTest extends BaseTest {

    @DataProvider(name = "postCodes")
    public Object[][] postCodes() {
        return new Object[][]{{"36104"}, {"99801"},
        };
    }

    @Test(dataProvider = "postCodes")
    public void postCodesTest(String postCode) {
        final String postCodeToVerify = mainPage.open().openLocation()
                .fillPostCode(postCode).returnPostCode();
        Assert.assertEquals(postCode, postCodeToVerify);
        webDriver.manage().deleteAllCookies();
    }

    @Test
    public void isPolandPresentTest() {
        boolean presenceOfPoland = mainPage.open()
                .openLocation().rollMenu().isPolandPresent();
        Assert.assertTrue(presenceOfPoland);
    }

    @Test
    public void countryInOrderTest() {
        WebElement shippingDescription = mainPage.open().openLocation().rollMenu()
                .choosePoland().clickDoneButton()
                .getHeadsetCategory().getItem()
                .getShippingDescription();
        Assert.assertTrue(shippingDescription.getText().contains("Poland"));
    }
}
