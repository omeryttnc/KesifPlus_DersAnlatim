package enums;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public enum LINKS {
    BEFORE_PLATIN("rgba(23, 150, 95, 1)", "rgba(245, 245, 250, 1)"),
    AFTER_PLATIN("rgba(255, 255, 255, 1)", "rgba(23, 150, 95, 1)");
    private String textColor, backgroundColor;

    LINKS(String textColor, String backgroundColor) {
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
    }

    public void assertTextColorOfWebElement(WebElement webElement) {
        Assert.assertEquals(this.textColor, webElement.getCssValue("color"));
    }

    public void assertBackgroundOfWebElement(WebElement webElement) {
        Assert.assertEquals(this.backgroundColor, webElement.getCssValue("background-color"));
    }

    public void assertBackGroundAndTextColor(WebElement webElement) {
        Assert.assertEquals(this.textColor, webElement.getCssValue("color"));
        Assert.assertEquals(this.backgroundColor, webElement.getCssValue("background-color"));
    }
}
