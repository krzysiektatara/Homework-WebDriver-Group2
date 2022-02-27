package org.future.epam.employees.homeTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerifySearchFieldTest {
        @Test
        public void SearchFieldTest(){

            WebDriverManager.chromedriver().browserVersion("97").setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.amazon.com/");

            Assert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.com/",
                    "The current link is not as expected");

            WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
            searchField.sendKeys("books");

            WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
            searchButton.click();

            Assert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.com/b?node=283155",
                    "The current link is not as expected");

            WebElement searchResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-page\"]/div[2]/div[2]/div[2]/div[1]/div/div[1]/h3[1]")));

            System.out.println(searchResult.getText());
            Assert.assertTrue(searchResult.getText().contains("Books"));

            driver.close();
            driver.quit();
        }

}
