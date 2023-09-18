package stepDefinitions.backendStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ApiUtilities;

public class week7_version2 {
    Response response;
    String token;
    int createdAddressId;
    String email ="kesifplussatici@mailsac.com";
    String password ="e*y7G2xhsTVAi5u";
    @Given("user get Token version")
    public void userGetTokenVersion() {
        token = ApiUtilities.getToken(email,password);
    }

    @When("user create address version")
    public void userCreateAddressVersion() {
        //                .body("{\"isDefault\":false,\"isSellerAddress\":false,\"title\":\"kesif plus\",\"address\":\"San Jose, CA 95109, USA\",\"city\":\"San Jose\",\"state\":\"Santa Clara County\",\"postal\":\"95109\"}")
        ApiUtilities.InnerRecordCreateAddress innerRecordCreateAddress = new ApiUtilities.InnerRecordCreateAddress(
                false,
                false,
                "title",
                "addsss",
                "city eklenecek",
                "stae buraya gelecek",
                "95109"
        );
        Response address = ApiUtilities.createAddress(token, innerRecordCreateAddress);

        Assert.assertEquals(address.statusCode(), 200); // status code assertion yapmis olurum

        Assert.assertTrue(address.jsonPath().getBoolean("success")); // success true geliyor mu

        createdAddressId = address.jsonPath().getInt("address.id");
    }

    @Then("assert if address is created version")
    public void assertIfAddressIsCreatedVersion() {

        ApiUtilities.InnerRecordAddressInfo addressDetails = ApiUtilities.getAddressDetails(token);

       Assert.assertTrue( addressDetails.listId().contains(createdAddressId));
//       addressDetails.isDefault()

    }

    @When("user update address json path version")
    public void userUpdateAddressJsonPathVersion() {
    }

    @When("user update address hamcrest version")
    public void userUpdateAddressHamcrestVersion() {
    }

    @Then("assert if address is updated version")
    public void assertIfAddressIsUpdatedVersion() {
    }

    @When("user delete address version")
    public void userDeleteAddressVersion() {
    }

    @Then("assert if address is deleted version")
    public void assertIfAddressIsDeletedVersion() {
    }
}
