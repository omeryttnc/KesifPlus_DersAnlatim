package utilities;


import org.junit.Assert;

import static stepDefinitions.Hooks.driver;

public class BrowserUtilities {
    public static void assertUrl(String expectedUrl){
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());
    }
}
