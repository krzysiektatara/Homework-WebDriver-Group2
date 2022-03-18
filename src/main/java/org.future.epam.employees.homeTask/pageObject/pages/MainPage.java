package org.future.epam.employees.homeTask.pageObject.pages;

import org.future.epam.employees.homeTask.pageObject.BasePage;
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

    @FindBy(xpath = "//span[text()='Chairs']")
    private WebElement chairsCategory;

    public MainPage open(){
        webDriver.get("https://www.amazon.com/");
        return this;
    }

    public ResultPage sendRequest(String request)
    {
        searchField.clear();
        searchField.sendKeys(request);
        searchButton.click();
        return new ResultPage(webDriver);
    }

    public ChairsCategoryPage chooseChairsCategory() {
        new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(chairsCategory));
        chairsCategory.click();
        return new ChairsCategoryPage(webDriver);
    }
}
