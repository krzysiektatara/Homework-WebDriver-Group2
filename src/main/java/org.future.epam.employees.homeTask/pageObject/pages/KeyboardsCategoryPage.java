package org.future.epam.employees.homeTask.pageObject.pages;

import org.future.epam.employees.homeTask.pageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KeyboardsCategoryPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), \"Razer Cynosa Chroma Gaming Keyboard: Individually Backlit RGB Keys\")]")
    private WebElement item;

    public KeyboardsCategoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public KeyboardItemPage chooseItem() {
        item.click();
        return new KeyboardItemPage(webDriver);
    }
}

