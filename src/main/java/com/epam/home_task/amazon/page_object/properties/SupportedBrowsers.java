package com.epam.home_task.amazon.page_object.properties;

import com.epam.home_task.amazon.page_object.invoker.WebDriverInvoker;
import com.epam.home_task.amazon.page_object.invoker.implementation.LocalChromeInvoker;
import com.epam.home_task.amazon.page_object.invoker.implementation.LocaleFirefoxInvoker;
import org.openqa.selenium.WebDriver;

public enum SupportedBrowsers {
    LOCALE_CHROME(new LocalChromeInvoker()),
    LOCALE_FIREFOX(new LocaleFirefoxInvoker());

    private WebDriverInvoker webDriverInvoker;


    SupportedBrowsers(WebDriverInvoker webDriverInvoker) {
        this.webDriverInvoker = webDriverInvoker;
    }

    public WebDriver getWebDriver() {
        return webDriverInvoker.invokeWebDriver();
    }
}
