package stepDefinitions.backendStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.ApiUtilities;
import utilities.ConfigurationReader;

import java.util.List;

import static utilities.ApiUtilities.response;

public class Week8 {
    int beforeDeletion, afterDeletion;
    String email;

    @Given("user logs in as an admin")
    public void userLogsInAsAnAdmin() {
        ApiUtilities.Admin.adminLogin(ConfigurationReader.getProperty("admin"), ConfigurationReader.getProperty("admin"));
    }

    @When("admin gets users list")
    public void adminGetsUsersList() {
        ApiUtilities.Admin.getUsers();
    }

    @And("user gets the number of users")
    public void userGetsTheNumberOfUsers() {
        // getList("$").size()
        beforeDeletion = response.jsonPath().getList("userid").size();
        System.out.println(beforeDeletion);
    }

    @And("admin chooses a user")
    public void adminChoosesAUser() {
        List<String> emails = response.jsonPath().getList("email");
        for (String email : emails) {
            if (email.contains("yahoo")) {
                this.email = email;
                break;
            }
        }
    }

    @And("admin deletes a user")
    public void adminDeletesAUser() {
        System.out.println(email);
        ApiUtilities.Admin.deleteUser(email);
    }

    @Then("admin verifies user is deleted")
    public void adminVerifiesUserIsDeleted() {
        System.out.println(response.htmlPath().get("html.body").toString());
        System.out.println(response.htmlPath().get("body").toString());
        Assert.assertEquals("deleted", response.htmlPath().get("body").toString());
    }

    @Then("admin verifies the number of users")
    public void adminVerifiesTheNumberOfUsers() {
        afterDeletion = response.jsonPath().getList("userid").size();
        System.out.println(afterDeletion);
        Assert.assertTrue(beforeDeletion > afterDeletion);
        Assert.assertEquals(beforeDeletion - 1, afterDeletion);
    }


}
