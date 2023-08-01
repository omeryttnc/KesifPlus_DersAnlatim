package enums;

import org.junit.Assert;

import static stepDefinitions.Hooks.driver;

public class NormalClass {
    private String url;
    private int index;

    public String getUrl() {
        return url;
    }

    public int getIndex() {
        return index;
    }

    public NormalClass(String url, int index) {
        this.url = url;
        this.index = index;
    }

    public void assertUrl() {
        Assert.assertEquals(this.url, driver.getCurrentUrl());
    }
}
