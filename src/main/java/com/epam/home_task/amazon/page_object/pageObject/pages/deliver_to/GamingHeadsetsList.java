package com.epam.home_task.amazon.page_object.pageObject.pages.deliver_to;

import com.epam.home_task.amazon.page_object.pageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GamingHeadsetsList extends BasePage {

    public GamingHeadsetsList(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how = How.XPATH, using = "(//*[@class='a-size-medium a-color-base a-text-normal'])[2]")
    private WebElement item;

    public ItemClass getItem() {
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(item)).click();
        return new ItemClass(webDriver);
    }
}
