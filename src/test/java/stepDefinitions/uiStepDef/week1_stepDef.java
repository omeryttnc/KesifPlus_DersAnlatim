package stepDefinitions.uiStepDef;

import enums.ENUM_CLASS;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import pages.HomePage;
import utilities.BrowserUtilities;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;

public class week1_stepDef extends CommonPage {
    HomePage homePage = new HomePage();

    @Given("users goes to home page")
    public void usersGoesToHomePage() {
        driver.get("http://kesifplus.com/");
    }

    @When("user clicks on home button")
    public void userClicksOnHomeButton() {
        // way 1 -> single webelement uzerinden gittik
        // homePage.homePageButton.click();

        // way 2  ->liste uzerinden gittik
       // homePage.navbarlist.get(0).click();

        // way 3  -> common page deki objeyi kullandik
       // commonPage.getHomePage().homePageButton.click();

        // way 4  -> extends Common page
        getHomePage().navbarlist.get(0).click();


    }

    @Then("verify url is {string}")
    public void verifyUrlIs(String expectedUrl) {
        // way 1 simple assertion
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());

        // way 2 hazir method
        assertUrl(expectedUrl);

        // way 3 browser utilities
        BrowserUtilities.assertUrl(expectedUrl);

        // way 4 extension method
        expectedUrl.assertUrl();
    }

    @When("user clicks on about us button")
    public void userClicksOnAboutUsButton() {

        homePage.navbarlist.get(1).click();
    }

    public void assertUrl(String expectedUrl){
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());
    }


    @Then("assert with enum")
    public void assertWithEnum() {
        ENUM_CLASS.HOME_PAGE.assertUrl();

        ENUM_CLASS.ABOUT_US_PAGE.clickPage();
        ENUM_CLASS.ABOUT_US_PAGE.assertUrl();

        ENUM_CLASS.CONTACT_US_PAGE.clickPage();
        ENUM_CLASS.CONTACT_US_PAGE.assertUrl();
    }
}
