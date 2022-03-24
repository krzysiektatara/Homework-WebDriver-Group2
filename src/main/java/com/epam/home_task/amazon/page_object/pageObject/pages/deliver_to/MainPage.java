package com.epam.home_task.amazon.page_object.pageObject.pages.deliver_to;

import com.epam.home_task.amazon.page_object.pageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends BasePage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "nav-global-location-popover-link")
    private WebElement location;

    @FindBy(how = How.XPATH, using = "(//*[@class='a-section a-spacing-none quadrant-container quadrant-container-0'])[1]")
    private WebElement headsetCategory;

    public MainPage open() {
        webDriver.get("https://www.amazon.com/");
        return this;
    }

    public LocationWindow openLocation() {
        location.click();
        return new LocationWindow(webDriver);
    }

    public GamingHeadsetsList getHeadsetCategory() {
        headsetCategory.click();
        return new GamingHeadsetsList(webDriver);
    }

}
