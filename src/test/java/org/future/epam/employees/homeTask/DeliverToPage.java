package org.future.epam.employees.homeTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DeliverToPage {
    private WebDriver driver;
    private  WebDriverWait wait;

    @FindBy(id ="nav-global-location-popover-link")
    private  WebElement deliverTo;


    @FindBy(id = "GLUXZipUpdateInput")
    private WebElement searchPostCode;

    @FindBy (how = How.XPATH, using ="//*[@aria-labelledby ='GLUXZipUpdate-announce']")
    private WebElement applyButton;

    public DeliverToPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
        wait = new WebDriverWait(driver,10);
    }



    public DeliverToPage openPopUp(){
        deliverTo.click();
    return new DeliverToPage(driver);
    }

    public DeliverToPage fillPostCode(String postCode){
        wait.until(ExpectedConditions.presenceOfElementLocated((By.id("GLUXZipUpdateInput"))));
        searchPostCode.sendKeys(postCode);
        applyButton.click();
        return new DeliverToPage(driver);
    }

}





