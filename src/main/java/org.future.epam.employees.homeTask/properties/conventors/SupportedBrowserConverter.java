package org.future.epam.employees.homeTask.properties.conventors;

import org.future.epam.employees.homeTask.enumeration.SupportedBrowsers;

import static org.future.epam.employees.homeTask.enumeration.SupportedBrowsers.LOCAL_CHROME;
import static org.future.epam.employees.homeTask.enumeration.SupportedBrowsers.LOCAL_FIREFOX;

public class SupportedBrowserConverter {
    public static SupportedBrowsers valueOfWebBrowser(String webBrowserName) {
        return switch(webBrowserName) {
            case "local_chrome" -> LOCAL_CHROME;
            case "local_firefox" -> LOCAL_FIREFOX;
            default -> throw new IllegalArgumentException();
        };
    }
}