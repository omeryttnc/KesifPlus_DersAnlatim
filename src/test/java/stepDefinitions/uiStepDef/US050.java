package stepDefinitions.uiStepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;

public class US050 extends CommonPage {

    String message = new Faker().name().firstName();

    @Given("user is on the user panel page")
    public void userIsOnTheUserPanelPage() {
        Assert.assertEquals("https://kesifplus.com/user-panel", driver.getCurrentUrl());
    }

    @Then("user verifies that the url is {string}")
    public void userVerifiesThatTheUrlIs(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains(url));
    }

    @When("user clicks on Profile tab")
    public void userClicksOnProfileTab() {
        commonPage.getProfilePage().sidebarProfile.click();
    }

    @Then("user verifies introduction card is visible")
    public void userVerifiesIntroductionCardIsVisible() {
        Assert.assertTrue(commonPage.getProfilePage().introductionCard.isDisplayed());
        Assert.assertTrue(commonPage.getProfilePage().introduceYourself.isDisplayed());
    }

    @And("user verifies Update Introduction button is clickable")
    public void userVerifiesUpdateIntroductionButtonIsClickable() {
        Assert.assertTrue(commonPage.getProfilePage().updateIntroduction.isEnabled());
    }

    @When("user clicks on the Update Introduction button")
    public void userClicksOnTheUpdateIntroductionButton() {
        BrowserUtilities.waitFor(3);
        commonPage.getProfilePage().updateIntroduction.click();
    }

    @Then("user verifies introduction textarea is visible")
    public void userVerifiesIntroductionTextareaIsVisible() {
        Assert.assertTrue(commonPage.getProfilePage().introductionTextArea.isDisplayed());
    }

    @And("user verifies introduction textarea is clickable")
    public void userVerifiesIntroductionTextareaIsClickable() {
        Assert.assertTrue(commonPage.getProfilePage().introductionTextArea.isEnabled());
    }

    @And("user clicks on Save Introduction button")
    public void userClicksOnSaveIntroductionButton() {
        getProfilePage().saveIntroduction.click();
    }

    @And("user verifies save introduction button is visible")
    public void userVerifiesSaveIntroductionButtonIsVisible() {
        Assert.assertTrue(commonPage.getProfilePage().saveIntroduction.isDisplayed());
    }

    @And("user writes an introduction message")
    public void userWritesAnIntroductionMessage() {
        getProfilePage().introductionTextArea.sendKeys(message);
    }

    @Then("user verifies message is visible on the page")
    public void userVerifiesMessageIsVisibleOnThePage() {
        Assert.assertTrue(getProfilePage().introductionNote.isDisplayed());
        Assert.assertEquals(message, getProfilePage().introductionNote.getText());
    }

    @Then("user verifies Delete button is visible")
    public void userVerifiesDeleteButtonIsVisible() {
        Assert.assertTrue(getProfilePage().deleteButton.isDisplayed());
    }

    @And("user verifies Delete button is clickable")
    public void userVerifiesDeleteButtonIsClickable() {
        Assert.assertTrue(getProfilePage().deleteButton.isEnabled());
    }

    @When("user clicks Delete button")
    public void userClicksDeleteButton() {
        getProfilePage().deleteButton.click();
    }

    @Then("user verifies message is not visible on the page")
    public void userVerifiesMessageIsNotVisibleOnThePage() {
        for (int i = 0; i < getProfilePage().profilePTags.size(); i++) {
            Assert.assertNotEquals(message, getProfilePage().profilePTags.get(i).getText());
        }
    }


}
