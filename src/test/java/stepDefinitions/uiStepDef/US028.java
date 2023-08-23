package stepDefinitions.uiStepDef;

import enums.EnumCalismasi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.awt.*;

import static stepDefinitions.Hooks.commonPage;

public class US028 {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double compWidth = screenSize.getWidth();
    double compHeight = screenSize.getHeight();

    @Then("user verifies Account is clickable")
    public void userVerifiesAccountIsClickable() {
        Assert.assertTrue(commonPage.getHomePage().account.isEnabled());
    }

    @When("user clicks on Account button")
    public void userClicksOnAccountButton() {
        commonPage.getHomePage().account.click();
    }

    @And("user enters valid credentials")
    public void userEntersValidCredentials() {
        commonPage.getLoginPage().email.sendKeys(EnumCalismasi.DEMOKESIF.getEmail());
        commonPage.getLoginPage().password.sendKeys(EnumCalismasi.DEMOKESIF.getPassword());
    }

    @And("user clicks on login button")
    public void userClicksOnLoginButton() {
        commonPage.getLoginPage().loginButton.click();
    }

    @Then("user verifies the dimensions of the sidebar without minimizing")
    public void userVerifiesTheDimensionsOfTheSidebarWithoutMinimizing() {
        int height = commonPage.getUserPanelPage().sidebar.getSize().getHeight();
        int width = commonPage.getUserPanelPage().sidebar.getSize().getWidth();

        System.out.println("before minimizing height: " + height);
        System.out.println("before minimizing width: " + width);

        Assert.assertTrue(compHeight > height && height >= 694);
        Assert.assertTrue(compWidth > width && width >= 250);
        System.out.println("computer width: " + compWidth);
        System.out.println("computer height: " + compHeight);
    }

    @When("user clicks on the left arrow")
    public void userClicksOnTheLeftArrow() {
        commonPage.getUserPanelPage().leftArrow.click();
    }

    @Then("user verifies the dimensions of the sidebar after minimizing")
    public void userVerifiesTheDimensionsOfTheSidebarAfterMinimizing() {
        int height = commonPage.getUserPanelPage().sidebar.getSize().getHeight();
        int width = commonPage.getUserPanelPage().sidebar.getSize().getWidth();

        System.out.println("after minimizing height: " + height);
        System.out.println("after minimizing width: " + width);

        Assert.assertTrue(compHeight > height && height >= 694);
        Assert.assertTrue(compWidth > width && width >= 90);
    }
}
