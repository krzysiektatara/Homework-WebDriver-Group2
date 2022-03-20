package org.future.epam.employees.homeTask;

import org.future.epam.employees.homeTask.pageObject.pages.CartPage;
import org.future.epam.employees.homeTask.pageObject.pages.KeyboardItemPage;
import org.future.epam.employees.main.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveItemPOTests extends BaseTest {

    @Test
    public void addItem() {
        MainPage mainPage = new MainPage(webDriver);
        KeyboardItemPage itemPage = new KeyboardItemPage(webDriver);
        mainPage.chooseKeyboardsCategory().chooseItem().addToCart();
        Assert.assertEquals(itemPage.addedItemCheck(), "Added to Cart");
        Assert.assertEquals(itemPage.cartCountCheck(), "1");
        webDriver.close();
    }

    @Test
    public void removeItem() {
        setUpDriver();
        MainPage mainPage = new MainPage(webDriver);
        KeyboardItemPage itemPage = new KeyboardItemPage(webDriver);
        CartPage cartPage = new CartPage(webDriver);
        mainPage.chooseKeyboardsCategory().chooseItem().addToCart();
        itemPage.popUpClose();
        itemPage.chooseCart().deleteItem();
        Assert.assertEquals(cartPage.emptyCartCheck(), "Your Amazon Cart is empty.");
        Assert.assertEquals(cartPage.subtotalZeroCheck(), "$0.00");
    }
}

