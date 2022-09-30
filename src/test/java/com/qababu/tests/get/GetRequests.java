package com.qababu.tests.get;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GetRequests {

    @Test
    public void testBookStoreGetRequests(){

        RestAssured.baseURI = "https://bookstore.toolsqa.com";

        Response response = RestAssured.given().get("/BookStore/v1/Books");

        System.out.println("Status Code - "+response.statusCode());
        System.out.println("Content Type - "+response.contentType());
        System.out.println("Response Time - "+response.timeIn(TimeUnit.MILLISECONDS));

    }


    @Test
    public void testGetUser(){
        // Arrange
       // Request Line
        RestAssured.baseURI = "http://localhost:5002/";
        RestAssured.basePath = "api/members";

        // Headers
        Response response = RestAssured.given().auth().basic("admin", "admin")
                .header("Content-Type", "application/json")
                .when()
                .get();

        String responseAsString = response.asPrettyString();
        System.out.println(responseAsString);
        System.out.println(response.getStatusLine());

        JsonPath jsonResponse = new JsonPath(responseAsString);
        System.out.println(jsonResponse.get("name"));
    }

    @Test
    public void testGetQueryParam(){
        // Arrange
        // Request Line
        RestAssured.baseURI = "http://localhost:5002/";
        RestAssured.basePath = "api/members";

        // Headers
        Response response = RestAssured.given().auth().basic("admin", "admin")
                .header("Content-Type", "application/json").queryParam("gender", "male")
                .when()
                .get();

        String responseAsString = response.asPrettyString();
        System.out.println(responseAsString);
        System.out.println(response.getStatusLine());

        JsonPath jsonResponse = new JsonPath(responseAsString);
        System.out.println(jsonResponse.get("name"));
    }

    @Test
    public void testGetPathParam(){
        // Arrange
        // Request Line
        RestAssured.baseURI = "http://localhost:5002/";
        RestAssured.basePath = "api/members"+"/{id}";

        // Headers
        Response response = RestAssured.given().auth().basic("admin", "admin")
                .header("Content-Type", "application/json")
                .pathParam("id", 3).log().all()
                .when()
                .get();

        String responseAsString = response.asPrettyString();
        System.out.println(responseAsString);
        System.out.println(response.getStatusLine());

        JsonPath jsonResponse = new JsonPath(responseAsString);
        System.out.println(jsonResponse.get("name"));
    }
}
