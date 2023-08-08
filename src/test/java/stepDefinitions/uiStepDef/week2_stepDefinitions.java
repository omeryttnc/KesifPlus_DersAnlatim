package stepDefinitions.uiStepDef;

import enums.LINKS;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;

import java.time.Duration;

import static stepDefinitions.Hooks.*;
import static utilities.BrowserUtilities.hoverWebElement;
import static utilities.BrowserUtilities.waitFor;

public class week2_stepDefinitions {
    @When("user scroll to plan and pricing")
    public void userScrollToPlanAndPricing() {
        BrowserUtilities.scrollToWebElement(commonPage.getHomePage().planAndPricingText);
        waitFor(2);
    }

    @Then("user should able to see silver background color and text color are expected value")
    public void userShouldAbleToSeeSilverBackgroundColorAndTextColorAreExpectedValue() {

        // way 1 eski yontem

        Assert.assertEquals(
                "rgba(245, 245, 250, 1)",
                commonPage.getHomePage().silver_getStarted.getCssValue("background-color"));

        Assert.assertEquals(
                "rgba(23, 150, 95, 1)",
                commonPage.getHomePage().silver_getStarted.getCssValue("color"));

        hoverWebElement(commonPage.getHomePage().silver_getStarted);
        waitFor(1);
        Assert.assertEquals(
                "rgba(23, 150, 95, 1)",
                commonPage.getHomePage().silver_getStarted.getCssValue("background-color"));

        Assert.assertEquals(
                "rgba(255, 255, 255, 1)",
                commonPage.getHomePage().silver_getStarted.getCssValue("color"));


    }

    @Then("user should able to see gold background color and text color are expected value")
    public void userShouldAbleToSeeGoldBackgroundColorAndTextColorAreExpectedValue() {

        // way 2 hazir method
        BrowserUtilities.assertBackgroundOfWebElement(ConfigurationReader.getProperty("gold_background_beforeHover"), commonPage.getHomePage().gold_getStarted);
        BrowserUtilities.assertTextColorOfWebElement(ConfigurationReader.getProperty("gold_text_beforeHover"), commonPage.getHomePage().gold_getStarted);

        hoverWebElement(commonPage.getHomePage().gold_getStarted);
        waitFor(1);

        // way 3 extension
        commonPage.getHomePage().gold_getStarted.assertTextColor("rgba(23, 150, 95, 1)");
        commonPage.getHomePage().gold_getStarted.assertBackgroundColor("rgba(245, 245, 250, 1)");

    }


    @Then("user should able to see platin background color and text color are expected value")
    public void userShouldAbleToSeePlatinBackgroundColorAndTextColorAreExpectedValue() {

        // way 4 enum lar kullanarak

        LINKS.BEFORE_PLATIN.assertBackgroundOfWebElement(commonPage.getHomePage().platin_getStarted);
        LINKS.BEFORE_PLATIN.assertTextColorOfWebElement(commonPage.getHomePage().platin_getStarted);

        hoverWebElement(commonPage.getHomePage().silver_getStarted);
        waitFor(1);

        LINKS.AFTER_PLATIN.assertBackGroundAndTextColor(commonPage.getHomePage().platin_getStarted);

    }


}
