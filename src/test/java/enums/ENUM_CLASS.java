package enums;

import org.junit.Assert;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;

public enum ENUM_CLASS {
    HOME_PAGE("http://kesifplus.com/",0),
    ABOUT_US_PAGE("http://kesifplus.com/about-us",1),
    CONTACT_US_PAGE("http://kesifplus.com/contact-us",2),
    ;
    private String url;
    private int index;

    ENUM_CLASS(String url, int index) {
        this.url = url;
        this.index = index;
    }

    public String getUrl() {
        return url;
    }

    public int getIndex() {
        return index;
    }

    public void assertUrl() {
        Assert.assertEquals(this.url, driver.getCurrentUrl());
    }

    public void clickPage(){
        commonPage.getHomePage().navbarlist.get(this.index).click();
    }

}
