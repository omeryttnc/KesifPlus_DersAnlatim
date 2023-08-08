package utilities;


import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static stepDefinitions.Hooks.actions;
import static stepDefinitions.Hooks.driver;

public class BrowserUtilities {
    public static void assertUrl(String expectedUrl){
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());
    }

    public static void scrollToWebElement(WebElement webElement) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    // 1. way throw exception
    // 2. way try/catch
    // 3. way lombok annotation SneakyThrows

    public static void waitFor(int sec) {

        try {
            Thread.sleep(Duration.ofSeconds(sec));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void hoverWebElement(WebElement webElement) {
        //   Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();

    }
    public static void assertTextColorOfWebElement(String rgba, WebElement webElement) {
        Assert.assertEquals(rgba, webElement.getCssValue("color"));
    }

    /**
     * JavaDoc webelementin background color ini assert ediyoruz
     * @param rgba webelementin background rengi
     * @param webElement rengini alacagimiz weblement
     * @author omeryttnc
     * @since 08.08.2023
     */
    public static void assertBackgroundOfWebElement(String rgba, WebElement webElement) {
        Assert.assertEquals(rgba, webElement.getCssValue("background-color"));
    }

    /**
     *
     * @param name deneme
     * @return deneme retun
     */
    public static String denemeJavaDoc(String name){
        return name.toLowerCase();
    }
}
