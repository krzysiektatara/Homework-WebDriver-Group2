package com.epam.home_task.amazon.page_object.pageObject.pages;

import com.epam.home_task.amazon.page_object.pageObject.BasePage;
import com.epam.home_task.amazon.page_object.pageObject.pages.deliver_to.LocationWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "nav-global-location-popover-link")
    private WebElement location;

    public MainPage open() {
        webDriver.get("https://www.amazon.com/");
        return this;
    }

    public LocationWindow openLocation() {
        location.click();
        return new LocationWindow(webDriver);
    }

}
