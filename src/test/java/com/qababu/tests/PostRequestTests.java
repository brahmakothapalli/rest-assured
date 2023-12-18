package com.qababu.tests;

import com.qababu.utils.HTTPMethods;
import com.qababu.utils.JsonUtil;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payloads.CreateQuotePayload;

import java.util.HashMap;
import java.util.Map;

public class PostRequestTests {

    String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
    Map<String, String> configMap = JsonUtil.getJsonDataAsMap("qa.json");

    /**
     * Post Request
     * Require - Header (Content Type), Auth and Body
     */
    @Test
    public void createUserTest(){
        String baseUrl = configMap.get("baseUrl");
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer "+configMap.get("token"));
        String product = configMap.get("productId");
        String brokerId = configMap.get("brokerId");
        Map<String, String> payload = CreateQuotePayload.createQuotePayload(product, brokerId);
        Response response = HTTPMethods.postRequest(baseUrl, payload, header);
    }
}
