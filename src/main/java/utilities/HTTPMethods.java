package utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class HTTPMethods {

    public static Response postRequest(String endpoint, Map<String, Object> payload, Map<String, String> headers) {
        return RestAssured.given()
                .headers(headers)
                .baseUri(endpoint)
                .contentType(ContentType.JSON)
                .body(payload)
                .post()
                .then().extract().response();
    }

    public static Response getRequest(String endPoint, Map<String, String> headers) {
        return RestAssured.given()
                .headers(headers)
                .baseUri(endPoint)
                .contentType(ContentType.JSON)
                .get().then()
                .extract().response();
    }

    public static void patchRequest() {

    }

    public static void deleteRequest() {

    }
}
