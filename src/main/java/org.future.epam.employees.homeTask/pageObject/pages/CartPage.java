package org.future.epam.employees.homeTask.pageObject.pages;

import org.future.epam.employees.homeTask.pageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@data-action=\"delete\"]")
    private WebElement deleteButton;

    @FindBy(xpath = "//h1 [contains (text(), 'Your Amazon Cart is empty.')]")
    private WebElement emptyCart;

    @FindBy(xpath = "//span [contains (text(), '$0.00')]")
    private WebElement subtotalZero;

    public void deleteItem() {
        deleteButton.click();
    }

    public String emptyCartCheck() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(emptyCart));
        return emptyCart.getText();
    }

    public String subtotalZeroCheck() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(subtotalZero));
        return subtotalZero.getText();
    }

}
