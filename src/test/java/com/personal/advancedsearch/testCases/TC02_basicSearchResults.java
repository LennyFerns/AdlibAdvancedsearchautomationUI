package com.personal.advancedsearch.testCases;

import com.personal.advancedsearch.pageObjects.SearchPage;
import com.personal.advancedsearch.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC02_basicSearchResults extends BaseTest {


    @Test
    public void basicSearchInteraction() throws InterruptedException {
        //driver.get("https://demo.nopcommerce.com/search");

        SearchPage searchPage = new SearchPage(driver);

        searchPage.enterSearchTerm("phone");
        Thread.sleep(5000);

        searchPage.clickSearch();

        Thread.sleep(5000);

        List<WebElement> results = searchPage.getAllProductTitles();

        System.out.println("✅ Search returned " + results.size() + " results.");

        // Basic validation: at least one product result
        Assert.assertTrue(results.size() > 0, " No products were found!");

        // Optional: Check if product titles contain the term 'phone'
        for (WebElement product : results) {
            String title = product.getText().toLowerCase();
            System.out.println("Found: " + title);
            Assert.assertTrue(title.contains("phone") || title.contains("htc") || title.contains("iphone"),
                    " Product title doesn't match expected keyword.");
        }
    }
}
