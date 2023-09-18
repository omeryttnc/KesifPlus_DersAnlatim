package utilities;


import com.google.common.base.Predicates;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiUtilities {
    static Response response;
    static ResponseSpecification responseSpecification;
    static RequestSpecification requestSpecification;

    public static String getToken(String email, String password) {
        Map<String, String> mapBody = new HashMap<>();

        mapBody.put("email", email);
        mapBody.put("password", password);

        response = given()
                .contentType(ContentType.JSON)
                .body(mapBody)
                .post("https://test.urbanicfarm.com/api/public/login");

        return response.jsonPath().getString("token");
    }

    public static Response createAddress(String token, InnerRecordCreateAddress body) {
        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .body(body)
                .post("https://test.urbanicfarm.com/api/account/address/addAddress");

        return response;
    }

    public static InnerRecordAddressInfo getAddressDetails(String token) {
        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .post("https://test.urbanicfarm.com/api/account/address/getAddress");

        List<Integer> listId = response.jsonPath().getList("addresses.id");
        List<Object> listTitle = response.jsonPath().getList("addresses.title");
        List<Boolean> listisDefault = response.jsonPath().getList("addresses.isDefault");
        InnerRecordAddressInfo innerRecordAddressInfo = new InnerRecordAddressInfo(listId, listTitle,listisDefault);
        return innerRecordAddressInfo;
    }

    public record InnerRecordAddressInfo(List<Integer> listId, List<Object> listTitle,List<Boolean> isDefault) {
    }


    public record InnerRecordCreateAddress(boolean isDefault, boolean isSellerAddress, String title, String address,
                                           String city, String state, String postal) {

    }

    public class InnerClassCreateAddress {
        private boolean isDefault;
        private boolean isSellerAddress;
        private String title;
        private String address;
        private String city;
        private String state;
        private String postal;

        public InnerClassCreateAddress(boolean isDefault, boolean isSellerAddress, String title, String address, String city, String state, String postal) {
            this.isDefault = isDefault;
            this.isSellerAddress = isSellerAddress;
            this.title = title;
            this.address = address;
            this.city = city;
            this.state = state;
            this.postal = postal;
        }

        public boolean isDefault() {
            return isDefault;
        }

        public boolean isSellerAddress() {
            return isSellerAddress;
        }

        public String getTitle() {
            return title;
        }

        public String getAddress() {
            return address;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getPostal() {
            return postal;
        }
    }

//    @AllArgsConstructor
//    @Data // @Getter @Setter @ToString class uzerindeki butun parametrelere uygulanir
//    public class InnerLombokCreateAddress{
//        private   boolean isDefault;
//        private boolean isSellerAddress ;
//        private String title;
//        private String address;
//       // @Getter
//        private String city;
//        private String state;
//      //  @Setter ozellikle sadece bunun setter i olmasi icin kullancaksaniz objenin uzerine yazariz
//        private String postal;
//
//    }

}

