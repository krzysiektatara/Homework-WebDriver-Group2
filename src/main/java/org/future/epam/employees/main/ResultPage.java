package org.future.epam.employees.main;

import org.future.epam.employees.main.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage extends BasePage {
    protected ResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getSearchName(){
        return  webDriver.findElement(By.xpath("//span[@class=\"a-color-state a-text-bold\"]")).getText();
    }

    public String noResultAnnotation(){
        return  webDriver.findElement(By.xpath("//span[text() = \"No results for \"]")).getText();
    }

    public String searchEnteredProduct(String path){
        return webDriver.findElement(By.xpath(path)).getText();
    }

}
