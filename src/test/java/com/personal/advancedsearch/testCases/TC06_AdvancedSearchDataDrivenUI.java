package com.personal.advancedsearch.testCases;

import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.personal.advancedsearch.pageObjects.SearchPage;
import com.personal.advancedsearch.testbase.BaseTest;
import com.personal.advancedsearch.dataproviders.SearchDataProvider;
import com.personal.advancedsearch.utilities.ConfigReader;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC06_AdvancedSearchDataDrivenUI extends BaseTest {
    @Test(dataProvider = "searchData", dataProviderClass = SearchDataProvider.class)
    public void advancedSearchWithData(String keyword, String category, boolean subCat, String manufacturer, boolean searchDesc) throws InterruptedException {

        Eyes eyes = new Eyes();
        eyes.setApiKey(ConfigReader.get("applitools.api.key"));
        ; // ("applitools.api.key")  from config

        eyes.open(driver, "NopCommerce", "Advanced Search UI Test");

        SearchPage searchPage = new SearchPage(driver);

        // Step 1: Enter keyword
        searchPage.enterSearchTermKeyword(keyword);
        Thread.sleep(1000);

        // Step 2: Enable advanced search
        searchPage.clickADCheckbox();

        // Step 3: Category selection
        new Select(searchPage.getCategoryDropdown()).selectByVisibleText(category);

        // Step 4: SubCategory
        if (subCat) {
            searchPage.clickSubCategoryCheckbox();
        }

        // Step 5: Manufacturer
        new Select(searchPage.getManufacturerDropdown()).selectByVisibleText(manufacturer);

        // Step 6: Search in descriptions
        if (searchDesc) {
            searchPage.clickSearchDescriptionCheckbox();
        }

        // Step 7: Visual UI Check
        eyes.check("Advanced Search - UI", Target.window());

        // Step 8: Trigger search
        searchPage.clickSearch();

        eyes.closeAsync();
    }
}


