package org.future.epam.employees.homeTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;


public class DeliverToPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public DeliverToPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    ///// postCodeTest

    @FindBy(id = "nav-global-location-popover-link")
    private WebElement popUp;

    public DeliverToPage getPopUp() {
        popUp.click();
        return new DeliverToPage(driver);
    }

    @FindBy(id = "GLUXZipUpdateInput")
    private WebElement searchPostCode;


    public DeliverToPage fillPostCode(String postCode) {
        wait.until(ExpectedConditions.presenceOfElementLocated((By.id("GLUXZipUpdateInput"))));
        searchPostCode.sendKeys(postCode);
        applyButton.click();
        return new DeliverToPage(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@aria-labelledby ='GLUXZipUpdate-announce']")
    private WebElement applyButton;


    @FindBy(how = How.XPATH, using = "//div[contains(@id,'GLUXHiddenSuccessSelectedAddressPlaceholder')]")
    private static WebElement popUpToVerifyPostCode;







    public WebElement returnPostCode() {
        return popUpToVerifyPostCode;
    }


    //////// isPolandPresentTest


    @FindBy(id = "GLUXCountryListDropdown")
    private WebElement shipToCountryDropDown;

    public DeliverToPage rollMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(shipToCountryDropDown));
        shipToCountryDropDown.click();
        return new DeliverToPage(driver);
    }

    @FindBy(how = How.XPATH, using = "//a[text()='Poland']")
    private WebElement poland;

    public WebElement getPoland(){
        return poland;
    }





//////////////////// countryInOrderTest

    @FindBy(id = "a-autoid-3")
    private WebElement doneButton;

    public WebElement getDoneButton(){
        wait.until(ExpectedConditions.elementToBeClickable(doneButton));
        return doneButton;
    }

    @FindBy(how = How.XPATH, using = "(//*[@class='a-section a-spacing-none quadrant-container quadrant-container-0'])[1]")
    private WebElement headsetCategory;
//
    public WebElement getHeadsetCategory(){
        wait.until(ExpectedConditions.elementToBeClickable(headsetCategory));
        return headsetCategory;
    }

    @FindBy(how = How.XPATH, using = "(//*[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[2]")
    private WebElement item;

    public WebElement getItem(){
        wait.until(ExpectedConditions.elementToBeClickable(item));
        return item;
    }

    @FindBy(how = How.XPATH, using = "//div[@id='exports_desktop_qualifiedBuybox_tlc_feature_div']/span[@class='a-size-base a-color-secondary']")
    private WebElement shippingDescription;

    public WebElement getShippingDescription(){
        return shippingDescription;
    }







}





