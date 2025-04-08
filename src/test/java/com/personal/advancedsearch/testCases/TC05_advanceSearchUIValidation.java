package com.personal.advancedsearch.testCases;

import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.personal.advancedsearch.pageObjects.SearchPage;
import com.personal.advancedsearch.testbase.BaseTest;
import com.personal.advancedsearch.utilities.ApplitoolsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_advanceSearchUIValidation extends BaseTest {

    @Test
    public void validateAdvancedSearchUI() throws InterruptedException {
        Eyes eyes = ApplitoolsUtil.initEyes(driver);

        try {
            SearchPage searchPage = new SearchPage(driver);

            searchPage.enterSearchTermKeyword("laptop");
            Thread.sleep(2000);

            WebElement advSearchCheckbox = driver.findElement(By.xpath("//input[@id='advs']"));
            if (!advSearchCheckbox.isSelected()) {
                advSearchCheckbox.click();
            }

            // UI Visual Check
            eyes.check("Advanced Search UI", Target.window());

            // UI Elements Assertions
            WebElement categoryDropdown = driver.findElement(By.id("cid"));
            Assert.assertTrue(categoryDropdown.isDisplayed(), "Category dropdown is not visible");

            WebElement subcategoryCheckbox = driver.findElement(By.id("isc"));
            Assert.assertTrue(subcategoryCheckbox.isDisplayed(), "Subcategory checkbox is not visible");

            WebElement manufacturerDropdown = driver.findElement(By.id("mid"));
            Assert.assertTrue(manufacturerDropdown.isDisplayed(), "Manufacturer dropdown is not visible");

            WebElement descCheckbox = driver.findElement(By.id("sid"));
            Assert.assertTrue(descCheckbox.isDisplayed(), "Search in description checkbox is not visible");

            WebElement searchBtn = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
            Assert.assertTrue(searchBtn.isDisplayed(), "Search button is not visible");

        } finally {
            eyes.closeAsync();
        }
    }
}