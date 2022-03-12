package com.epam.home_task.amazon.page_object.properties.convertors;

import com.epam.home_task.amazon.page_object.properties.SupportedBrowsers;

public class SupportedBrowserConverter {
    public static SupportedBrowsers valueOfWebBrowser(String webBrowserName){
        return switch (webBrowserName) {
            case "firefox" -> SupportedBrowsers.LOCALE_FIREFOX;
            default -> SupportedBrowsers.LOCALE_CHROME;
        };
    }
}
