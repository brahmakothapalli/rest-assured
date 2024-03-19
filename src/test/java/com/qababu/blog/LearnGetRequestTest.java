package com.qababu.blog;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class LearnGetRequestTest {

    @Test
    public void testGetListOfUsers(){
        // the base url
        RestAssured.baseURI = "https://reqres.in";
        // the end point
        RestAssured.basePath = "/api/users?page=2";

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .when().get();
//        System.out.println(response.asPrettyString());
        System.out.println("The status code is :: "+response.getStatusCode());
        JsonPath jsonPath = new JsonPath(response.asString());
        System.out.println(jsonPath.get("page").toString());
        System.out.println(jsonPath.get("total").toString());
        System.out.println(jsonPath.get("data").toString());
        List<Object> data = jsonPath.getList("data");
        data.forEach(System.out::println);
    }
}
