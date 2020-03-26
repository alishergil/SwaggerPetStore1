package swaggerPetStore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class FindPetByStatus {
    @BeforeClass
    public static void setBaseUri() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }
    @Test
    public void findPetByStatus() {
        List<String> response = given()
                .queryParam("status", "available")
                .when()
                .get("/pet/findByStatus")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response()
                .path("name");
        System.out.println("No. of pets available: " + response.size());
        System.out.println(response);
    } // end of Test
} // end of class