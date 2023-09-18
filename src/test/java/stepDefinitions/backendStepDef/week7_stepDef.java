package stepDefinitions.backendStepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import utilities.ApiUtilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.IsEqual.equalTo;

public class week7_stepDef {
    Response response;
    String token;
    int createdAddressId;
    String email ="kesifplussatici@mailsac.com";
    String password ="e*y7G2xhsTVAi5u";
    @Given("user get Token")
    public void userGetToken() {
        token = ApiUtilities.getToken(email,password);

    }

    @When("user create address")
    public void userCreateAddress() {

        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .body("{\"isDefault\":false,\"isSellerAddress\":false,\"title\":\"kesif plus\",\"address\":\"San Jose, CA 95109, USA\",\"city\":\"San Jose\",\"state\":\"Santa Clara County\",\"postal\":\"95109\"}")
                .post("https://test.urbanicfarm.com/api/account/address/addAddress");

        Assert.assertEquals(response.statusCode(), 200); // status code assertion yapmis olurum

        Assert.assertTrue(response.jsonPath().getBoolean("success")); // success true geliyor mu

        createdAddressId = response.jsonPath().getInt("address.id");
        System.out.println("createdAddressId = " + createdAddressId);
    }

    @Then("assert if address is created")
    public void assertIfAddressIsCreated() {
        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .post("https://test.urbanicfarm.com/api/account/address/getAddress");

        Assert.assertEquals(response.statusCode(), 200); // status code assertion yapmis olurum

        Assert.assertTrue(response.jsonPath().getBoolean("success")); // success true geliyor mu

        List<Integer> list = response.jsonPath().getList("addresses.id");
        Assert.assertTrue(list.contains(createdAddressId));
        System.out.println("list = " + list);
    }

    @When("user update address json path")
    public void userUpdateAddressJsonPath() {
        // JsonPath kullanarak
        String title = new Faker().name().firstName();
        Map<String, Object> map = new HashMap<>();
        map.put("title", title);
        map.put("addressId", createdAddressId);


        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .body(map)
                .post("https://test.urbanicfarm.com/api/account/address/update");

        Assert.assertEquals(response.statusCode(), 200); // status code assertion yapmis olurum

        Assert.assertTrue(response.jsonPath().getBoolean("success")); // success true geliyor mu
        Assert.assertEquals(title, response.jsonPath().getString("address.title"));
    }

    @When("user update address hamcrest")
    public void userUpdateAddressHamcrest() {
        // Hamcrest Matcher kullanarak


        String title = new Faker().name().firstName();
        Map<String, Object> map = new HashMap<>();
        map.put("title", title);
        map.put("addressId", createdAddressId);


        given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .body(map)
                .post("https://test.urbanicfarm.com/api/account/address/update")
                .then()
                .assertThat()
                .statusCode(200)                                    //        Assert.assertEquals(response.statusCode(), 200); // status code assertion yapmis olurum
                .body("success", equalTo(true))   //        Assert.assertTrue(response.jsonPath().getBoolean("success")); // success true geliyor mu
                .body("address.title", equalTo(title))   //        Assert.assertEquals(title, response.jsonPath().getString("address.title"));
                .time(lessThan(5000L))
                .header("content-type", "application/json")
                .log()
                .body();
//


    }

    @Then("assert if address is updated")
    public void assertIfAddressIsUpdated() {
    }

    @When("user delete address")
    public void userDeleteAddress() {
        Map<String, Object> map = new HashMap<>();
        map.put("addressId", createdAddressId);

        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .body(map)
                .post("https://test.urbanicfarm.com/api/account/address/delete");
        Assert.assertEquals(response.statusCode(), 200); // status code assertion yapmis olurum

        Assert.assertTrue(response.jsonPath().getBoolean("success")); // success true geliyor mu


        //  response.prettyPrint();

    }

    @Then("assert if address is deleted")
    public void assertIfAddressIsDeleted() {
        Assert.assertFalse(getAllAddressID().contains(createdAddressId));
    }

    public List<Integer> getAllAddressID() {
        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .post("https://test.urbanicfarm.com/api/account/address/getAddress");

        Assert.assertEquals(response.statusCode(), 200); // status code assertion yapmis olurum

        Assert.assertTrue(response.jsonPath().getBoolean("success")); // success true geliyor mu

        List<Integer> list = response.jsonPath().getList("addresses.id");

        System.out.println("list = " + list);
        return list;
    }


}
