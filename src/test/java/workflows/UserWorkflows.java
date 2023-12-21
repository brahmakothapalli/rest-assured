package workflows;

import base.BaseTest;
import constants.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.HTTPMethods;

import java.util.Map;

import static constants.Endpoints.LIST_OF_USERS;

public class UserWorkflows {

    public static Response getUserWithID(String endPoint, String userId){
        return RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id", userId)
                .when()
                .get(Endpoints.BASE_URL+endPoint)
                .then()
                .extract().response();
    }

    public static Response getUsersList(String queryParam){
        return RestAssured.given().contentType(ContentType.JSON).and()
                .queryParam("number", queryParam).when()
                .get(Endpoints.BASE_URL+LIST_OF_USERS).then()
                .extract().response();
    }

    public static Response createUser(String endPoint, Map<String, Object> payload){
        return HTTPMethods.postRequest(Endpoints.BASE_URL+endPoint, payload, BaseTest.headersMap);
    }
}
