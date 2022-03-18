package org.future.epam.employees.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

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

}
