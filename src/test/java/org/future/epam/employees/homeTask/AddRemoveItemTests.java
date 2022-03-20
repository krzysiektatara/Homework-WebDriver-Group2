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

public class AddRemoveItemTests {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().browserVersion("99").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        WebElement category = driver.findElement(By.xpath("//span [text() = 'Keyboards']"));
        category.click();
        WebElement keyboard = driver.findElement(By.xpath("//span[contains(text(), \"Razer Cynosa Chroma Gaming Keyboard: Individually Backlit RGB Keys\")]"));
        keyboard.click();
    }

    @AfterMethod
    public void close() {
        driver.close();
    }


    @Test
    public void addItem() {
        WebElement addToCart = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        addToCart.click();
        WebElement added = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("attachDisplayAddBaseAlert")));
        Assert.assertEquals(added.getText(), "Added to Cart");
        WebElement cartCount = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartCount.getText(), "1");
    }

    @Test
    public void removeItem() {
        WebElement addToCart = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        addToCart.click();
        WebElement added = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("attachDisplayAddBaseAlert")));
        Assert.assertEquals(added.getText(), "Added to Cart");
        WebElement exit = driver.findElement(By.id("attach-close_sideSheet-link"));
        exit.click();
        WebElement cartCount = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartCount.getText(), "1");


        WebElement cart = driver.findElement(By.id("nav-cart"));
        cart.click();
        WebElement delete = driver.findElement(By.xpath("//input[@data-action=\"delete\"]"));
        delete.click();
        WebElement emptyCart = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1 [contains (text(), 'Your Amazon Cart is empty.')]")));
        Assert.assertEquals(emptyCart.getText(), "Your Amazon Cart is empty.");
        WebElement subtotalZero = driver.findElement(By.xpath("//span [contains (text(), '$0.00')]"));
        Assert.assertEquals(subtotalZero.getText(), "$0.00");
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
