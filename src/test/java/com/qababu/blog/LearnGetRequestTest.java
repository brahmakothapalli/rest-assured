package com.qababu.blog;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LearnGetRequestTest {

    @Test
    public void testGetListOfUsers(){

        // the base url
        RestAssured.baseURI = "https://reqres.in";
        // the end point
        RestAssured.basePath = "/api/users?page=2";

        Response response = RestAssured.given().header("Content-type", "application/json")
                .when().get();
        System.out.println(response.asPrettyString());
        System.out.println("The status code is :: "+response.getStatusCode());
    }
}
