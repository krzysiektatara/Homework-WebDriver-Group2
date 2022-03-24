package com.epam.home_task.amazon.page_object.pageObject.pages.deliver_to;

import com.epam.home_task.amazon.page_object.pageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LocationWindow extends BasePage {

    private WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));

    @FindBy(id = "GLUXZipUpdateInput")
    private WebElement providePostCodeField;

    @FindBy(how = How.XPATH, using = "//*[@aria-labelledby ='GLUXZipUpdate-announce']")
    private WebElement applyButton;

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'GLUXHiddenSuccessSelectedAddressPlaceholder')]")
    private static WebElement popUpToVerifyPostCode;

    @FindBy(id = "GLUXCountryListDropdown")
    private WebElement shipToCountryDropDown;

    @FindBy(how = How.XPATH, using = "//a[text()='Poland']")
    private WebElement poland;

    @FindBy(xpath = "//*[@class='a-button a-button-primary']")
    private WebElement doneButton;


    public LocationWindow(WebDriver webDriver) {
        super(webDriver);
    }

    ///postcode Test

    public LocationWindow fillPostCode(String postCode) {
        wait.until(ExpectedConditions.presenceOfElementLocated((By.id("GLUXZipUpdateInput"))));
        providePostCodeField.sendKeys(postCode);
        applyButton.click();
        return this;
    }

    public String returnPostCode() {
        return popUpToVerifyPostCode.getAttribute("innerHTML");
    }

    /// isPolandPresent

    public LocationWindow rollMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(shipToCountryDropDown));
        shipToCountryDropDown.click();
        return this;
    }

    public boolean isPolandPresent() {
        wait.until(ExpectedConditions.elementToBeClickable(poland));
        return poland.isDisplayed();
    }

    /// countryInOrderTest

    public LocationWindow choosePoland() {
        wait.until(ExpectedConditions.elementToBeClickable(poland)).click();
        return this;
    }

    public MainPage clickDoneButton(){
        wait.until(ExpectedConditions.elementToBeClickable(doneButton));
        doneButton.click();
        webDriver.navigate().refresh();
        return new MainPage(webDriver);
    }


}
