package org.future.epam.employees.homeTask.pageObject.pages;

import org.future.epam.employees.homeTask.pageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ChairsCategoryPage extends BasePage {

    @FindBy(xpath = "//span[text()='OFM']")
    private WebElement brandName;

    @FindBy(xpath = "//span[contains(@class,'a-size-base-plus a-color-base')]")
    private List<WebElement> resultsTitles;

    @FindBy(id = "low-price")
    private WebElement minPriceField;

    @FindBy(id = "high-price")
    private WebElement maxPriceField;

    @FindBy(className = "a-button-input")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    private List<WebElement> resultsPricesDollars;

    @FindBy(xpath = "(//span[@class='a-price-fraction'])")
    private List<WebElement> resultsPricesCents;

    @FindBy(className = "a-dropdown-prompt")
    private WebElement sortOptionLabel;

    @FindBy(linkText = "Price: Low to High")
    private WebElement sortByPriceLowToHighOption;

    @FindBy(xpath = "//img[@data-image-index='1']")
    private WebElement firstElementImage;

    public ChairsCategoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void chooseBrandRespawn() {
        brandName.click();
    }

    public List<WebElement> getResultsTitles() {
        return resultsTitles;
    }

    public List<Double> getResultPrices() {
        List<Double> resultPricesDouble = new ArrayList<>();
        for (int i = 0; i < resultsPricesDollars.size(); i++) {
            if (!resultsPricesDollars.get(i).getText().isEmpty()) {
                resultPricesDouble.add(Double.parseDouble(resultsPricesDollars.get(i).getText()) +
                        ((Double.parseDouble(resultsPricesCents.get(i).getText())) / 100)
                );
            }
        }
        return resultPricesDouble;
    }

    public void fillPriceRange(String minPrice, String maxPrice) {
        minPriceField.sendKeys(minPrice);
        maxPriceField.sendKeys(maxPrice);
        searchButton.click();
    }

    public void chooseSortingTypeLowToHigh() {
        sortOptionLabel.click();
        sortByPriceLowToHighOption.click();
        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(firstElementImage));
    }
}

