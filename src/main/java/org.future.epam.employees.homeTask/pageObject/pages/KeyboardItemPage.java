package org.future.epam.employees.homeTask.pageObject.pages;

import org.future.epam.employees.homeTask.pageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KeyboardItemPage extends BasePage {
    @FindBy(id = "add-to-cart-button")
    private WebElement addToCart;

    @FindBy(id = "attachDisplayAddBaseAlert")
    private WebElement added;

    @FindBy(id = "nav-cart-count")
    private WebElement cartCount;

    @FindBy(id = "nav-cart")
    private WebElement cart;

    @FindBy(id = "attach-close_sideSheet-link")
    private WebElement exit;

    public KeyboardItemPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void addToCart() {
        addToCart.click();
    }

    public String addedItemCheck() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(added));
        return added.getText();
    }

    public String cartCountCheck() {
        return cartCount.getText();
    }

    public void popUpClose() {
        exit.click();
    }

    public CartPage chooseCart() {
        cart.click();
        return new CartPage(webDriver);

    }
}
