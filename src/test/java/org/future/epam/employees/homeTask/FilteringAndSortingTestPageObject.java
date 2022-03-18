package org.future.epam.employees.homeTask;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.future.epam.employees.homeTask.pageObject.pages.MainPage;
import org.future.epam.employees.homeTask.pageObject.pages.ChairsCategoryPage;

public class FilteringAndSortingTestPageObject extends BaseTest {

    MainPage mainPage = new MainPage(webDriver);
    ChairsCategoryPage chairsCategoryPage = new ChairsCategoryPage(webDriver);

    @Test
    public void filteringByCategoryAndBrandTest() {

        mainPage.chooseChairsCategory();
        chairsCategoryPage.chooseBrandRespawn();

        for (WebElement title : chairsCategoryPage.getResultsTitles()) {
            Assert.assertTrue(title.getText().contains("OFM"));
        }
    }

    @DataProvider(name = "priceRange")
    public Object[][] priceRange() {
        return new Object[][]{
                {"", "100"},
                {"125", "180"},
                {"140", ""},
                {"", ""}
        };
    }

    @Test(dataProvider = "priceRange")
    public void filteringByPrice(String minPrice, String maxPrice) {

        mainPage.chooseChairsCategory();

        chairsCategoryPage.fillPriceRange(minPrice,maxPrice);

        double minFieldValue = 0.00;
        double maxFieldValue = 9999999.99;

        if (!minPrice.isEmpty()) {
            minFieldValue = Double.parseDouble(minPrice);
        }
        if (!maxPrice.isEmpty()) {
            maxFieldValue = Double.parseDouble(maxPrice);
        }

        for (Double price : chairsCategoryPage.getResultPrices()) {
            Assert.assertTrue(price >= minFieldValue && price <= maxFieldValue);
        }
    }

    @Test
    public void sortingByPrice() {

        mainPage.chooseChairsCategory();
        chairsCategoryPage.chooseSortingTypeLowToHigh();

        for (int i = 0; i < chairsCategoryPage.getResultPrices().size(); i++) {
            Assert.assertTrue(chairsCategoryPage.getResultPrices().get(i) <= chairsCategoryPage.getResultPrices().get(i + 1));
            System.out.println(1);
        }

    }
}
