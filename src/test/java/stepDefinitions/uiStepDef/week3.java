package stepDefinitions.uiStepDef;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.BrowserUtilities;

import java.util.List;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;

public class week3 {

    private String username;
    private String password = "123456789";
    ;

    @Given("user goes to register page")
    public void userGoesToRegisterPage() {
        driver.get("http://kesifplus.com/register");
    }

    @When("user complete registration")
    public void userCompleteRegistration() {
        Faker faker = new Faker();

        username = faker.internet().emailAddress();

        commonPage.getRegisterPage().registerUser(username, password);



        /*
         email.sendKeys(username);
        password.sendKeys(userPassword);
        password2.sendKeys(userPassword);
        submit.click();
         */
    }

    @And("user is able to see {string} alert")
    public void userIsAbleToSeeAlert(String expectedAlert) {
        BrowserUtilities.assertAlert(expectedAlert);
        BrowserUtilities.acceptAlert();
    }

    @And("user is able to login with new credentials")
    public void userIsAbleToLoginWithNewCredentials() {

        commonPage.getLoginPage().login(username, password);

    }

    @Then("user is able to see sidebar locator as follow")
    public void userIsAbleToSeeSidebarLocatorAsFollow(DataTable dataTable) {


        List<String> column = dataTable.column(0); // ctrl alt v
        List<WebElement> sideBar = commonPage.getWelcomePage().sideBar;

        for (int i = 0; i < column.size(); i++) {
            Assert.assertEquals(column.get(i), sideBar.get(i).getText());
        }

    }


    @When("user send wrong email address {string}")
    public void userSendWrongEmailAddress(String email) {
        commonPage.getRegisterPage().sendEmail(email);
        commonPage.getRegisterPage().clickSubmit();
    }

    @Then("user is able to get correct warning text {string}")
    public void userIsAbleToGetCorrectWarningText(String expectedWarningText) {
        commonPage.getRegisterPage().assertEmailWarningText(expectedWarningText);

    }

    @When("flash email webElement")
    public void flashEmailWebElement() {


    }
}
