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

    @DataProvider(name = "IncorrectRequests")
    public Object[][] incorrectRequests() {
        return new Object[][]
                {
                        {"lkjlkjsnlgksd'dfkg;klnl34058734-591=49v8-0 7", "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[1]/div/div/div/span[1]"},
                        {"><><>","//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[1]/div/div/div/div[1]/span[1]"}
                };
    }

    @DataProvider(name = "CorrectRequests")
    public Object[][] requests() {
        return new Object[][]
                {
                        {"toy"},
                        {"phone"},
                        {"laptop"},
                };
    }

    @DataProvider(name = "ContainWords")
    public Object[][] words() {
        return new Object[][]
                {
                        {"Keyboard","//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"},
                        {"Hello Kitty", "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/div/div/div/div/div/div[2]/div[2]/h2/a/span"},
                };
    }

    WebDriver driver = setUp();

    @BeforeTest
    public WebDriver setUp()
    {
        WebDriverManager.chromedriver().browserVersion("97").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        return driver;
    }

    public void sendRequest(String request)
    {
        WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
        searchField.clear();
        searchField.sendKeys(request);

        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
    }

    public WebElement searchForResult(String path)
    {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
    }


        @Test(dataProvider = "IncorrectRequests")
        public void incorrectRequestTest(String incorrectR, String path){
            sendRequest(incorrectR);
            WebElement searchResult = searchForResult(path);
            Assert.assertTrue(searchResult.getText().contains("No results for"),"The expected message did not appear");
        }


        @Test(dataProvider = "CorrectRequests")
        public void correctRequestTest(String request){
            sendRequest(request);
            WebElement searchResult = searchForResult("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]");
            Assert.assertTrue(searchResult.getText().contains(request),"The current link is not as expected");
        }


        @Test(dataProvider = "ContainWords")
        public void containsWordTest(String request, String path)
        {
            sendRequest(request);
            WebElement searchResult = searchForResult(path);
            Assert.assertTrue(searchResult.getText().contains(request),"The current page does not contain expected result");
        }

        @AfterTest
    public void Close()
        {
            driver.close();
            driver.quit();
        }
    }

