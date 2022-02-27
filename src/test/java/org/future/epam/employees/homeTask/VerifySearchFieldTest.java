package org.future.epam.employees.homeTask;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;


public class VerifySearchFieldTest {
    WebDriver driver = setUp();

    @DataProvider(name = "requests")
    public Object[][] requests() {
        return new Object[][]
                {
                        {"toy"},
                        {"phone"},
                        {"laptop"},
                        {"xbxb"},
                        {"!!!"}
                };
    }

    @BeforeTest
    public WebDriver setUp()
    {
        WebDriverManager.chromedriver().browserVersion("97").setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

        @Test(dataProvider = "requests")
        public void SearchFieldTest(String request){
            driver.get("https://www.amazon.com/");

            WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
            searchField.sendKeys(request);

            WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
            searchButton.click();

            WebElement searchResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]")));

            Assert.assertTrue(searchResult.getText().contains(request),"The current link is not as expected");

        }
        @AfterTest
    public void Close()
        {
            driver.close();
            driver.quit();
        }
    }

