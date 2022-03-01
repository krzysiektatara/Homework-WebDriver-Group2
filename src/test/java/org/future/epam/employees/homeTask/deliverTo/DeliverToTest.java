package org.future.epam.employees.homeTask.deliverTo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DeliverToTest {
    @DataProvider(name = "postCodes")
    public Object[][] postCodes() {
        return new Object[][]{{"36104"}, {"99801"},
        };
    }

    @Test(dataProvider = "postCodes")
    public void postCodesTest(String postCode) {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        DeliverToPage deliverToPage = new DeliverToPage(driver).getPopUp().fillPostCode(postCode);
        Assert.assertEquals(postCode, deliverToPage.returnPostCode().getAttribute("innerHTML"));

    }

    @Test
    public void isPolandPresentTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        DeliverToPage deliverToPage = new DeliverToPage(driver).getPopUp().rollMenu();
        Assert.assertTrue(deliverToPage.getPoland().isDisplayed());
    }

    @Test
    public void countryInOrderTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        DeliverToPage deliverToPage = new DeliverToPage(driver).getPopUp().rollMenu();
        deliverToPage.getPoland().click();
        deliverToPage.getDoneButton().click();
        driver.navigate().refresh();
        deliverToPage.getHeadsetCategory().click();
        deliverToPage.getItem().click();
        Assert.assertTrue(deliverToPage.getShippingDescription().getText().contains("Poland"));





    }
}
