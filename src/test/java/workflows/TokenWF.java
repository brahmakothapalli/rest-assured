package workflows;

import base.BaseClass;
import io.restassured.response.Response;
import utilities.HTTPMethods;

import java.util.HashMap;

public class TokenWF {

    public static String getTokenFromConfig(String environment){
        return BaseClass.configurationMap.get("token").toString();
    }

    public static Response createToken(){
        String baseUrl = BaseClass.configurationMap.get("baseUrl").toString();
        String userName = BaseClass.configurationMap.get("userName").toString();
        String password = BaseClass.configurationMap.get("password").toString();
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("username", userName);
        payload.put("password", password);
        String endpoint = "/auth";
        Response response = HTTPMethods.postRequest(baseUrl+endpoint, payload, new HashMap<>());
        return response;
    }
}
