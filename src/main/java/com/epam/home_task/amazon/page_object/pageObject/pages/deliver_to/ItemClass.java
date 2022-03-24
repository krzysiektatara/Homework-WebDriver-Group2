package com.epam.home_task.amazon.page_object.pageObject.pages.deliver_to;

import com.epam.home_task.amazon.page_object.pageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ItemClass extends BasePage {
    protected ItemClass(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how = How.XPATH, using = "//div[@id='exports_desktop_qualifiedBuybox_tlc_feature_div']/span[@class='a-size-base a-color-secondary']")
    private WebElement shippingDescription;

    public WebElement getShippingDescription(){
        return shippingDescription;
    }
}
