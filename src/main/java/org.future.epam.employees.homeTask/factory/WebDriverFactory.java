package org.future.epam.employees.homeTask.factory;

import org.future.epam.employees.homeTask.properties.conventors.SupportedBrowserConverter;
import org.future.epam.employees.homeTask.properties.holder.PropertyHolder;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public WebDriver getWebDriver() {
        return SupportedBrowserConverter.valueOfWebBrowser(
                new PropertyHolder().readProperty("browser")).getWebDriver();
    }
}
