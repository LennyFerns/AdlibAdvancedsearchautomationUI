package com.personal.advancedsearch.testCases;

import com.personal.advancedsearch.testbase.BaseTest;
import com.personal.advancedsearch.pageObjects.SearchPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;

public class TC01_OpenAdvancedSearchPage extends BaseTest {


    @Test
    public void searchForProduct() {
       // driver.get("https://demo.nopcommerce.com/search");

        SearchPage searchPage = new SearchPage(driver);

//        searchPage.enterSearchTerm("laptop");
//        searchPage.clickSearch();

        // ✅ Use the wait method
        String title = waitForPageTitleContains("Search");
        System.out.println("✅ Search Results Page Title: " + title);

        Assert.assertTrue(title.toLowerCase().contains("search"), "Title does not contain 'search'");
    }

    public String waitForPageTitleContains(String keyword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(keyword));
        return driver.getTitle();
    }

}
