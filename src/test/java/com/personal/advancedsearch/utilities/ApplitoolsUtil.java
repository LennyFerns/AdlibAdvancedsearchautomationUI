package com.personal.advancedsearch.utilities;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;

public class ApplitoolsUtil {
    public static Eyes initEyes(WebDriver driver) {
        Eyes eyes = new Eyes();
        eyes.setApiKey(ConfigReader.get("applitools.api.key"));
        eyes.setBatch(new BatchInfo("Advanced Search Batch"));
        eyes.open(driver, "NopCommerce", "Advanced Search UI Validation");
        return eyes;
    }
}


