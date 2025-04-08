package com.personal.advancedsearch.testCases;

import com.personal.advancedsearch.pageObjects.SearchPage;
import com.personal.advancedsearch.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC03_advanceSearchCheckboxTest extends BaseTest {

    @Test
    public void advancedSearchCheckboxTest() throws InterruptedException {
       // driver.get("https://demo.nopcommerce.com/search");

        Thread.sleep(4000);

        SearchPage searchPage = new SearchPage(driver);


        // Step 1: Enter search term in advanced search field
        searchPage.enterSearchTermKeyword("laptop");
        Thread.sleep(4000);



        // Step 2: Click the "Advanced Search" checkbox
        WebElement advSearchCheckbox = driver.findElement(By.xpath("//input[@id='advs']"));
        if (!advSearchCheckbox.isSelected()) {
            advSearchCheckbox.click();
        }
        Thread.sleep(4000);

        // Wait after checking the Advanced Search box
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// Verify Category dropdown
        WebElement categoryDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cid")));
        Assert.assertTrue(categoryDropdown.isDisplayed(), "Category dropdown is not visible");

// Verify Subcategory checkbox
        WebElement subcategoryCheckbox = driver.findElement(By.id("isc"));
        Assert.assertTrue(subcategoryCheckbox.isDisplayed(), "Subcategory checkbox is not visible");

// Verify Manufacturer dropdown
        WebElement manufacturerDropdown = driver.findElement(By.id("mid"));
        Assert.assertTrue(manufacturerDropdown.isDisplayed(), "Manufacturer dropdown is not visible");

// Verify Search in description checkbox
        WebElement descCheckbox = driver.findElement(By.id("sid"));
        Assert.assertTrue(descCheckbox.isDisplayed(), "Search in description checkbox is not visible");

    }
}

