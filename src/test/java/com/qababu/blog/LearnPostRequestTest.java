package com.qababu.blog;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class LearnPostRequestTest {

    @Test
    public void testSendingPostRequest(){
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "/api/users";
        RequestSpecification httpRequest = RestAssured.given().
                header("Content-Type", "application/json").header("Accept", "application/json");
        String body = "{\n" +
                "    \"name\": \"qababu\",\n" +
                "    \"job\": \"QA Lead\"\n" +
                "}";
        httpRequest.body(body);
        Response response = httpRequest.post();
        System.out.println("The status code :: "+response.getStatusCode());
        System.out.println("The response :: "+response.asPrettyString());
    }
}
