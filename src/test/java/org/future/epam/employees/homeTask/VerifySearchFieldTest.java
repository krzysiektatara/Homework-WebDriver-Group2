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
import java.util.concurrent.TimeUnit;

public class VerifySearchFieldTest {

    @DataProvider(name = "IncorrectRequests")
    public Object[][] incorrectRequests() {
        return new Object[][]
                {
                        {"lkjlkjsnlgksd'dfkg;klnl34058734-591=49v8-0 7"},
                        {"><><>"}
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
                        {"Keyboard","//span[text()[contains(.,\"Keyboard\")]]"},
                        {"Hello Kitty", "//span[text()[contains(.,\"Hello Kitty\")]]"}
                };
    }

    WebDriver driver = setUp();

    @BeforeTest
    public WebDriver setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\GIT\\Homework-WebDriver-Group2\\src\\test\\java\\resources\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
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
        public void incorrectRequestTest(String incorrectR){
            sendRequest(incorrectR);
            WebElement searchResult = searchForResult("//span[text() = \"No results for \"]");
            Assert.assertTrue(searchResult.getText().contains("No results for"),
                    "The expected message did not appear");
        }


        @Test(dataProvider = "CorrectRequests")
        public void correctRequestTest(String request){
            sendRequest(request);
            WebElement searchResult = searchForResult("//span[@class=\"a-color-state a-text-bold\"]");
            Assert.assertTrue(searchResult.getText().contains(request),
                    "The current link is not as expected");
        }

        @Test(dataProvider = "ContainWords")
        public void containsWordTest(String request, String path)
        {
            sendRequest(request);
            WebElement searchResult = searchForResult(path);
            Assert.assertTrue(searchResult.getText().contains(request),
                    "The current page does not contain expected result");
        }

        @AfterTest
    public void Close()
        {
            driver.close();
            driver.quit();
        }
    }

