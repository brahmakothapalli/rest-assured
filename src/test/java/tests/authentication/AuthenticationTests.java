package tests.authentication;
import utilities.ConfigFileReader;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.Test;
import java.nio.charset.StandardCharsets;

public class AuthenticationTests {

    @Test
    public void testGenerateToken(){
        RestAssured.baseURI = ConfigFileReader.getInstance().getProperty("baseUrl");
        String endPoint = "/Account/v1/GenerateToken";
        String payLoad = "{\n" +
                "  \"userName\": \"TOOLSQA-Test\",\n" +
                "  \"password\": \"Test@@123\"\n" +
                "}";
        Response response = RestAssured.given().header("Content-Type", "application/json").
                and().body(payLoad).when()
                .post(endPoint);
        System.out.println(response.asString());
    }

    @Test
    public void testBasicAuthentication(){
        RestAssured.baseURI = ConfigFileReader.getInstance().getProperty("baseUrl");
        String endPoint = "/BookStore/v1/Books";
        String credentials = "TOOLSQA-Test:Test@@123";

        String payLoad = "{\n" +
                "  \"userId\": \"string\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \"string\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        //encode the credentials
        byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes(StandardCharsets.UTF_8));

        // bytes to string conversion
        String encodedCredentialsAsString = new String(encodedCredentials);

        Response response = RestAssured.given().header("Authorization", "Basic "+encodedCredentialsAsString).header("Content-Type", "application/json").
                when().post(endPoint);
        System.out.println(response.getStatusCode());
        JsonPath jsonResponse = new JsonPath(response.asString());
        System.out.println(jsonResponse);
    }

    @Test
    public void testBearerTokenAuthentication(){
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        // Post request -- header, body
        String endPoint = "/Account/v1/GenerateToken";
        String payLoad = "{\n" +
                "  \"userName\": \"TOOLSQA-Test\",\n" +
                "  \"password\": \"Test@@123\"\n" +
                "}";
        Response responseFromGenerateToken = RestAssured.given().header("Content-Type", "application/json").
                and().body(payLoad).when()
                .post(endPoint);
        JsonPath jsonResponse = new JsonPath(responseFromGenerateToken.getBody().asString());
        String bearerToken = jsonResponse.get("token");
        System.out.println("Token - "+bearerToken);
    }
}
