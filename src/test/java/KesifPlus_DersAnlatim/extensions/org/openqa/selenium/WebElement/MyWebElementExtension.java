package KesifPlus_DersAnlatim.extensions.org.openqa.selenium.WebElement;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;

@Extension
public class MyWebElementExtension {
    public static void assertTextColor(@This WebElement thiz, String rgba) {
        Assert.assertEquals(rgba, thiz.getCssValue("color"));
    }

    public static void assertBackgroundColor(@This WebElement thiz, String rgba) {
        Assert.assertEquals(rgba, thiz.getCssValue("background-color"));
    }

    public static void assertWarningText(@This WebElement thiz, String expectedWarningText) {
        String actualValidationMessage = thiz.getAttribute("validationMessage");
        Assert.assertEquals(expectedWarningText, actualValidationMessage);

    }

    public static void flasWeblement(@This WebElement thiz) {
        WebElement email = thiz;
        String cssValue = email.getCssValue("background-color");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 4; i++) {
            js.executeScript("arguments[0].setAttribute('style','background: yellow;')", email);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            js.executeScript("arguments[0].setAttribute('style','background: " + cssValue + "')", email);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

}