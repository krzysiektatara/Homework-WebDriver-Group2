package com.epam.home_task.amazon.page_object.factory;

import com.epam.home_task.amazon.page_object.properties.convertors.SupportedBrowserConverter;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public WebDriver getWebDriver(){
        return SupportedBrowserConverter.valueOfWebBrowser("chrome").getWebDriver();
    }
}
