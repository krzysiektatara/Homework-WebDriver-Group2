package org.future.epam.employees.homeTask.enumeration;

import org.future.epam.employees.homeTask.invoker.WebDriverInvoker;
import org.future.epam.employees.homeTask.invoker.implementation.LocalChromeInvoker;
import org.future.epam.employees.homeTask.invoker.implementation.LocalFirefoxInvoker;
import org.openqa.selenium.WebDriver;

public enum SupportedBrowsers {
    LOCAL_FIREFOX(new LocalFirefoxInvoker()),
    LOCAL_CHROME(new LocalChromeInvoker());

    private WebDriverInvoker webDriverInvoker;

    SupportedBrowsers(WebDriverInvoker webDriverInvoker) {
        this.webDriverInvoker = webDriverInvoker;
    }

    public WebDriver getWebDriver() {
        return webDriverInvoker.invokeWebDriver();
    }
}