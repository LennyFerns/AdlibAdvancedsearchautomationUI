package com.personal.advancedsearch.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    WebDriver driver;

    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(id = "small-searchterms")
    WebElement smallSearchInput;

    @FindBy(xpath = "//button[@class='button-1 search-box-button']")
    WebElement smallSearchButton;

    @FindBy(id = "q")
    WebElement advanceSearchInput;

    @FindBy(id = "advs")
    WebElement advanceSearchCheckBox;

    @FindBy(id = "cid")
    WebElement categoryDropdown;

    @FindBy(id = "isc")
    WebElement subCategoryCheckbox;

    @FindBy(id = "mid")
    WebElement manufacturerDropdown;

    @FindBy(id = "sid")
    WebElement searchDescriptionCheckbox;

    @FindBy(xpath = "//button[@class='button-1 search-button']")
    WebElement advanceSearchButton;

    @FindBy(css = ".product-title")
    List<WebElement> productTitles;

    // Actions
    public void enterSearchTerm(String product) {
        smallSearchInput.clear();
        smallSearchInput.sendKeys(product);
    }

    //small search filed top right
    public void clickSearch() {
        smallSearchButton.click();
    }

    //Advance Search Keyword Field
    public void enterSearchTermKeyword(String product) {
        advanceSearchInput.clear();
        advanceSearchInput.sendKeys(product);
    }

    //Advance Search  checkbox click
    public void clickADCheckbox(){
        advanceSearchCheckBox.click();
    }
// Category dropdown
    public WebElement getCategoryDropdown() {
        return categoryDropdown; }

// Sub category checkBox
    public void clickSubCategoryCheckbox() {
        subCategoryCheckbox.click(); }

    //Manufacturer Dropdown
    public WebElement getManufacturerDropdown() {
        return manufacturerDropdown; }

    //Manufacturer Checkbox
    public void clickSearchDescriptionCheckbox() {
        searchDescriptionCheckbox.click(); }


    //Advance Search  button click
    public void clickAdvanceSearch() throws InterruptedException {
        advanceSearchButton.click();

        Thread.sleep(2000); // For debugging

        // Wait after clicking search
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(productTitles));
    }

    public List<WebElement> getAllProductTitles() {
        return productTitles;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}