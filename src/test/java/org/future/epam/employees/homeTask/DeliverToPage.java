package org.future.epam.employees.homeTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class DeliverToPage {
    private WebDriver driver;

    @FindBy(id ="nav-global-location-popover-link")
    private  WebElement findBy;

    public DeliverToPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public DeliverToPage openPopUp(){
        findBy.click();
    return new DeliverToPage(driver);
    }

}





