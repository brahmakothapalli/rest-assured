package workflows;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.HTTPMethods;

import java.util.HashMap;

public class TokenWF {

    public static String getTokenFromConfig(String environment){
        return BaseTest.configurationMap.get("token").toString();
    }

    public static Response createToken(){
        String baseUrl = BaseTest.configurationMap.get("baseUrl").toString();
        String userName = BaseTest.configurationMap.get("userName").toString();
        String password = BaseTest.configurationMap.get("password").toString();
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("username", userName);
        payload.put("password", password);
        String endpoint = "/auth";
        Response response = HTTPMethods.postRequest(baseUrl+endpoint, payload, new HashMap<>());
        return response;
    }
}
