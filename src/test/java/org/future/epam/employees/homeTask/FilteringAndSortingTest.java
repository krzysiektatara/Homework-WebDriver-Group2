package org.future.epam.employees.homeTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class FilteringAndSortingTest {

    private static void centsAndDollarsConsolidation(List<WebElement> dollarsValue, List<WebElement> centsValue, List<Double> itemsPrices) {
        for (int i = 0; i < dollarsValue.size(); i++) {
            if (!dollarsValue.get(i).getText().isEmpty()) {
                itemsPrices.add(Double.parseDouble(dollarsValue.get(i).getText()) +
                        ((Double.parseDouble(centsValue.get(i).getText())) / 100)
                );
            }
        }
    }

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().browserVersion("97").setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");

        WebElement chairsCategory = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Chairs']")));

        chairsCategory.click();
    }

    @AfterMethod
    public void tearDown() {

        driver.close();
        driver.quit();
    }

    @Test
    public void filteringByCategoryAndBrandTest() {

        WebElement brandName = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='RESPAWN']")));

        brandName.click();

        List<WebElement> resultsTitles =
                driver.findElements(By.xpath("//span[contains(@class,'a-size-base-plus a-color-base')]"));

        for (WebElement title : resultsTitles) {
            Assert.assertTrue(title.getText().contains("RESPAWN"));
        }
    }

    @DataProvider(name = "priceRange")
    public Object[][] priceRange() {
        return new Object[][]{
                {"", "100"},
                {"125", "180"},
                {"140", ""},
                {"", ""}
        };
    }

    @Test(dataProvider = "priceRange")
    public void filteringByPrice(String minPrice, String maxPrice) {

        WebElement minPriceField = driver.findElement(By.id("low-price"));
        WebElement maxPriceField = driver.findElement(By.id("high-price"));
        WebElement searchButton = driver.findElement(By.className("a-button-input"));

        minPriceField.sendKeys(minPrice);
        maxPriceField.sendKeys(maxPrice);
        searchButton.click();

        List<WebElement> resultsPricesDollars =
                driver.findElements(By.xpath("//span[@class='a-price-whole']"));

        List<WebElement> resultsPricesCents =
                driver.findElements(By.xpath("(//span[@class='a-price-fraction'])"));

        List<Double> resultPricesDouble = new ArrayList<>();

        centsAndDollarsConsolidation(resultsPricesDollars, resultsPricesCents, resultPricesDouble);

        double minFieldValue = 0.00;
        double maxFieldValue = 9999999.99;

        if (!minPrice.isEmpty()) {
            minFieldValue = Double.parseDouble(minPrice);
        }
        if (!maxPrice.isEmpty()) {
            maxFieldValue = Double.parseDouble(maxPrice);
        }

        for (Double price : resultPricesDouble) {
            Assert.assertTrue(price >= minFieldValue && price <= maxFieldValue);
        }
    }

    @Test
    public void sortingByPrice() {

        WebElement sortOptionLabel = driver.findElement(By.className("a-dropdown-prompt"));

        sortOptionLabel.click();

        WebElement sortByPriceLowToHighOption = driver.findElement(By.linkText("Price: Low to High"));

        sortByPriceLowToHighOption.click();

        WebElement firstElementImage = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@data-image-index='1']")));

        List<WebElement> resultsPricesDollars =
                driver.findElements(By.xpath("//span[@class='a-price-whole']"));

        List<WebElement> resultsPricesCents =
                driver.findElements(By.xpath("(//span[@class='a-price-fraction'])"));

        List<Double> resultPricesDouble = new ArrayList<>();

        centsAndDollarsConsolidation(resultsPricesDollars, resultsPricesCents, resultPricesDouble);

        for (int i = 0; i < resultPricesDouble.size(); i++) {
            Assert.assertTrue(resultPricesDouble.get(i) <= resultPricesDouble.get(i + 1));
        }
    }
}
