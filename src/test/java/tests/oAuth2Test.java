package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class oAuth2Test {

    @Test
    public void testingOauth2Authorization(){

        /***
         * client_id, client_secret and grant_type are needed to generate the access token
         *
         */

        Response resp = RestAssured.given().formParam("client_id", "qababuApp")
                .formParam("client_secret", "7a42eb81931d86902c51deb986ce18fe")
                .formParam("grant_type", "client_credentials")
                .post("http://coop.apps.symfonycasts.com/token");

        System.out.println(resp.jsonPath().prettify());
//        System.out.println(resp.jsonPath().get("access_token"));


        RestAssured.given().auth().oauth2((String) resp.jsonPath().get("access_token"))
                .when().post("http://coop.apps.symfonycasts.com/api/3865/chickens-feed").then().assertThat().statusCode(200);


    }
}
