package com.personal.advancedsearch.testCases;

import com.personal.advancedsearch.pageObjects.SearchPage;
import com.personal.advancedsearch.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC04_advanceSearchResults extends BaseTest {
    @Test
    public void advanceSearchInteraction() throws InterruptedException {
//        driver.get("https://demo.nopcommerce.com/search"); //removed since m using url from config file now

        SearchPage searchPage = new SearchPage(driver);

        // Use the advanced search field
        searchPage.enterSearchTermKeyword("laptop");

        Thread.sleep(3000); // Optional debug wait

        searchPage.clickAdvanceSearch();

        Thread.sleep(3000); // Optional debug wait

        List<WebElement> results = searchPage.getAllProductTitles();

        System.out.println("✅ Advanced Search returned " + results.size() + " results.");

        // Basic validation
        Assert.assertTrue(results.size() > 0, "❌ No products were found!");

        for (WebElement product : results) {
            String title = product.getText().toLowerCase();
            System.out.println("Found: " + title);
            Assert.assertTrue(title.contains("laptop") || title.contains("notebook") || title.contains("ultrabook"),
                    "❌ Product title doesn't match expected keyword.");
        }
    }
}


