package org.future.epam.employees.homeTask;

import org.future.epam.employees.homeTask.pageObject.pages.MainPage;
import org.future.epam.employees.homeTask.pageObject.pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VerifySearchPOTest extends BaseTest {


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
                        {"Keyboard", "//span[text()[contains(.,\"Keyboard\")]]"},
                        {"Hello Kitty", "//span[text()[contains(.,\"Hello Kitty\")]]"}
                };
    }

    @BeforeTest
    public void start(){
        super.setUpDriver();
    }


    @Test(dataProvider = "CorrectRequests")
    public void correctRequestTest(String request) {
        MainPage mainPage = new MainPage(webDriver);
        ResultPage resultPage = mainPage.sendRequest(request);

        Assert.assertTrue(resultPage.getSearchName().contains(request),
                "The current link is not as expected");
    }

    @Test(dataProvider = "IncorrectRequests")
    public void incorrectRequestTest(String incorrectR) {
        MainPage mainPage = new MainPage(webDriver);
        ResultPage resultPage = mainPage.sendRequest(incorrectR);
        Assert.assertTrue(resultPage.noResultAnnotation().contains("No results for"),
                "The expected message did not appear");
    }

    @Test(dataProvider = "ContainWords")
    public void containsWordTest(String request, String path) {
        MainPage mainPage = new MainPage(webDriver);
        ResultPage resultPage = mainPage.sendRequest(request);
        Assert.assertTrue(resultPage.searchEnteredProduct(path).contains(request),
                "The current page does not contain expected result");
    }

    @AfterTest
    public void quite(){
        super.quit();
    }


}
