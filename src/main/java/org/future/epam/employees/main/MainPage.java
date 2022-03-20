package org.future.epam.employees.main;

import org.future.epam.employees.homeTask.pageObject.pages.KeyboardsCategoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(xpath = "//img [@alt=\"Keyboards\"]")
    private WebElement keyboardsCategory;

    public MainPage open() {
        webDriver.get("https://www.amazon.com/");
        return this;
    }

    public ResultPage sendRequest(String request) {
        searchField.clear();
        searchField.sendKeys(request);
        searchButton.click();
        return new ResultPage(webDriver);
    }

    public KeyboardsCategoryPage chooseKeyboardsCategory() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(keyboardsCategory));
        keyboardsCategory.click();
        return new KeyboardsCategoryPage(webDriver);
    }
}
