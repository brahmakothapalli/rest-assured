package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class AssignmentTests {

    public String baseUrl = "https://api.github.com/user/repos";
    public final String token = "YOUR_BEARER_TOKEN_HERE";

    @Test
    public void testAuthenticateWithToken(){
        Response response = RestAssured.
                given().
                        header("content-type", "application/json").
                        header("authorization", "Bearer "+token).
                when().
                        get(baseUrl).
                then().
                        assertThat().statusCode(200).
                and().contentType(ContentType.JSON).extract().response();

        String responseAsString = response.asString();

        JsonPath jsonResponse = new JsonPath(responseAsString);

//        System.out.println(jsonResponse.get("[0].name"));

//        System.out.println(jsonResponse.get("[1].name"));
    }
}
