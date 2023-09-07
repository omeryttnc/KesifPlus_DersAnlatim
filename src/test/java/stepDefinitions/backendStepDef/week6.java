package stepDefinitions.backendStepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class week6 {
    Response response;
    String fakeEmail = "demokesif311147@gmail.com";// new Faker().internet().emailAddress();
    String password = "ueO2axAiA1b5";

    @Given("user register from backend String")
    public void userRegisterFromBackendString() {
        response = given() // giris yapiyoruz
                .contentType(ContentType.JSON) // gonderecegimiz body nin turunu belirliyoruz
                .body("{\"email\": \"demokesif311147@gmail.com\",\"password\": \"ueO2axAiA1b5\"}")
                // gondermek isermek istedigimiz bilgiyi ekliyoruz
                .post("https://test.kesifplus.com/api/register"); // method ve endpoint i ekliyoruz
        response.prettyPrint();

    }

    @Given("user register from backend Map")
    public void userRegisterFromBackendMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("email", fakeEmail);
        map.put("password", password);

        response = given() // giris yapiyoruz
                .contentType(ContentType.JSON) // gonderecegimiz body nin turunu belirliyoruz
                .body(map)                // gondermek isermek istedigimiz bilgiyi ekliyoruz
                .post("https://test.kesifplus.com/api/register"); // method ve endpoint i ekliyoruz
        response.prettyPrint();
        ResponseBody body = response.getBody();
        System.out.println("body.asString() = " + body.asString());

        Assert.assertEquals("Kayıt işlemi başarılı.", body.asString());

    }

    @Given("user register from backend Inner Class")
    public void userRegisterFromBackendInnerClass() {
        InnerClass innerClass = new InnerClass(fakeEmail, password);

        response = given() // giris yapiyoruz
                .contentType(ContentType.JSON) // gonderecegimiz body nin turunu belirliyoruz
                .body(innerClass)                // gondermek isermek istedigimiz bilgiyi ekliyoruz
                .post("https://test.kesifplus.com/api/register"); // method ve endpoint i ekliyoruz
        response.prettyPrint();
        ResponseBody body = response.getBody();
        System.out.println("body.asString() = " + body.asString());

        Assert.assertEquals("Kayıt işlemi başarılı.", body.asString());
    }

    @Given("user register from backend Record Class")
    public void userRegisterFromBackendRecordClass() {
        InnerRecord innerRecord = new InnerRecord(fakeEmail, password);

        response = given() // giris yapiyoruz
                .contentType(ContentType.JSON) // gonderecegimiz body nin turunu belirliyoruz
                .body(innerRecord)                // gondermek isermek istedigimiz bilgiyi ekliyoruz
                .post("https://test.kesifplus.com/api/register"); // method ve endpoint i ekliyoruz
        response.prettyPrint();
        ResponseBody body = response.getBody();
        System.out.println("body.asString() = " + body.asString());

        Assert.assertEquals("Kayıt işlemi başarılı.", body.asString());
    }

    @Given("is user able to login by created account from backend")
    public void isUserAbleToLoginByCreatedAccountFromBackend() {
        response = given()
                .contentType(ContentType.JSON)
                .body("{\"email\": \"demokesif311147@gmail.com\",\"password\": \"ueO2axAiA1b5\"}")
                .post("https://test.kesifplus.com/api/login");

        response.prettyPrint();
        System.out.println("***************");
        response.prettyPeek();
        JsonPath jsonPath = response.jsonPath();
        String token = jsonPath.getString("token");


        String actualMessage = jsonPath.getString("message");
        String expectedMessage = "enter";

        Assert.assertEquals(expectedMessage, actualMessage);


    }

    @Given("is user able to see programs")
    public void isUserAbleToSeePrograms() {
        String token = getToken(fakeEmail, password);
        response = given()
                .body(token)
                .post("https://test.kesifplus.com/api/user/userRole");

        response.prettyPrint();
        int actualStatusCode = response.statusCode();
        int expectedStatusCode = 200;

        Assert.assertEquals(expectedStatusCode, actualStatusCode);

        JsonPath jsonPath = response.jsonPath();
        int actualUserRole = jsonPath.getInt("userRole");
        int expectedUserRole = 0;
        Assert.assertEquals(expectedUserRole, actualUserRole);

        Assert.assertTrue(response.asString().contains("userRole"));


    }

    @Given("is user able to see user roles")
    public void isUserAbleToSeeUserRoles() {
    }

    public String getToken(String email, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("password", password);

        response = given() // giris yapiyoruz
                .contentType(ContentType.JSON) // gonderecegimiz body nin turunu belirliyoruz
                .body(map)                // gondermek isermek istedigimiz bilgiyi ekliyoruz
                .post("https://test.kesifplus.com/api/login"); // method ve endpoint i ekliyoruz

        return response.jsonPath().getString("token");
    }

    class InnerClass {
        private String email;
        private String password;


        public InnerClass(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
    }


    record InnerRecord(String email, String password) {
    }
}
